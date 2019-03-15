package com.example.snehasis.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {


    String string;
    EditText searchName;
    Button searchBtn;
    TextView searchResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchName=(EditText)findViewById(R.id.searchName);
        searchBtn= (Button) findViewById(R.id.searchBtn);
        searchResult=(TextView) findViewById(R.id.searchResult);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDbHelper user=new UserDbHelper(SearchActivity.this);
                SQLiteDatabase db=user.getReadableDatabase();
                Cursor c=user.searchData(db,searchName.getText().toString());
                if(c.getCount()==0){
                    searchResult.setText("no user found");
                }else{
                    StringBuffer sb=new StringBuffer();
                    c.moveToNext();
                    do{
                        sb.append("name: "+c.getString(0)+"\n");
                        sb.append("email: "+c.getString(1)+"\n");
                        sb.append("phone: "+c.getString(2)+"\n");

                    }while(c.moveToNext());
                    searchResult.setText(sb.toString());
                }

            }
        });
    }
}
