package com.example.healhersoul.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.healhersoul.R;
import com.example.healhersoul.Adapters.SliderAdapter;
import com.example.healhersoul.Objects.SliderItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class fragment_articles extends Fragment {
    private ViewPager2 viewPager2;
    Handler sliderHandler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        getActivity().setTitle("Articles");
//        getActivity().(Window.FEATURE_NO_TITLE); //will hide the title
//        getSupportActionBar().hide(); // hide the title bar
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_navigation);
//        navBar.setItemIconSize(0);
        return inflater.inflate(R.layout.fragment_articles, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager2 = getView().findViewById(R.id.viewPagerImageSlider);
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.image_1));
        sliderItems.add(new SliderItem(R.drawable.image_2));
        sliderItems.add(new SliderItem(R.drawable.image_3));
        sliderItems.add(new SliderItem(R.drawable.image_4));
        sliderItems.add(new SliderItem(R.drawable.image_5));
        sliderItems.add(new SliderItem(R.drawable.image_6));
        sliderItems.add(new SliderItem(R.drawable.image_7));
        sliderItems.add(new SliderItem(R.drawable.image_8));
        sliderItems.add(new SliderItem(R.drawable.image_9));
        sliderItems.add(new SliderItem(R.drawable.image_10));
        sliderItems.add(new SliderItem(R.drawable.image_11));
        String body="In 1948, the World Health Organization (WHO) defined health with a phrase that modern authorities still apply.Health is a state of complete physical, mental, and social well-being and not merely the absence of disease or infirmity. In 1986, the WHO made further clarifications: A resource for everyday life, not the objective of living. Health is a positive concept emphasizing social and personal resources, as well as physical capacities.";

        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2,body));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleX(0.85f + r * 0.145f);
//                 final float MIN_SCALE = 0.65f;
//                if (position < -1) {
//                    page.setAlpha(0);
//                } else if (position <= 0) {
//                    page.setAlpha(1);
//                    page.setTranslationX(page.getWidth() * -position);
//                    page.setTranslationY(page.getHeight() * position);
//                    page.setScaleX(1);
//                    page.setScaleY(1);
//                } else if (position <= 1) {
//                    page.setAlpha(1 - position);
//                    page.setTranslationX(page.getWidth() * -position);
//                    page.setTranslationY(0);
//                    float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
//                    page.setScaleX(scaleFactor);
//                    page.setScaleY(scaleFactor);
//
//                } else if (position > 1){
//                    page.setAlpha(0);
//                }

            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_navigation);
        navBar.setVisibility(View.VISIBLE);
    }
}
