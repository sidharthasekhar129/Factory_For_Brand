package com.example.factoryforbrand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Setting_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_info);
        getSupportActionBar().setTitle("Setting");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
