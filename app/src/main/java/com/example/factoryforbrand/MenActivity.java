package com.example.factoryforbrand;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MenActivity extends AppCompatActivity {


String path1,path2;

    private static final String Key_name1="name1";
    private static final String Key_name2="name2";
    private static final String Key_pic1="pic1";
    private static final String Key_price="price";
    private static final String Key_offer="offer";
    private FirebaseFirestore db=FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men);

        getSupportActionBar().setTitle("Men");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        path1=getIntent().getStringExtra("path1");
        path2=getIntent().getStringExtra("path2");
        //path1="men"
        //path2="shoes"

        Toast.makeText(getApplicationContext(), "Scroll down and up to load 10x faster", Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext()," "+path1+path2,Toast.LENGTH_SHORT).show();


        int i;
        final String[] pic1 = new String[22];
        final String[] name1 = new String[22];
        final String[] name2 = new String[22];
        final String[] price = new String[22];
        final String[] offer = new String[22];

        final String[] path1x = new String[22];
        final String[] path2x = new String[22];

        for (i=0;i<=21;i++)
        {
            // String a=Integer.toString(i);

            String ok="a"+i;
            //a0 to a21 i.e exactly 22 shoes iam fetching
            //example: a0 containg name1,name2,pic1,pic2,pic3,pic4,price,offer
            //used a for loop to retrieve all 22 shoes informartions at a time
            //then passed it as a adapter on recyclerview

            try {
                DocumentReference reference=db.collection("category").document(path1).collection(path2).document(ok);
                final int finalI = i;
                reference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists())
                        {
                            name1[finalI] =documentSnapshot.getString(Key_name1);
                            name2[finalI]=documentSnapshot.getString(Key_name2);
                            pic1[finalI]=documentSnapshot.getString(Key_pic1);
                            price[finalI]=documentSnapshot.getString(Key_price);
                            offer[finalI]=documentSnapshot.getString(Key_offer);


                        }
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Document does not exist!",Toast.LENGTH_SHORT).show();
                            }
                        });
                path1x[finalI]=path1;
                path2x[finalI]=path2;
                //path1="men"
                //path2="shoes"

                //i dont know how to send data to a javaclass without using constructer so i took an array of them
                //if it would an activity we can easily pass the info using intent.putExtra() method
                //i.e path1x={"men","men",......22times} sorry for the logic


            }catch (Exception e){
                e.printStackTrace();
            }
        }

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.programminglist1);

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        recyclerView.setAdapter(new AdapterRecyclerview(pic1,name1,name2,price,offer,path1x,path2x));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    getSupportActionBar().hide();
                }
            });
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();


    }


}