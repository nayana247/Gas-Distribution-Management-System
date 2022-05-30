package com.example.gdms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registration extends AppCompatActivity {

    EditText name_pt;
    EditText nic_pt;
    EditText contact_pt;
    EditText email_pt;
    EditText add_pt;
    EditText pass_pt;
    EditText compass_pt;
    Button btn_submit;
    Button btn_cancel;
    TextView tv_login;
    Context context;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name_pt = findViewById(R.id.name_pt);
        nic_pt = findViewById(R.id.nic_pt);
        contact_pt = findViewById(R.id.email_pt);
        email_pt = findViewById(R.id.email_pt);
        add_pt = findViewById(R.id.add_pt);
        pass_pt = findViewById(R.id.pass_pt);
        compass_pt = findViewById(R.id.compass_pt);
        btn_submit = findViewById(R.id.btn_submit);
        btn_cancel = findViewById(R.id.btn_cancel);
        tv_login = findViewById(R.id.tv_login);
        context = this;
        dbManager = new DBManager(context);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String iName = name_pt.getText().toString();
                String iNIC = nic_pt.getText().toString();
                String iPhone = compass_pt.getText().toString();
                String iEmail = email_pt.getText().toString();
                String iAddress = add_pt.getText().toString();
                String iPassword = pass_pt.getText().toString();
                String iRePassword = compass_pt.getText().toString();


                if (iName.equals("") || iNIC.equals("") || iPhone.equals("") || iEmail.equals("") || iAddress.equals("") || iPassword.equals("") || iRePassword.equals("")) {

                    Toast.makeText(context, "Please Fill All the Fields", Toast.LENGTH_SHORT).show();
                } else {

                    if (iPassword.equals(iRePassword)) {

                        Boolean result = dbManager.ValidateEmail(iEmail);

                        if (result == false) {

                            Customer customer = new Customer(iName, iNIC, iPhone, iEmail, iAddress, iPassword, iRePassword);
                            Boolean status = dbManager.CustomerRegistration(customer);

                            if (status == true) {

                                Toast.makeText(context, "Registration is Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(context, MainActivity.class));
                            } else {
                                Toast.makeText(context, "Registration is Unsuccessful", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(context, "Email is Already Exist", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(context, "Two Password Fields are Mismatched", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    // method for open Login
    public void openLogin(View view) {

        Intent intent = new Intent(this,MainActivity.class);

        startActivity(intent);
    }

    // method for cancel registration
    public void cancelRegistration(View view) {

        Intent intent = new Intent(this,MainActivity.class);

        startActivity(intent);
    }
    }
