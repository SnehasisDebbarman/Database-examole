package com.example.snehasis.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class UserDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="mtwbut";
    private static final int DB_VERSION=1;
    private static final String TABLE_NAME="users";
    private static final String FIRST_COL="name";
    private static final String SECOND_COL="email";
    private static final String THIRD_COL="phone";
    private static final String CREATE_QUERY="CREATE TABLE "+TABLE_NAME+"("+FIRST_COL
            +" text, "+SECOND_COL+" text, "+THIRD_COL+" text);";

    public UserDbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        Log.i("DB Message","Data base ban gaya bhai");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.i("DB Message","table create ho gya bhai");

    }



    public void insertData(String name,String email,String phone,SQLiteDatabase db){

        ContentValues content=new ContentValues();
        content.put(FIRST_COL,name);
        content.put(SECOND_COL,email);
        content.put(THIRD_COL,phone);

        db.insert(TABLE_NAME,null,content);

        Log.i("DB Message"," row inserted");

    }

    public Cursor viewData(SQLiteDatabase db){ //cursor is a tool to communicate with database
        Cursor c=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return c;
    }

    public Cursor searchData(SQLiteDatabase db,String name){ //cursor is a tool to communicate with database
        Cursor c=db.rawQuery("SELECT * FROM "+TABLE_NAME
                +" WHERE "+FIRST_COL +" LIKE "+ "'"+name+"'",null);
        //SELECT * FROM usres WHERE name like name(rahul)
        return c;
    }

    public int updateData(String name,String phone, String email,SQLiteDatabase db){

        ContentValues content=new ContentValues();

        content.put(FIRST_COL,name);
        content.put(THIRD_COL,phone);

        String where="email=?";
        String[] whereArgs={(String.valueOf(email))};

        int x=db.update(TABLE_NAME,content,where,whereArgs);
        return x;
    }

    public int deleteData(String email, SQLiteDatabase db){
        String where="email=?";
        String[] whereArgs={String.valueOf(email)};
        int x=db.delete(TABLE_NAME,where,whereArgs);
        return x;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //create table users(name text,email text,phone text);

}
