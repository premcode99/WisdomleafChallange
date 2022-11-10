package com.example.wisdomleafchallange.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wisdomleafchallange.Activity.MainActivity;
import com.example.wisdomleafchallange.PresentationModel.Picsum.PicSumDataModel;

import java.util.ArrayList;

public class WisdomAdapter extends  RecyclerView.Adapter<WisdomAdapter.MyViewHolder>{

    public  ArrayList<PicSumDataModel> wisdomDataList;
    public Context context;

    public WisdomAdapter(ArrayList<PicSumDataModel> wisdomDataList, Context context) {
        this.wisdomDataList = wisdomDataList;
        this.context = context;
    }

    @NonNull
    @Override
    public WisdomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull WisdomAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
