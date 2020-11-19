package com.example.factoryforbrand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        getSupportActionBar().setTitle("Store");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}