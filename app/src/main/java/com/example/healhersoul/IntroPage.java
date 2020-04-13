package com.example.healhersoul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class IntroPage extends AppCompatActivity {
   private CarouselView carouselView;
   private int[] sampleImages = {R.drawable.dr, R.drawable.group2, R.drawable.happy3, R.drawable.birthrate, R.drawable.pregnantfirst
           , R.drawable.thebabyscan, R.drawable.pregnanter, R.drawable.pregnantmom, R.drawable.womanpregnant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);
        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

    }
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}
