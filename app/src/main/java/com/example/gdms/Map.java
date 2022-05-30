package com.example.gdms;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class Map extends AppCompatActivity {

    ImageButton img_btn_1; // red
    ImageButton img_btn_2; // green
    ImageButton img_btn_3; // yellow
    ImageButton img_btn_6; // red
    ImageButton img_btn_5; // yellow
    Context context;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        img_btn_1 = findViewById(R.id.img_btn_1);
        img_btn_2 = findViewById(R.id.img_btn_2);
        img_btn_3 = findViewById(R.id.img_btn_3);
        img_btn_6 = findViewById(R.id.img_btn_6);
        img_btn_5 = findViewById(R.id.img_btn_5);
        context = this;
        dbManager = new DBManager(context);

        img_btn_1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Vimal Gas Distributors");
                builder.setMessage("Gas Cylinders are not Currently Available");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(context,Map.class));
                    }
                });

//                builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        startActivity(new Intent(context,Map.class));
//                    }
//                });

//                builder.setNegativeButton("Update", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        Intent intent1 = new Intent(context, Map.class);
//                        startActivity(intent1);
//
//
//                    }
//                });

                builder.show();
            }
        });

        img_btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Oxygen House");
                builder.setMessage("Available");

                builder.setPositiveButton("Reserve Now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(context,Payment.class));
                    }
                });

                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(context,Map.class));
                    }
                });

                builder.show();
            }
        });

        img_btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Alwis Gas Store");
                builder.setMessage("Status Unknown");

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(context,Map.class));
                    }
                });

                builder.show();
            }
        });

        img_btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Dissanayake Gas Store");
                builder.setMessage("Gas Cylinders are not Currently Available");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(context,Map.class));
                    }
                });

            }
        });

        img_btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("L.P.G House");
                builder.setMessage("Status Unknown");

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(context,Map.class));
                    }
                });

                builder.show();
            }
        });
    }


}