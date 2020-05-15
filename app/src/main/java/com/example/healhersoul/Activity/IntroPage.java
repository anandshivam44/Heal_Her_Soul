package com.example.healhersoul.Activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.healhersoul.R;
import com.hololo.tutorial.library.PermissionStep;
import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class IntroPage extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addFragment(
                new Step.Builder()
                        .setTitle(getString(R.string.page_0_title))
                        .setContent(getString(R.string.page_0_content))
                        .setBackgroundColor(Color.parseColor("#FF0957"))//  #CA70F3
                        .setDrawable(R.drawable.fig_del)
                        .setSummary(getString(R.string.page_0_summary))
                        .build());
        addFragment(
                new Step.Builder()
                        .setTitle(getString(R.string.page_1_title))
                        .setContent(getString(R.string.page_1_content))
                        .setBackgroundColor(Color.parseColor("#99FF0957"))
                        .setDrawable(R.drawable.fig_1)
                        .setSummary(getString(R.string.page_1_summary))
                        .build());
        addFragment(
                new Step.Builder()
                        .setTitle(getString(R.string.page_2_title))
                        .setContent(getString(R.string.page_2_content))
                        .setBackgroundColor(Color.parseColor("#00D4BA"))
                        .setDrawable(R.drawable.fig_2)
                        .setSummary(getString(R.string.page_2_summary))
                        .build());
        addFragment(
                new Step.Builder()
                        .setTitle(getString(R.string.page_3_title))
                        .setContent(getString(R.string.page_3_content))
                        .setBackgroundColor(Color.parseColor("#1098FE"))
                        .setDrawable(R.drawable.fig_3)
                        .setSummary(getString(R.string.page_3_summary))
                        .build());

        addFragment(
                new PermissionStep
                        .Builder()
                        .setPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.SEND_SMS,Manifest.permission.READ_SMS,Manifest.permission.RECEIVE_SMS})
                        .setTitle(getString(R.string.page_4_title)).setContent(getString(R.string.page_4_content))
                        .setBackgroundColor(Color.parseColor("#8BCEAB"))//#8BCEAB
                        .setDrawable(R.drawable.fig_4)
                        .setSummary(getString(R.string.page_4_summary))
                        .build());
    }

    @Override
    public void finishTutorial() {
        Toast.makeText(this, "Tutorial finished", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(IntroPage.this, LoginPage.class);
        startActivity(intent);
        //finish();
    }

    @Override
    public void currentFragmentPosition(int position) {
        Toast.makeText(this, "Position : " + position, Toast.LENGTH_SHORT).show();
    }

}
