package com.example.gdms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    EditText crd_hold_name;
    EditText crd_number;
    EditText exp_date;
    EditText cvv;
    Button btn_pay;
    Context context;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        crd_hold_name = findViewById(R.id.crd_hold_name);
        crd_number = findViewById(R.id.crd_number);
        exp_date = findViewById(R.id.exp_date);
        cvv = findViewById(R.id.cvv);
        btn_pay = findViewById(R.id.btn_pay);
        context = this;
        dbManager = new DBManager(context);

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String iCrd_hold_name = crd_hold_name.getText().toString();
                String iCrd_number = crd_number.getText().toString();
                String iExp_date = exp_date.getText().toString();
                String iCvv = cvv.getText().toString();

                if(iCrd_hold_name.equals("") || iCrd_number.equals("") || iExp_date.equals("") || iCvv.equals("")) {

                    Toast.makeText(context, "Please Fill All the Fields", Toast.LENGTH_SHORT).show();
                }

                else {

                    Pay pay = new Pay(iCrd_hold_name, iCrd_number, iExp_date, iCvv);
                    Boolean status = dbManager.PayNow(pay);

                    if(status == true) {

                        Toast.makeText(context, "Payment is Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(context, MainActivity.class));
                    }
                    else {
                        Toast.makeText(context, "Payment is Unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}