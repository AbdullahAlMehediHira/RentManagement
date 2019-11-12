package com.example.rentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Owner_log extends AppCompatActivity {

    EditText a1,a2;
    DatabaseHelper sqLiteDatabase;

    public Button home;
    public void Home(){
        home=(Button)findViewById(R.id.logtohome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent q = new Intent(Owner_log.this,Owner_home_page.class);

                String name = a1.getText().toString();
                String number = a2.getText().toString();
                Boolean namenum = sqLiteDatabase.namenumber(name,number);
                if(namenum==true)
                    startActivity(q);
                else
                    Toast.makeText(getApplicationContext(), "ভুল সংখ্যা বা নাম",Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_log);
        Home();

        sqLiteDatabase = new DatabaseHelper(this);
        a1=(EditText)findViewById(R.id.Namelogin);
        a2=(EditText)findViewById(R.id.numberlogin);
    }
}
