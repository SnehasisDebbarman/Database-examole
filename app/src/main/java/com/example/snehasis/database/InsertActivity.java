package com.example.snehasis.database;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    EditText insertName,insertEmail,insertPhone;
    Button insertBtn;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        insertName=(EditText)findViewById(R.id.insertName);
        insertEmail=(EditText)findViewById(R.id.insertEmail);
        insertPhone=(EditText)findViewById(R.id.insertPhone);
        insertBtn=(Button)findViewById(R.id.insertBtn);
        //int i=0;
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDbHelper user=new UserDbHelper(InsertActivity.this);
                //i=i+1;
                db=user.getWritableDatabase();//permission of write in data base
                user.insertData(insertName.getText().toString(),insertEmail.getText().toString(),
                        insertPhone.getText().toString(),db);
               // UserDbHelper.count1();
                Toast.makeText(InsertActivity.this,"1 row created",Toast.LENGTH_LONG).show();

                insertName.setText("");
                insertEmail.setText("");
                insertPhone.setText("");

            }
        });

    }
}
