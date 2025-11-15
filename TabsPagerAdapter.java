package com.example.croprecommendationapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.croprecommendationapp.fragment.CropInfoFragment;
import com.example.croprecommendationapp.fragment.FarmingPracticesFragment;
import com.example.croprecommendationapp.fragment.RecommendationFragment;

public class TabsPagerAdapter extends FragmentStateAdapter {

    public TabsPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new RecommendationFragment();
            case 1:
                return new CropInfoFragment();
            case 2:
                return new FarmingPracticesFragment();
            default:
                return new RecommendationFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}