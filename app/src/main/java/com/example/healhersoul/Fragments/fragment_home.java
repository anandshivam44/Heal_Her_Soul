package com.example.healhersoul.Fragments;

import android.os.Bundle;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.healhersoul.Adapters.SliderAdapter_article_in_home;
import com.example.healhersoul.Adapters.SliderAdapter_workshop;
import com.example.healhersoul.Objects.SliderItem;
import com.example.healhersoul.R;
import com.github.lzyzsd.circleprogress.ArcProgress;
import com.github.lzyzsd.circleprogress.DonutProgress;

import java.util.ArrayList;
import java.util.List;

public class fragment_home extends Fragment {
    private ViewPager2 viewPager2ForArticle;
    private Handler SliderHandlerForArticle = new Handler();

    private ViewPager2 viewPager2ForWorkshop;
    private Handler SliderHandlerForWorkshop = new Handler();

    ArcProgress arcProgress;//progressBar


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Home");
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        long noOfDaysBetween = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDate dateBefore = LocalDate.of(2020, Month.JANUARY, 1);
            LocalDate dateAfter = LocalDate.of(2020, Month.MAY, 2);
            noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        }

        List<SliderItem> sliderItemsForArticles = new ArrayList<>();//fragment data temp
        sliderItemsForArticles.add(new SliderItem("Article title here in one line", R.drawable.image_1));
        sliderItemsForArticles.add(new SliderItem("Article title here in one line", R.drawable.image_2));
        sliderItemsForArticles.add(new SliderItem("Article title here in one line", R.drawable.image_3));
        sliderItemsForArticles.add(new SliderItem("Article title here in one line", R.drawable.image_4));
        sliderItemsForArticles.add(new SliderItem("Article title here in one line", R.drawable.image_5));
        sliderItemsForArticles.add(new SliderItem("Article title here in one line", R.drawable.image_6));
        sliderItemsForArticles.add(new SliderItem("Article title here in one line", R.drawable.image_7));
        sliderItemsForArticles.add(new SliderItem("Article title here in one line", R.drawable.image_8));
        sliderItemsForArticles.add(new SliderItem("Article title here in one line", R.drawable.image_9));
        sliderItemsForArticles.add(new SliderItem("Article title here in one line", R.drawable.image_10));
        sliderItemsForArticles.add(new SliderItem("Article title here in one line", R.drawable.image_11));
        viewPager2ForArticle = getActivity().findViewById(R.id.viewPagerImageSlider_article);
        viewPager2ForArticle.setAdapter(new SliderAdapter_article_in_home(sliderItemsForArticles, viewPager2ForArticle));


        //workshop part below
        viewPager2ForWorkshop = getActivity().findViewById(R.id.viewPagerImageSlider_workshop);
        List<SliderItem> sliderItemsForWorkshop = new ArrayList<>();
        sliderItemsForWorkshop.add(new SliderItem("workshop on nutrition ", R.drawable.image_10));
        sliderItemsForWorkshop.add(new SliderItem("workshop on chlid care", R.drawable.parents123));
        sliderItemsForWorkshop.add(new SliderItem("workshop on parenting", R.drawable.pregnant));
        sliderItemsForWorkshop.add(new SliderItem("workshop on daily routine", R.drawable.image_5));
        sliderItemsForWorkshop.add(new SliderItem("workshop on diet", R.drawable.image_1));

        viewPager2ForWorkshop.setAdapter(new SliderAdapter_workshop(sliderItemsForWorkshop, viewPager2ForWorkshop));

        viewPager2ForWorkshop.setClipToPadding(false);
        viewPager2ForWorkshop.setClipChildren(false);
        viewPager2ForWorkshop.setOffscreenPageLimit(3);
        viewPager2ForWorkshop.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformerForWorkshop = new CompositePageTransformer();
        compositePageTransformerForWorkshop.addTransformer(new MarginPageTransformer(40));
        compositePageTransformerForWorkshop.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        viewPager2ForWorkshop.setPageTransformer(compositePageTransformerForWorkshop);
        viewPager2ForWorkshop.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                SliderHandlerForWorkshop.removeCallbacks(SliderRunnbleForWorkshop);
                SliderHandlerForWorkshop.postDelayed(SliderRunnbleForWorkshop, 2000); //2 sec delay
            }
        });
/**setting values to progress bar*/
        arcProgress = getActivity().findViewById(R.id.arc_progress);
        int d= (int) ((28000.0 - noOfDaysBetween*100) / 280.0);
        arcProgress.setProgress(d) ;//
        Log.d("MyTag", "Days : " + d);

        arcProgress.setStrokeWidth(50);


    }


    private Runnable SliderRunnbleForWorkshop = new Runnable() {
        @Override
        public void run() {
            viewPager2ForWorkshop.setCurrentItem(viewPager2ForWorkshop.getCurrentItem() + 1);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        SliderHandlerForWorkshop.removeCallbacks(SliderRunnbleForWorkshop);
    }

    @Override
    public void onResume() {
        super.onResume();
        SliderHandlerForWorkshop.postDelayed(SliderRunnbleForWorkshop, 2000);
    }
}
