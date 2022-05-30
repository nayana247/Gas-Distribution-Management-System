package com.example.gdms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText log_email_pt;
    EditText log_pass_pt;
    Button log_btn;
    TextView fog_link;
    TextView sign_link;
    Context context;
    DBManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log_email_pt = findViewById(R.id.log_email_pt);
        log_pass_pt = findViewById(R.id.log_pass_pt);
        log_btn = findViewById(R.id.log_btn);
        fog_link = findViewById(R.id.fog_link);
        sign_link = findViewById(R.id.sign_link);
        context = this;
        dbManager = new DBManager(context);

        log_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String iEmail = log_email_pt.getText().toString();
                String iPassword = log_pass_pt.getText().toString();

                if (iEmail.equals("") || iPassword.equals("")) {

                    Toast.makeText(context, "Please Provide Email and Password", Toast.LENGTH_SHORT).show();
                } else {

                    Boolean result = dbManager.ValidateCustomer(iEmail, iPassword);

                    if (result == true) {

                        Intent intent = new Intent(getApplicationContext(), Map.class);
                        startActivity(intent);
                    }

                    else {
                        Toast.makeText(context, "Email and Password are Invalid", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    // method for open customer registration form
    public void openRegistration(View view) {

        Intent intent = new Intent(this,registration.class);

        startActivity(intent);
    }

    // method for open customer registration form
    public void openForgottenPassword(View view) {

        Intent intent = new Intent(this,FogottenPassword.class);

        startActivity(intent);
    }

}

