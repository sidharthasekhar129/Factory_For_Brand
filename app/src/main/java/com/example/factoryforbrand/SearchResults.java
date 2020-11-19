package com.example.factoryforbrand;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class SearchResults extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);


    }
}