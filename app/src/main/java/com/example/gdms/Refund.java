package com.example.gdms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Refund extends AppCompatActivity {

    EditText pay_id;
    Button btn_refund;
    Button btn_ref_cancel;
    Context context;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refund);

        pay_id = findViewById(R.id.pay_id);
        btn_refund = findViewById(R.id.btn_refund);
        btn_ref_cancel = findViewById(R.id.btn_ref_cancel);
        context = this;
        dbManager = new DBManager(context);

        btn_refund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String iPay_id = pay_id.getText().toString();

                if(iPay_id.equals("")) {

                    Toast.makeText(context, "Please Input Payment ID", Toast.LENGTH_SHORT).show();
                }

                else {

                    boolean status =  dbManager.RefundPayment(iPay_id);

                    if(status == true) {

                        Toast.makeText(context, "Refund is Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(context, MainActivity.class));
                    }
                    else {
                        Toast.makeText(context, "Refund is Unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}