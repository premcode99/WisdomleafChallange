package com.example.wisdomleafchallange.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wisdomleafchallange.Adapter.WisdomAdapter;
import com.example.wisdomleafchallange.PresentationModel.Picsum.PicSumDataModel;
import com.example.wisdomleafchallange.R;
import com.example.wisdomleafchallange.Util.NetworkConnectivity;
import com.example.wisdomleafchallange.Util.UiUtils;
import com.example.wisdomleafchallange.WebServiceApi.WisdomAPI;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView wisdomRecyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<PicSumDataModel> postsList = new ArrayList<>();
    WisdomAdapter adapter;
    int pageNum = 0, itemsCount=20, totalNoOfPages=20;
    boolean isLoading = false;
    int prevPageNum = 0;
    int errorCount = 0;
    public ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
    }

    private void initializeViews() {
        wisdomRecyclerView = findViewById(R.id.wisdom_recyclerView);
        progressDialog = new ProgressDialog(MainActivity.this);
        linearLayoutManager = new LinearLayoutManager(this);
        wisdomRecyclerView.setLayoutManager(linearLayoutManager);
        fetchWisdomPicDetails(pageNum);

        wisdomRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = linearLayoutManager.getChildCount();
                int totalItemCount = linearLayoutManager.getItemCount();
                int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();

                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && (firstVisibleItemPosition >= 0)
                        && (totalItemCount >= itemsCount) && (pageNum <= totalNoOfPages) && !isLoading) {
                    if((prevPageNum == pageNum && (errorCount > 0 && errorCount <= 2)) || (prevPageNum != pageNum && (errorCount >= 0 || errorCount <= 2))) {
                            fetchWisdomPicDetails(pageNum);
                    }
                }
            }
        });
    }

    public void showProgressDialog() {
        // display a progress dialog
        progressDialog.setCancelable(false);
        progressDialog.setMessage(getResources().getString(R.string.please_wait));
        progressDialog.show();
    }


    private void fetchWisdomPicDetails(int pageNum) {
        isLoading = true;
        if (!NetworkConnectivity.isConnected(this)) {
            if (errorCount == 0)
                NetworkConnectivity.showNetworkConnectivityErrorAlert(this);
            errorCount++;
            isLoading = false;
            return;
        }

        showProgressDialog();

        WisdomAPI.getWisdomClient().getPicSumData(pageNum,totalNoOfPages, new Callback<ArrayList<PicSumDataModel>>() {
            @Override
            public void success(ArrayList<PicSumDataModel> presentation, Response response) {
                progressDialog.dismiss();
                isLoading = false;
                if (presentation != null && presentation.size() > 0) {
                    postsList.addAll(presentation);
                    adapter = new WisdomAdapter(postsList, MainActivity.this);
                    wisdomRecyclerView.setAdapter(adapter);
                    inflateUI(presentation);
                } else{
                    errorCount++;
                }
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismiss();
                isLoading = false;
                errorCount++;
                if (error != null) {
                        UiUtils.showAlert(MainActivity.this, getString(R.string.error_alert_heading),error.getMessage());

                }
            }
        });
    }

    private void inflateUI(ArrayList<PicSumDataModel> presentation) {
            if (presentation.size() <= 0) {
                if(pageNum == 1)
                    UiUtils.showAlert(this, getResources().getString(R.string.error_alert_heading), getString(R.string.no_data_available));
            } else {
                ArrayList<PicSumDataModel> list = presentation;
                if(pageNum != prevPageNum) {
                    postsList.addAll(list);
                    adapter.notifyDataSetChanged();
                }
                prevPageNum = pageNum;
                errorCount = 0;
                pageNum++;
            }
    }



}