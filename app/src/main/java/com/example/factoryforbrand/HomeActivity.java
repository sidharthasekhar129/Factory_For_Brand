package com.example.factoryforbrand;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.factoryforbrand.Adapters.Home_offer;
import com.example.factoryforbrand.Adapters.Home_sale;
import com.example.factoryforbrand.Adapters.Home_trend;
import com.example.factoryforbrand.Adapters.Home_upcoming;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private EditText search;
    private SliderLayout sliderLayout;
    LinearLayout mainlayout;

    private static final String TAG = "HomeActivity    ";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private static final String keyproduct1 = "product1";
    private static final String keyproduct2 = "product2";
    private static final String keyproduct3 = "product3";
    private static final String keyproduct4 = "product4";

    private static final String keyRecent1 = "recent1";
    private static final String keyRecent2 = "recent2";
    private static final String keyRecent3 = "recent3";

    private ImageView cartx, notifix;

    private static final String Key_name1="name1";
    private static final String Key_name2="name2";
    private static final String Key_pic1="pic1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);



     //   mainlayout=(LinearLayout) findViewById(R.id.maincard);
        sliderLayout=(SliderLayout) findViewById(R.id.sliderimage);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setScrollTimeInSec(2);
        setSliderViews();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Exit")
                    .setCancelable(false)
                    .setMessage("Are you sure?")
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    })
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_store) {
            Intent intent1 = new Intent(HomeActivity.this, StoreActivity.class);
            startActivity(intent1);
        }
        else if (id==R.id.nav_categories)
        {
            Intent intent2=new Intent(HomeActivity.this, CategoryActivity.class);
            intent2.putExtra("path","men");
            startActivity(intent2);
        }
        else if (id == R.id.nav_electronics) {

            Intent intent4 = new Intent(HomeActivity.this, Electronics.class);
            startActivity(intent4);

        }
        else if (id == R.id.nav_customtshirt) {

            Toast.makeText(getApplicationContext(), "Coming Soon", Toast.LENGTH_SHORT).show();

        }
        else if (id == R.id.nav_order) {
            Intent intent5 = new Intent(HomeActivity.this, OrderActivity.class);
            startActivity(intent5);
        } else if (id == R.id.nav_offer) {
            // Intent intent=new Intent(getApplicationContext(),OrderActivity.class);
            // startActivity(intent);
        } else if (id == R.id.nav_cart) {
            Intent intent = new Intent(HomeActivity.this, CartActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_tandc) {
            Intent intent=new Intent(HomeActivity.this,SearchResults.class);
             startActivity(intent);
        } else if (id == R.id.nav_account) {
            Intent intent = new Intent(HomeActivity.this, AcountActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_contact) {
            Intent intent = new Intent(HomeActivity.this, ContactUsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {


            Intent intent = new Intent(HomeActivity.this, ReferralActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_logout) {
            SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("remember", "false");
            editor.apply();

            Intent intent = new Intent(HomeActivity.this, LogInActivity.class);
            startActivity(intent);
            finish();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

   private void setSliderViews()
    {
        for (int i=0;i<=4;i++)
        {


            final DefaultSliderView sliderView=new DefaultSliderView(this);
            switch (i)
            {
                case 0:
                    DocumentReference noteref2 = db.collection("Homepage").document("onoffer");
                    noteref2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {
                                String slide1 = documentSnapshot.getString(keyproduct1);
                                sliderView.setImageUrl(slide1);
                            }
                        }
                    });
                    break;
                case 1:
                    DocumentReference noteref3 = db.collection("Homepage").document("onoffer");
                    noteref3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {
                                String  slide2 = documentSnapshot.getString(keyproduct2);
                                sliderView.setImageUrl(slide2);
                            }
                        }
                    });
                    break;
                case 2:
                    DocumentReference noteref4 = db.collection("Homepage").document("onoffer");
                    noteref4.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {
                                String  slide3 = documentSnapshot.getString(keyproduct3);
                                sliderView.setImageUrl(slide3);

                            }
                        }
                    });
                    break;
                case 3:
                    DocumentReference noteref5=db.collection("Homepage").document("onoffer");
                    noteref5.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists())
                            {
                                String  slide4=documentSnapshot.getString(keyproduct4);
                                sliderView.setImageUrl(slide4);
                            }
                        }
                    });
                    break;
                case 4:
                    DocumentReference noteref6=db.collection("Homepage").document("onoffer");
                    noteref6.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists())
                            {
                                String  slide5=documentSnapshot.getString(keyproduct4);
                                sliderView.setImageUrl(slide5);
                            }
                        }
                    });
                    break;


            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER);
            //sliderView.setDescription("setDescription" +(i+1));
            //it is working
            final int final1=i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {

                    if (final1==0)
                    {
                        // Uri uri=Uri.parse("http://www.jainuniversity.ac.in");
                        // Intent intentx=new Intent(Intent.ACTION_VIEW,uri);
                        // Intent intentx =new Intent(getApplicationContext(),Events.class);
                        //  startActivity(intentx);

                    }

                    else   if (final1==1)
                    {
                        // Uri uri=Uri.parse("http://www.jainuniversity.ac.in");
                        // Intent intentx=new Intent(Intent.ACTION_VIEW,uri);
                        //  Intent intentx =new Intent(getApplicationContext(),Events.class);
                        // startActivity(intentx);
                    }

                    else if (final1==2)
                    {
                        // Uri uri=Uri.parse("http://www.jainuniversity.ac.in");
                        // Intent intentx=new Intent(Intent.ACTION_VIEW,uri);
                        // Intent intentx =new Intent(getApplicationContext(),Events.class);
                        // startActivity(intentx);
                    }

                    else if (final1==3)
                    {
                        // Uri uri=Uri.parse("http://www.jainuniversity.ac.in");
                        // Intent intentx=new Intent(Intent.ACTION_VIEW,uri);
                        // Intent intentx =new Intent(getApplicationContext(),Events.class);
                        //  startActivity(intentx);
                    }
                    else
                    {
                        // Uri uri=Uri.parse("http://www.jainuniversity.ac.in");
                        // Intent intentx=new Intent(Intent.ACTION_VIEW,uri);
                        // Intent intentx =new Intent(getApplicationContext(),Events.class);
                        //  startActivity(intentx);
                    }


                }
            });
            sliderLayout.addSliderView(sliderView);
        }
    }
    @Override
    protected void onStart() {
        super.onStart();


        //ontrend horizontal scrollview
        int i;
        final String[] pic1 = new String[7];
        final String[] name1 = new String[7];
        final String[] name2 = new String[7];

        for (i=0;i<=6;i++)
        {
            // String a=Integer.toString(i);
            String ok="a"+i;
            try {
                DocumentReference reference1=db.collection("Homepage").document("onoffer")
                        .collection("ontrend").document(ok);
                final int finalI = i;
                reference1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists())
                        {
                            name1[finalI] =documentSnapshot.getString(Key_name1);
                            name2[finalI]=documentSnapshot.getString(Key_name2);
                            pic1[finalI]=documentSnapshot.getString(Key_pic1);

                        }
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Document does not exist!", Toast.LENGTH_SHORT).show();
                            }
                        });



            }catch (Exception e){
                e.printStackTrace();
            }
        }

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        recyclerView.setAdapter(new Home_trend(pic1,name1,name2));

        // recyclerView.getLayoutManager().scrollToPosition(6);
        //   recyclerView.getLayoutManager().scrollToPosition(1);




        //onoffer horizontal scrollview
        int ii;
        final String[] pic11 = new String[7];
        final String[] name11 = new String[7];
        final String[] name22 = new String[7];
        final String[] path11 = new String[7];
        final String[] path22 = new String[7];


        for (ii=0;ii<=6;ii++)
        {
            // String a=Integer.toString(i);

            String ok="a"+ii;


            try {
                DocumentReference reference2=db.collection("Homepage").document("onoffer")
                        .collection("onoffer").document(ok);
                final int finalI = ii;
                reference2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists())
                        {
                            name11[finalI] =documentSnapshot.getString(Key_name1);
                            name22[finalI]=documentSnapshot.getString(Key_name2);
                            pic11[finalI]=documentSnapshot.getString(Key_pic1);

                        }
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Document does not exist!",Toast.LENGTH_SHORT).show();
                            }
                        });
                path11[finalI]="onoffer";
                path22[finalI]="onoffer";


            }catch (Exception e){
                e.printStackTrace();
            }
        }

        RecyclerView recyclerView2=(RecyclerView)findViewById(R.id.recyclerview2);

        recyclerView2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        recyclerView2.setAdapter(new Home_offer(pic11,name11,name22,path11,path22));



        //onsale

        int j;
        final String[] pic111 = new String[7];
        final String[] name111 = new String[7];
        final String[] name222 = new String[7];
        final String[] path111 = new String[7];
        final String[] path222 = new String[7];




        for (j=0;j<=6;j++)
        {
            // String a=Integer.toString(i);

            String ok="a"+j;


            try {
                DocumentReference reference3=db.collection("Homepage").document("onoffer")
                        .collection("onsale").document(ok);
                final int finalI = j;
                reference3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists())
                        {
                            name111[finalI] =documentSnapshot.getString(Key_name1);
                            name222[finalI]=documentSnapshot.getString(Key_name2);
                            pic111[finalI]=documentSnapshot.getString(Key_pic1);

                        }
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Document does not exist!",Toast.LENGTH_SHORT).show();
                            }
                        });
                path111[finalI]="onoffer";
                path222[finalI]="onsale";


            }catch (Exception e){
                e.printStackTrace();
            }
        }

        RecyclerView recyclerView3=(RecyclerView)findViewById(R.id.recyclerview3);

        recyclerView3.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        recyclerView3.setAdapter(new Home_sale(pic111,name111,name222,path111,path222));



        //upcoming


        int k;
        final String[] pic1111 = new String[7];
        final String[] name1111 = new String[7];
        final String[] name2222 = new String[7];



        for (k=0;k<=6;k++)
        {
            // String a=Integer.toString(i);

            String ok="a"+k;


            try {
                DocumentReference reference4=db.collection("Homepage").document("onoffer")
                        .collection("ontrend").document(ok);
                final int finalI = k;
                reference4.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists())
                        {
                            name1111[finalI] =documentSnapshot.getString(Key_name1);
                            name2222[finalI]=documentSnapshot.getString(Key_name2);
                            pic1111[finalI]=documentSnapshot.getString(Key_pic1);

                        }
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Document does not exist!",Toast.LENGTH_SHORT).show();
                            }
                        });



            }catch (Exception e){
                e.printStackTrace();
            }
        }

        RecyclerView recyclerView4=(RecyclerView)findViewById(R.id.recyclerview4);

        recyclerView4.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        recyclerView4.setAdapter(new Home_upcoming(pic1111,name1111,name2222));
    }
}

