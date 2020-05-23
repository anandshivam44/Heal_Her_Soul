package com.example.healhersoul.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.healhersoul.Activity.LoginPage;
import com.example.healhersoul.R;

public class fragment_tools extends Fragment {
    Button weightTracker;
    Button button2;
    Button button3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Tools");
        return inflater.inflate(R.layout.fragment_tools, container, false);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        weightTracker = getView().findViewById(R.id.weight_tracker);
        button2 = getView().findViewById(R.id.tools_button_2);
        button3 = getView().findViewById(R.id.tools_button_3);


        weightTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation animation_zoom_in = AnimationUtils.loadAnimation(getContext(), R.anim.zoomout_for_tools_button);//make it bigger
                view.startAnimation(animation_zoom_in);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Animation animation_zoom_out = AnimationUtils.loadAnimation(getContext(), R.anim.zoomin_for_tools_button);// make it smaller
                        view.startAnimation(animation_zoom_out);
                    }
                }, 200);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_weight_tracker()).commit();
                    }
                }, 500);


            }
        });
//        button2.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//
//                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
//                    Animation animation_zoom_in = AnimationUtils.loadAnimation(getContext(), R.anim.zoomout_for_tools_button);//make it bigger
//                    view.startAnimation(animation_zoom_in);
//
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            Animation animation_zoom_out = AnimationUtils.loadAnimation(getContext(), R.anim.zoomin_for_tools_button);// make it smaller
//                            view.startAnimation(animation_zoom_out);
//                        }
//                    }, 200);
//
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(getContext(), "Button Clicked", Toast.LENGTH_SHORT).show();
//                        }
//                    }, 500);
//
//                    return true;
//                }
//
//                return false;
//            }
//        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation_zoom_in = AnimationUtils.loadAnimation(getContext(), R.anim.zoomout_for_tools_button);//make it bigger
                view.startAnimation(animation_zoom_in);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Animation animation_zoom_out = AnimationUtils.loadAnimation(getContext(), R.anim.zoomin_for_tools_button);// make it smaller
                        view.startAnimation(animation_zoom_out);
                    }
                }, 200);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "Button Clicked", Toast.LENGTH_SHORT).show();
                    }
                }, 500);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation_zoom_in = AnimationUtils.loadAnimation(getContext(), R.anim.zoomout_for_tools_button);//make it bigger
                view.startAnimation(animation_zoom_in);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Animation animation_zoom_out = AnimationUtils.loadAnimation(getContext(), R.anim.zoomin_for_tools_button);// make it smaller
                        view.startAnimation(animation_zoom_out);
                    }
                }, 200);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "Button Clicked", Toast.LENGTH_SHORT).show();
                    }
                }, 500);
            }
        });
    }
}
