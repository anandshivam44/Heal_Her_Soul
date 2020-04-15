package com.example.healhersoul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Logo extends AppCompatActivity {
    ImageView logoForAnimation;
    TextView appNameForAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        logoForAnimation=findViewById(R.id.logo);
        appNameForAnimation=findViewById(R.id.this_is_app_name);

        Animation animation_image= AnimationUtils.loadAnimation(this,R.anim.logo_anim);
        Animation animation_appname= AnimationUtils.loadAnimation(this,R.anim.text_anim);

        logoForAnimation.startAnimation(animation_image);
        appNameForAnimation.startAnimation(animation_appname);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Logo.this,IntroPage.class);
                startActivity(intent);
                //finish();
            }
        },7000);


    }
}
