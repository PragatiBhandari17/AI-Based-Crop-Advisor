package com.example.croprecommendationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout; // ✅ Import LinearLayout instead of TextView
import com.example.croprecommendationapp.adapter.TabsPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private LinearLayout backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        backButton = findViewById(R.id.backButton);

        // Setup ViewPager
        TabsPagerAdapter adapter = new TabsPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // Connect TabLayout with ViewPager
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Recommendation");
                    break;
                case 1:
                    tab.setText("Crops Info");
                    break;
                case 2:
                    tab.setText("Modern Farming");
                    break;
            }
        }).attach();

        // Get tab index from intent
        int tabIndex = getIntent().getIntExtra("TAB_INDEX", 0);
        viewPager.setCurrentItem(tabIndex, false);

        // Back button functionality
        backButton.setOnClickListener(v -> finish());
    }
}
