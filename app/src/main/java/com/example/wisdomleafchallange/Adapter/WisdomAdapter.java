package com.example.wisdomleafchallange.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wisdomleafchallange.PresentationModel.Picsum.PicSumDataModel;
import com.example.wisdomleafchallange.R;

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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        WisdomAdapter.MyViewHolder viewHolder = new WisdomAdapter.MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WisdomAdapter.MyViewHolder holder, int position) {
        holder.titleTextView.setText(wisdomDataList.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return wisdomDataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTextView;
        public View itemView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            titleTextView = itemView.findViewById(R.id.title_item);
        }
    }
}
