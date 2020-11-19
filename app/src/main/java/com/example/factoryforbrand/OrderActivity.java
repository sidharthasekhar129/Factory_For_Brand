package com.example.factoryforbrand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class OrderActivity extends AppCompatActivity {
    LinearLayout order1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().setTitle("Order");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        order1=(LinearLayout)findViewById(R.id.order1);
        order1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(OrderActivity.this,Order_Details.class);
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
