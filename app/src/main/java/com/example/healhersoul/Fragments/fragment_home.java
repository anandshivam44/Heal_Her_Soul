package com.example.healhersoul.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.healhersoul.Adapters.SliderAdapter_workshop;
import com.example.healhersoul.Objects.SliderItem;
import com.example.healhersoul.R;

import java.util.ArrayList;
import java.util.List;

public class fragment_home extends Fragment {
    private ViewPager2 viewPager2;
    private Handler SliderHandler=new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Home");
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewPager2 = getActivity().findViewById(R.id.viewPagerImageSlider_workshop);
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem("workshop on nutrition ",R.drawable.image_10));
        sliderItems.add(new SliderItem("workshop on chlid care",R.drawable.parents123));
        sliderItems.add(new SliderItem("workshop on parenting",R.drawable.pregnant));
        sliderItems.add(new SliderItem("workshop on daily routine",R.drawable.image_5));
        sliderItems.add(new SliderItem("workshop on diet",R.drawable.image_1));




        viewPager2.setAdapter(new SliderAdapter_workshop(sliderItems, viewPager2));

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
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                SliderHandler.removeCallbacks(SliderRunnble);
                SliderHandler.postDelayed(SliderRunnble,2000); //2 sec delay
            }
        });
    }

    private Runnable SliderRunnble=new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        SliderHandler.removeCallbacks(SliderRunnble);
    }

    @Override
    public void onResume() {
        super.onResume();
        SliderHandler.postDelayed(SliderRunnble,2000);
    }
}
