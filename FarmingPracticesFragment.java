package com.example.croprecommendationapp.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.croprecommendationapp.R;
import com.example.croprecommendationapp.adapter.PracticesAdapter;
import com.example.croprecommendationapp.database.FarmingPractices;
import com.example.croprecommendationapp.database.FarmingPractices.Practice;
import java.util.List;

public class FarmingPracticesFragment extends Fragment implements PracticesAdapter.OnPracticeClickListener {

    private RecyclerView practicesRecyclerView;
    private PracticesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_farming_practices, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        practicesRecyclerView = view.findViewById(R.id.practicesRecyclerView);
        practicesRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<Practice> practices = FarmingPractices.getAllPractices();
        adapter = new PracticesAdapter(practices, requireContext(), this);
        practicesRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onPracticeClick(Practice practice) {
        showPracticeDetails(practice);
    }

    private void showPracticeDetails(Practice practice) {
        LayoutInflater inflater = LayoutInflater.from(requireContext());
        View detailsView = inflater.inflate(R.layout.dialog_practice_details, null);

        TextView titleText = detailsView.findViewById(R.id.detailsTitle);
        TextView benefitsText = detailsView.findViewById(R.id.detailsBenefits);
        TextView implementationText = detailsView.findViewById(R.id.detailsImplementation);
        TextView toolsText = detailsView.findViewById(R.id.detailsTools);
        TextView costText = detailsView.findViewById(R.id.detailsCost);

        titleText.setText(practice.title);
        benefitsText.setText(practice.benefits);
        implementationText.setText(practice.implementation);
        toolsText.setText(practice.tools);
        costText.setText(practice.cost);

        new AlertDialog.Builder(requireContext())
                .setView(detailsView)
                .setPositiveButton("Close", (dialog, which) -> dialog.dismiss())
                .show();
    }
}