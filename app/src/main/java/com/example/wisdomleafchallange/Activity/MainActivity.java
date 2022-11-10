package com.example.wisdomleafchallange.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.wisdomleafchallange.Adapter.WisdomAdapter;
import com.example.wisdomleafchallange.PresentationModel.Picsum.PicSumDataModel;
import com.example.wisdomleafchallange.PresentationModel.Picsum.PicSumPresentation;
import com.example.wisdomleafchallange.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView wisdomRecyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<PicSumDataModel> postsList = new ArrayList<>();
    WisdomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
    }

    private void initializeViews() {
        wisdomRecyclerView = findViewById(R.id.wisdom_recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        wisdomRecyclerView.setItemAnimator(null);
        wisdomRecyclerView.setLayoutManager(linearLayoutManager);
        setAdapter();
    }

    private void setAdapter() {
            adapter = new WisdomAdapter(postsList, MainActivity.this);
    }


}