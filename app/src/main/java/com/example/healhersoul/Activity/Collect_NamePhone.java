package com.example.healhersoul.Activity;

import android.database.Cursor;
import android.os.Bundle;

import com.example.healhersoul.Objects.DatabaseHelper;
import com.example.healhersoul.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Collect_NamePhone extends AppCompatActivity {
    private EditText name,phone;
    private Button btnSubmit;
    DatabaseHelper myDb;
    Integer dd=0,mm=0,yy=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect__name_phone);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myDb=new DatabaseHelper(this);
        name=findViewById(R.id.txt_name);
        phone=findViewById(R.id.txt_phone);
        btnSubmit=findViewById(R.id.submit_btn);

   btnSubmit.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           addData();
           viewData();
       }
   });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });


    }
    public void addData()
    {
        String NAME=name.getText().toString();
        String PHONE=phone.getText().toString();

        boolean isInserted= myDb.insertData(dd,mm,yy,NAME,PHONE);

        if(isInserted==true)
            Toast.makeText(getApplicationContext(),"DATE STORED ",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(),"DATE NOT STORED",Toast.LENGTH_LONG).show();
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
            buffer.append("Month:" + res.getString(2) + "\n");
            buffer.append("Name:" + res.getString(3) + "\n");
            buffer.append("Phone:" + res.getString(4) + "\n\n");


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
