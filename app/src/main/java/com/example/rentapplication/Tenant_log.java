package com.example.rentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tenant_log extends AppCompatActivity {

    EditText x1,x2;
    DatabaseHelper sqLiteDatabase;

    public Button tlogs;
    public void Homes(){
        tlogs=(Button)findViewById(R.id.Tlog);
        tlogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent u = new Intent(Tenant_log.this,Tenant_home_page.class);

                String name = x1.getText().toString();
                String number = x2.getText().toString();
                Boolean namenum = sqLiteDatabase.namenumber(name,number);
                if(namenum==true)
                    startActivity(u);
                else
                    Toast.makeText(getApplicationContext(), "ভুল সংখ্যা বা নাম",Toast.LENGTH_SHORT).show();


            }
        });

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_log);
        Homes();

        sqLiteDatabase = new DatabaseHelper(this);
        x1=(EditText)findViewById(R.id.Namelogins);
        x2=(EditText)findViewById(R.id.numberlogins);
    }
}
