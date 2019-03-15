package com.example.snehasis.database;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText updateName,updatePhone,updateEmail;
    Button updateBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        updateName=(EditText)findViewById(R.id.updateName);
        updatePhone=(EditText)findViewById(R.id.updatePhone);
        updateEmail=(EditText)findViewById(R.id.updateEmail);
        updateBtn1=(Button)findViewById(R.id.updateBtn1);

        updateBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDbHelper user=new UserDbHelper(UpdateActivity.this);
                SQLiteDatabase db;
                db=user.getWritableDatabase();

                int x=user.updateData(updateName.getText().toString(),updatePhone.getText().toString()
                ,updateEmail.getText().toString(),db);
                if (x==1){
                    Toast.makeText(UpdateActivity.this, "Updated successfully", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(UpdateActivity.this, "Some error occur", Toast.LENGTH_SHORT).show();
                }




            }
        });

    }
}
