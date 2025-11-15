package com.example.croprecommendationapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.example.croprecommendationapp.MLModel;
import com.example.croprecommendationapp.R;

public class RecommendationFragment extends Fragment {

    private EditText nitrogenInput, phosphorusInput, potassiumInput;
    private EditText temperatureInput, humidityInput, phInput, rainfallInput;
    private Button recommendButton;
    private LinearLayout resultCard;
    private TextView cropNameText, confidenceText;
    private MLModel mlModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recommendation, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nitrogenInput = view.findViewById(R.id.nitrogenInput);
        phosphorusInput = view.findViewById(R.id.phosphorusInput);
        potassiumInput = view.findViewById(R.id.potassiumInput);
        temperatureInput = view.findViewById(R.id.temperatureInput);
        humidityInput = view.findViewById(R.id.humidityInput);
        phInput = view.findViewById(R.id.phInput);
        rainfallInput = view.findViewById(R.id.rainfallInput);
        recommendButton = view.findViewById(R.id.recommendButton);
        resultCard = view.findViewById(R.id.resultCard);
        cropNameText = view.findViewById(R.id.cropNameText);
        confidenceText = view.findViewById(R.id.confidenceText);

        mlModel = new MLModel(requireContext());
        recommendButton.setOnClickListener(v -> onRecommend());
    }

    private void onRecommend() {
        try {
            double n = getInputValue(nitrogenInput);
            double p = getInputValue(phosphorusInput);
            double k = getInputValue(potassiumInput);
            double temp = getInputValue(temperatureInput);
            double humidity = getInputValue(humidityInput);
            double ph = getInputValue(phInput);
            double rainfall = getInputValue(rainfallInput);

            if (n == -1 || p == -1 || k == -1 || temp == -1 || humidity == -1 || ph == -1 || rainfall == -1) {
                Toast.makeText(getContext(), "Please enter valid numbers", Toast.LENGTH_SHORT).show();
                return;
            }

            MLModel.PredictionResult result = mlModel.predictCrop(n, p, k, temp, humidity, ph, rainfall);

            if (result.error != null) {
                Toast.makeText(getContext(), "Error: " + result.error, Toast.LENGTH_SHORT).show();
                return;
            }

            displayResult(result.crop, result.confidence);
        } catch (Exception e) {
            Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private double getInputValue(EditText editText) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty()) return -1;
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void displayResult(String cropName, double confidence) {
        resultCard.setVisibility(View.VISIBLE);
        String formattedName = cropName.substring(0, 1).toUpperCase() + cropName.substring(1);
        cropNameText.setText(formattedName);
        confidenceText.setText(String.format("%.1f%%", confidence));
    }
}