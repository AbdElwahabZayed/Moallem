package com.task.moallem.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.task.moallem.R;
import com.task.moallem.model.Video;
import com.task.moallem.view.PlayVideoActivity;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.AdapterHolder> {

    private final Context context;
    private List<Video> videos;

    public VideoAdapter(Context context) {
        this.context=context;
    }

    public void setAapterData(List<Video>  videos){
        this.videos=videos;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterHolder myHolder=new AdapterHolder(LayoutInflater.from(context).inflate(R.layout.item_video, parent, false));

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder holder, int position) {
        Video video=videos.get(position);
        holder.imageView.setImageResource(video.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, PlayVideoActivity.class);
                i.putExtra("SelectedVideo", video);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videos!=null?videos.size():0;
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView_video_thumb);
        }
    }
}
