package com.example.healhersoul.Objects;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static  final  String DATABASE_NAME="patient.db";
    public static  final  String TABLE_NAME="patient_table";
    public static  final  String COL_1="Date";
    public static  final  String COL_2="Month";
    public static  final  String COL_3="Year";
    public static  final  String COL_4="Name";
    public static  final  String COL_5="Phone";





    public DatabaseHelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(DATE INTEGER ,MONTH INTEGER,YEAR INTEGER,NAME TEXT,PHONE TEXT)");
        // this will execute our SQL statement & create a table.
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME); // it will drop table if already existing .
        onCreate(db);// this  is again calling onCreate method ,to create a new table ,after deleting the previously existing table.
    }

    public boolean insertData(Integer date,Integer month,Integer year,String name,String phone) // this method is used to insert data in table.
    {
        SQLiteDatabase db=this.getWritableDatabase();// creating SQLite database Object, for getting writable database.

        db.execSQL("delete from "+ TABLE_NAME);// delete previous data.

        ContentValues contentValues=new ContentValues();// creating an object of class "ContentValues" and calling "put" methods on that object to store the value in the desired coloumn,like key-value parameter.
        contentValues.put(COL_1, date);
        contentValues.put(COL_2,month);
        contentValues.put(COL_3,year);
        contentValues.put(COL_4,name);
        contentValues.put(COL_5,phone);
        long result= db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() //This interface provides random read-write access to the result set returned  by a database query.
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery(" select * from "+TABLE_NAME,null);// this will show all data in the table.
        return  res;
    }

}
