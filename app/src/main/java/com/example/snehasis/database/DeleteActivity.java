package com.example.snehasis.database;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    EditText deleteEmail;
    Button deleteBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        deleteEmail=(EditText)findViewById(R.id.deleteEmail);
        deleteBtn1=(Button)findViewById(R.id.deleteBtn1);

        deleteBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDbHelper user=new UserDbHelper(DeleteActivity.this);
                SQLiteDatabase db;
                db=user.getWritableDatabase();
                int x=user.deleteData(deleteEmail.getText().toString(),db);
                if(x>0){
                    Toast.makeText(DeleteActivity.this, "successfull", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(DeleteActivity.this, "check the code //error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
