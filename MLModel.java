package com.example.croprecommendationapp;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class MLModel {
    private static final String TAG = "MLModel";

    private Context context;
    private List<String> cropsList;
    private List<String> featureNames;

    public MLModel(Context context) {
        this.context = context;
        initializeCropsList();
    }

    private void initializeCropsList() {
        cropsList = new ArrayList<>();
        cropsList.add("rice");
        cropsList.add("wheat");
        cropsList.add("maize");
        cropsList.add("cotton");
        cropsList.add("sugarcane");
        cropsList.add("potato");
        cropsList.add("sorghum");
        cropsList.add("groundnut");
        cropsList.add("soybean");

        featureNames = new ArrayList<>();
        featureNames.add("Nitrogen");
        featureNames.add("Phosphorus");
        featureNames.add("Potassium");
        featureNames.add("Temperature");
        featureNames.add("Humidity");
        featureNames.add("pH");
        featureNames.add("Rainfall");
    }

    public PredictionResult predictCrop(double n, double p, double k, double temperature,
                                        double humidity, double ph, double rainfall) {
        try {
            String recommendedCrop = predictUsingRules(n, p, k, temperature, humidity, ph, rainfall);
            double confidence = calculateConfidence(n, p, k, temperature, humidity, ph, rainfall);

            return new PredictionResult(recommendedCrop, confidence, null);
        } catch (Exception e) {
            Log.e(TAG, "Error during prediction", e);
            return new PredictionResult("Error", 0, e.getMessage());
        }
    }

    private String predictUsingRules(double n, double p, double k, double temperature,
                                     double humidity, double ph, double rainfall) {

        if (temperature >= 20 && temperature <= 30 && humidity >= 50 && humidity <= 100
                && ph >= 5.0 && ph <= 7.5 && rainfall >= 150 && rainfall <= 250) {
            return "rice";
        }

        if (temperature >= 15 && temperature <= 27 && humidity >= 40 && humidity <= 80
                && ph >= 6.0 && ph <= 7.8 && rainfall >= 50 && rainfall <= 250) {
            return "wheat";
        }

        if (temperature >= 18 && temperature <= 32 && humidity >= 50 && humidity <= 100
                && ph >= 5.5 && ph <= 7.5 && rainfall >= 150 && rainfall <= 300) {
            return "maize";
        }

        if (temperature >= 20 && temperature <= 35 && humidity >= 40 && humidity <= 90
                && ph >= 6.0 && ph <= 7.5 && rainfall >= 50 && rainfall <= 200) {
            return "cotton";
        }

        if (temperature >= 20 && temperature <= 32 && humidity >= 50 && humidity <= 90
                && ph >= 5.5 && ph <= 7.5 && rainfall >= 100 && rainfall <= 250) {
            return "sugarcane";
        }

        if (temperature >= 15 && temperature <= 25 && humidity >= 50 && humidity <= 100
                && ph >= 5.0 && ph <= 7.0 && rainfall >= 150 && rainfall <= 300) {
            return "potato";
        }

        if (temperature >= 20 && temperature <= 40 && humidity >= 30 && humidity <= 90
                && ph >= 5.5 && ph <= 7.5 && rainfall >= 30 && rainfall <= 150) {
            return "sorghum";
        }

        if (temperature >= 24 && temperature <= 35 && humidity >= 30 && humidity <= 80
                && ph >= 5.5 && ph <= 7.5 && rainfall >= 30 && rainfall <= 100) {
            return "groundnut";
        }

        return "soybean";
    }

    private double calculateConfidence(double n, double p, double k, double temperature,
                                       double humidity, double ph, double rainfall) {
        double confidence = 50.0;

        if (n >= 70 && n <= 120) confidence += 10;
        if (p >= 30 && p <= 80) confidence += 10;
        if (k >= 40 && k <= 120) confidence += 10;
        if (temperature >= 20 && temperature <= 30) confidence += 10;
        if (humidity >= 50 && humidity <= 90) confidence += 5;
        if (ph >= 6.0 && ph <= 7.0) confidence += 3;
        if (rainfall >= 100 && rainfall <= 250) confidence += 2;

        return Math.min(confidence, 98.0);
    }

    public List<String> getCropsList() {
        return cropsList;
    }

    public List<String> getFeatureNames() {
        return featureNames;
    }

    public static class PredictionResult {
        public String crop;
        public double confidence;
        public String error;

        public PredictionResult(String crop, double confidence, String error) {
            this.crop = crop;
            this.confidence = confidence;
            this.error = error;
        }
    }
}