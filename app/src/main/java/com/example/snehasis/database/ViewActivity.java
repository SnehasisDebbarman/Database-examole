package com.example.snehasis.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    TextView result;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        result=(TextView)findViewById(R.id.result);

        UserDbHelper user=new UserDbHelper(ViewActivity.this);
        db=user.getReadableDatabase();
        Cursor c= user.viewData(db);
        if(c.getCount()==0){
            result.setText("no user found");
        }
        else{
            c.moveToFirst();// to ensure  print start from first user
            StringBuffer sb=new StringBuffer();
            do{
               sb.append("Name : "+c.getString(0)+"\n");
               sb.append("EMail: "+c.getString(1)+"\n");
               sb.append("Phone: "+c.getString(2)+"\n\n");


            }while(c.moveToNext());
            result.setText(sb.toString());

        }

    }
}
