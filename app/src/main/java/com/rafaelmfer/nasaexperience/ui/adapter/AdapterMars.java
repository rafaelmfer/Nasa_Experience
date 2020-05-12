package com.rafaelmfer.nasaexperience.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rafaelmfer.nasaexperience.R;
import com.rafaelmfer.nasaexperience.model.PostsMars;

import java.util.List;

public class AdapterMars extends RecyclerView.Adapter<AdapterMars.MyViewHolderMars> {
    public List<PostsMars> posts;

    public AdapterMars(List<PostsMars> listPosts) {
        this.posts = listPosts;
    }

    @NonNull
    @Override
    public MyViewHolderMars onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemListMars = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_suns_mars_card, parent, false);
        return new MyViewHolderMars(itemListMars);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderMars holder, int position) {
        PostsMars post = posts.get(position);
        holder.tvSunsNumberMars.setText(post.getTvSunsNumberMars());
        holder.tvDateObservationMars.setText(post.getTvDateObservationMars());
        holder.tvPressure.setText(post.getTvPressure());
        holder.tvWindSpeed.setText(post.getTvWindSpeed());
        holder.tvTemperature.setText(post.getTvTemperature());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class MyViewHolderMars extends RecyclerView.ViewHolder {

        TextView tvSunsNumberMars, tvDateObservationMars, tvWindSpeed, tvTemperature, tvPressure;

        public MyViewHolderMars(@NonNull View itemView) {
            super(itemView);
            tvTemperature = itemView.findViewById(R.id.temperature_mars);
            tvDateObservationMars = itemView.findViewById(R.id.date_observation_mars);
            tvPressure = itemView.findViewById(R.id.pressure_mars);
            tvSunsNumberMars = itemView.findViewById(R.id.suns_number_mars);
            tvWindSpeed = itemView.findViewById(R.id.wind_speed_mars);
        }
    }
}
