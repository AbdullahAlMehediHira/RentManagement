package com.example.rentapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {



    public DatabaseHelper(Context context) {

        super(context,"Register.db",null,1);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // creating tables
        sqLiteDatabase.execSQL("Create table user(name text , number text primary key)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists user");//drops table if exists

        onCreate(sqLiteDatabase);
    }
    //inserting in database of owners
    public Boolean insert( String name, String number ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("number",number);
        long ins = sqLiteDatabase.insert("user",null,contentValues);
        if(ins==-1) return false;
        else return true;


    }

    // checking if name exists of owners
    public Boolean checkmate(String number){
        SQLiteDatabase  sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from user where number =?",new String[]{number});
        if(cursor.getCount()>0) return false;
        else return true;

    }

    //checking name and number
    public Boolean namenumber(String name , String number){
        SQLiteDatabase  sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from user where name =? and number=?",new String[]{name,number});
        if(cursor.getCount()>0) return true;
        else return false;

    }


}
