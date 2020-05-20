package com.example.healhersoul.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
//import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.healhersoul.R;

public class CollectDetailsActivity extends AppCompatActivity {

    CalendarView calendarView;
    String TAG = "MyTag";
    Button nextButton;
    int dd, mm, yy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_details);
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#574b90"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
//        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>      Select Date </font>"));

        calendarView = findViewById(R.id.calendar_view);
        nextButton = findViewById(R.id.nextButton);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                dd = i2;
                mm = i1 + 1;//month is based on index
                yy = i;
                Toast.makeText(CollectDetailsActivity.this, dd+"/"+mm+"/"+yy, Toast.LENGTH_SHORT).show();
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CollectDetailsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
