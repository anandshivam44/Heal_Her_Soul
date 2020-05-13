package com.example.healhersoul;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class fragment_articles extends Fragment {
    private ViewPager2 viewPager2;
    Handler sliderHandler = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Articles");
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

    }
}
