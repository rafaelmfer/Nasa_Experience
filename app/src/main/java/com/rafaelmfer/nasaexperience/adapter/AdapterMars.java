package com.rafaelmfer.nasaexperience.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rafaelmfer.nasaexperience.R;
import com.rafaelmfer.nasaexperience.modelMars.Posts;

import java.util.List;

public class AdapterMars extends RecyclerView.Adapter<AdapterMars.MyViewHolderMars> {
    public List<Posts> posts;
    public AdapterMars(List<Posts> ListPosts) {
        this.posts = ListPosts;
    }

    @NonNull
    @Override
    public MyViewHolderMars onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemListMars = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_suns_mars_card, parent,false);
        return new MyViewHolderMars(itemListMars);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderMars holder, int position) {
        Posts post = posts.get(position);
        holder.tvSunsNumberMars.setText(post.getTvSunsNumberMars());
        holder.tvDateObservationMars.setText(post.getTvDateObservationMars());
        holder.tvPressure.setText(post.getTvPressure());
        holder.tvWindSpeed.setText(post.getTvWindSpeed());
        holder.tvTemperature.setText(post.getTvTemperature());
        holder.vDecoratorSuns.getContext();
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class MyViewHolderMars extends RecyclerView.ViewHolder{

        TextView tvSunsNumberMars;
        TextView tvDateObservationMars;
        View vDecoratorSuns;
        TextView tvWindSpeed;
        TextView tvTemperature;
        TextView tvPressure;
        public MyViewHolderMars(@NonNull View itemView) {
            super(itemView);
            tvTemperature = itemView.findViewById(R.id.tvTemperature);
            tvDateObservationMars = itemView.findViewById(R.id.tvDateObservationMars);
            tvPressure = itemView.findViewById(R.id.tvPressure);
            tvSunsNumberMars = itemView.findViewById(R.id.tvSunsNumberMars);
            tvWindSpeed = itemView.findViewById(R.id.tvWindSpeed);
            vDecoratorSuns = itemView.findViewById(R.id.vDecoratorSuns);
        }
    }
}
