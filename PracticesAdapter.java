package com.example.croprecommendationapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.croprecommendationapp.R;
import com.example.croprecommendationapp.database.FarmingPractices.Practice;

import java.util.List;

public class PracticesAdapter extends RecyclerView.Adapter<PracticesAdapter.ViewHolder> {

    private List<Practice> practices;
    private Context context;
    private OnPracticeClickListener listener;

    public interface OnPracticeClickListener {
        void onPracticeClick(Practice practice);
    }

    public PracticesAdapter(List<Practice> practices, Context context, OnPracticeClickListener listener) {
        this.practices = practices;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_practice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Practice practice = practices.get(position);

        holder.titleView.setText(practice.title);
        holder.descriptionView.setText(practice.description);

        holder.detailsBtn.setOnClickListener(v -> {
            if (listener != null) {
                listener.onPracticeClick(practice);
            }
        });
    }

    @Override
    public int getItemCount() {
        return practices.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleView;
        TextView descriptionView;
        Button detailsBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.practiceTitle);
            descriptionView = itemView.findViewById(R.id.practiceDescription);
            detailsBtn = itemView.findViewById(R.id.practiceDetailsBtn);
        }
    }
}