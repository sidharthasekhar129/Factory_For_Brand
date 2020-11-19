package com.example.factoryforbrand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Personal_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        getSupportActionBar().setTitle("Personal Info");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}