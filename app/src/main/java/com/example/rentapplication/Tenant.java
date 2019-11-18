package com.example.rentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tenant extends AppCompatActivity {


    EditText l1,l2;
    DatabaseHelper sqLiteDatabase;
    Button Button4;

    public Button log;
    public void logs(){
        log=(Button)findViewById(R.id.log);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r = new Intent(Tenant.this,Tenant_log.class);

                startActivity(r);

            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant);

        logs();


        sqLiteDatabase = new DatabaseHelper(this);
        l1=(EditText)findViewById(R.id.names);
        l2=(EditText)findViewById(R.id.numbers);

        Button4=(Button)findViewById(R.id.reg);
        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String y1 = l1.getText().toString();
                String y2 = l2.getText().toString();

                if (y1.equals("") || y2.equals("")) {
                    Toast.makeText(getApplicationContext(), "স্থান পূরণ করুন", Toast.LENGTH_SHORT).show();

                }

                else {

                    Boolean checkmate = sqLiteDatabase.checkmate(y1);
                    if (checkmate == true) {
                        Boolean insert = sqLiteDatabase.insert(y1, y2);
                        if (insert == true) {
                            Toast.makeText(getApplicationContext(), "সাফল্যের সাথে নিবন্ধিত", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "নাম ইতিমধ্যে বিদ্যমান", Toast.LENGTH_SHORT).show();
                    }



                    //Toast.makeText(getApplicationContext(),"সংখ্যা মেলে না",Toast.LENGTH_SHORT).show();

                }
            }


        });




    }
}
