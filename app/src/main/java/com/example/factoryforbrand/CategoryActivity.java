package com.example.factoryforbrand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity {
private TextView shoes,tshirt,shirt,bagsandwallet,
        sunglasses,watches,accessories,sportwear,others;
String link1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportActionBar().setTitle("Category");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        link1=getIntent().getStringExtra("path");





        shoes=(TextView) findViewById(R.id.shoes);
        tshirt=(TextView) findViewById(R.id.tshirt);
        shirt=(TextView) findViewById(R.id.shirt);
        bagsandwallet=(TextView) findViewById(R.id.bagsandwallet);
        sunglasses=(TextView) findViewById(R.id.sunglasses);
        watches=(TextView) findViewById(R.id.watches);
         sportwear=(TextView) findViewById(R.id.sportwear);



        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CategoryActivity.this, MenActivity.class);
                intent.putExtra("path2","shoes");
                intent.putExtra("path1",link1);
                 startActivity(intent);
            }
        });
        tshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CategoryActivity.this, MenActivity.class);
                intent.putExtra("path2","shirt");
                intent.putExtra("path1",link1);
                startActivity(intent);
            }
        });
        shirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CategoryActivity.this, MenActivity.class);
                intent.putExtra("path2","shirt");
                intent.putExtra("path1",link1);
                startActivity(intent);
            }
        });
        bagsandwallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CategoryActivity.this, MenActivity.class);
                intent.putExtra("path2","bagsandwallet");
                intent.putExtra("path1",link1);
                startActivity(intent);
            }
        });
        sunglasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CategoryActivity.this, MenActivity.class);
                intent.putExtra("path2","sunglasses");
                intent.putExtra("path1",link1);
                startActivity(intent);
            }
        });
        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CategoryActivity.this, MenActivity.class);
                intent.putExtra("path2","watches");
                intent.putExtra("path1",link1);
                startActivity(intent);
            }
        });

        sportwear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CategoryActivity.this, MenActivity.class);
                intent.putExtra("path2","sportswear");
                intent.putExtra("path1",link1);
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

