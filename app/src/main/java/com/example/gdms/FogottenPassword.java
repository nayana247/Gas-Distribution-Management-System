package com.example.gdms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FogottenPassword extends AppCompatActivity {

    EditText fog_email;
    EditText fog_newp;
    Button fog_submit;
    Button fog_cancel;
    Context context;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fogotten_password);

        fog_email = findViewById(R.id.fog_email);
        fog_newp = findViewById(R.id.forg_newp);
        fog_submit = findViewById(R.id.fog_submit);
        fog_cancel = findViewById(R.id.fog_cancel);
        context = this;
        dbManager = new DBManager(context);

        String iFog_email = fog_email.getText().toString();
        String iFog_newp = fog_newp.getText().toString();

        if(iFog_email.equals("") || iFog_newp.equals("")) {

            Toast.makeText(context, "Please Fill All the Fields", Toast.LENGTH_SHORT).show();
        }

        else {
            Customer customer = new Customer();
            boolean status = dbManager.ForgottenPassword(customer);

            if(status == true) {

                Toast.makeText(context, "Updated Password Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(context, MainActivity.class));
            }
            else {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        }

    }
}