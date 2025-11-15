package com.example.croprecommendationapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.croprecommendationapp.MLModel;
import com.example.croprecommendationapp.R;
import com.example.croprecommendationapp.database.CropDatabase;
import java.util.ArrayList;
import java.util.List;

public class CropInfoFragment extends Fragment {

    private Spinner cropSpinner;
    private TextView descriptionText, benefitsText, soilText, climateText;
    private TextView seasonText, yieldText, priceText;
    private MLModel mlModel;
    private List<String> cropsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_crop_info, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cropSpinner = view.findViewById(R.id.cropSpinner);
        descriptionText = view.findViewById(R.id.cropDescription);
        benefitsText = view.findViewById(R.id.cropBenefits);
        soilText = view.findViewById(R.id.cropSoil);
        climateText = view.findViewById(R.id.cropClimate);
        seasonText = view.findViewById(R.id.cropSeason);
        yieldText = view.findViewById(R.id.cropYield);
        priceText = view.findViewById(R.id.cropPrice);

        mlModel = new MLModel(requireContext());
        cropsList = mlModel.getCropsList();

        List<String> displayNames = new ArrayList<>();
        for (String crop : cropsList) {
            displayNames.add(crop.substring(0, 1).toUpperCase() + crop.substring(1));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, displayNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cropSpinner.setAdapter(adapter);

        cropSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateCropInfo(cropsList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        if (!cropsList.isEmpty()) {
            updateCropInfo(cropsList.get(0));
        }
    }

    private void updateCropInfo(String cropName) {
        CropDatabase.CropInfo info = CropDatabase.getCropInfo(cropName);
        descriptionText.setText(info.description);
        benefitsText.setText(info.benefits);
        soilText.setText(info.soilRequirements);
        climateText.setText(info.climateRequirements);
        seasonText.setText(info.bestSeason);
        yieldText.setText(info.yieldPerHectare);
        priceText.setText(info.marketPrice);
    }
}