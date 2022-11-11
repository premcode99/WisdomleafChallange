package com.example.wisdomleafchallange.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wisdomleafchallange.PresentationModel.Picsum.PicSumDataModel;
import com.example.wisdomleafchallange.R;
import com.example.wisdomleafchallange.Util.UiUtils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

import okhttp3.OkHttpClient;

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
        if(wisdomDataList.size() > 0 ) {
            if(wisdomDataList.get(position).getAuthor() != null) {
                holder.titleText.setText(wisdomDataList.get(position).getAuthor());
                holder.descriptionText.setText(wisdomDataList.get(position).getAuthor());
            }
            if(wisdomDataList.get(position).getDownload_url() != null)
            {
                Picasso.get().load(wisdomDataList.get(position).getDownload_url()).placeholder(R.drawable.ic_baseline_image_search_24)// Place holder image from drawable folder
                        .error(R.drawable.ic_baseline_image_search_24).resize(110, 110).centerCrop().into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.loadingText.setVisibility(View.GONE);
                    }
                    @Override
                    public void onError(Exception e) {

                    }
                });
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDialogContent(wisdomDataList.get(position).getAuthor());
                }
            });
        }

    }

    private void showDialogContent(String author) {
        UiUtils.showAlert((Activity)context ,context.getResources().getString(R.string.app_name),author);
    }

    @Override
    public int getItemCount() {
        return wisdomDataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView titleText;
        public View itemView;
        public TextView descriptionText;
        public ImageView imageView;
        public TextView loadingText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            titleText = itemView.findViewById(R.id.title_item);
            descriptionText = itemView.findViewById(R.id.description_item);
            imageView = itemView.findViewById(R.id.imageview_item);
            loadingText = itemView.findViewById(R.id.image_loading);
        }
    }
}
