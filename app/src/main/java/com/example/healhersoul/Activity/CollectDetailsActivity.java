package com.example.healhersoul.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.healhersoul.Objects.DatabaseHelper;
import com.example.healhersoul.R;

public class CollectDetailsActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    CalendarView calendarView;
    String TAG = "MyTag";
    Button nextButton;
    int dd, mm, yy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_details);

        myDb=new DatabaseHelper(this);//creating object of DatabaseHelper class

        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#FFFFFF"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>      Select Date </font>"));

        calendarView = findViewById(R.id.calendar_view);
        nextButton = findViewById(R.id.nextButton);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                dd = i2;
                mm = i1 + 1;//month is based on index
                yy = i;
                Log.d(TAG, " Date " + i + " : " + i1 + " : " + i2);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
                viewData();
              Intent intent = new Intent(CollectDetailsActivity.this, MainActivity.class);
              startActivity(intent);
            }
        });

    }
    //*******************************************************
    public void addData()
    {
        boolean isInserted= myDb.insertData(dd,mm,yy);

        if(isInserted==true)
            Toast.makeText(CollectDetailsActivity.this,"DATE STORED ",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(CollectDetailsActivity.this,"DATE NOT STORED",Toast.LENGTH_LONG).show();
    }
//*******************************************
    public void viewData()
    {
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            //show message
            showMessage("Error","Date not selected");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Date:" + res.getString(0) + "\n");
            buffer.append("Month:" + res.getString(1) + "\n");
            buffer.append("Year:" + res.getString(2) + "\n\n");


        }
        showMessage("Date",buffer.toString()); //show the data.

    }
    public  void showMessage(String Title,String Message) // showing a alert dialog box.
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(Title);
        builder.setMessage(Message);
        builder.show();
    }
}
