package com.example.factoryforbrand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AcountActivity extends AppCompatActivity {
    private TextView persionalinfo, password_change, settings, address, orders, ashare, points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acount);
        getSupportActionBar().setTitle("Account");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        persionalinfo = (TextView) findViewById(R.id.persionalinfo);
        password_change = (TextView) findViewById(R.id.change_password);
        settings = (TextView) findViewById(R.id.settings);
        address = (TextView) findViewById(R.id.address);
        orders = (TextView) findViewById(R.id.myorders);
        ashare = (TextView) findViewById(R.id.ashare);
        points = (TextView) findViewById(R.id.points);


        persionalinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcountActivity.this, Personal_info.class);
                startActivity(intent);
            }
        });
        password_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcountActivity.this, Change_password.class);
                startActivity(intent);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcountActivity.this, Setting_info.class);
                startActivity(intent);
            }
        });
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcountActivity.this, MyAddress.class);
                startActivity(intent);
            }
        });
        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcountActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
        ashare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcountActivity.this, ReferralActivity.class);
                startActivity(intent);
            }
        });
        points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcountActivity.this, PointsActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }
}