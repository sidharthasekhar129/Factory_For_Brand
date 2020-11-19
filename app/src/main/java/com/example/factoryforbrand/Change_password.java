package com.example.factoryforbrand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Change_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        getSupportActionBar().setTitle("About");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

