package com.rafaelmfer.nasaexperience;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterMars extends RecyclerView.Adapter<ViewHolderMars> {

    private List<MarsModel> suns;

    public AdapterMars(List<MarsModel> listSuns) {
        this.suns = listSuns;
    }

    @NonNull
    @Override
    public ViewHolderMars onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View sunsList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_suns_mars_card, parent, false);

        return new ViewHolderMars(sunsList);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMars holder, int position) {

        MarsModel sunModel = suns.get(position);
        holder.tvSunsNumber.setText(sunModel.getSunNumber());
        holder.tvDateObservation.setText(sunModel.getSunDateObservation());
        holder.tvTemperature.setText(sunModel.getSunTemperature());
        holder.tvWindSpeed.setText(sunModel.getSunWindSpeed());
        holder.tvPressure.setText(sunModel.getSunPressure());

    }

    @Override
    public int getItemCount() {
        return suns.size();
    }
}
