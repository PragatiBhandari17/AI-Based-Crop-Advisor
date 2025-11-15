package com.example.croprecommendationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    private CardView cardRecommendation;
    private CardView cardCropInfo;
    private CardView cardFarmingPractices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize cards
        cardRecommendation = findViewById(R.id.cardRecommendation);
        cardCropInfo = findViewById(R.id.cardCropInfo);
        cardFarmingPractices = findViewById(R.id.cardFarmingPractices);

        // Set click listeners
        cardRecommendation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFeature(0); // Open recommendation tab
            }
        });

        cardCropInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFeature(1); // Open crops info tab
            }
        });

        cardFarmingPractices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFeature(2); // Open farming practices tab
            }
        });
    }

    private void openFeature(int tabIndex) {
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        intent.putExtra("TAB_INDEX", tabIndex);
        startActivity(intent);
    }
}