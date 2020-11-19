package com.example.factoryforbrand;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import org.w3c.dom.Text;

public class ProductDetailsActivity extends AppCompatActivity {
    private Button buy;
    private SliderLayout sliderLayout;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    String path1, path2, position,extra;
    private TextView name1,name2,finalprices,price,offer,
            size,qty,selsize,selqty,selectx,selecty;

    private ImageView pic1x,pic2x,pic3x,pic4x,imagegroup;

    private static final String Key_pic1 = "pic1";
    private static final String Key_pic2 = "pic2";
    private static final String Key_pic3 = "pic3";
    private static final String Key_pic4 = "pic4";

    private static final String Key_name1 = "name1";
    private static final String Key_name2 = "name2";
    private static final String Key_price = "price";
    private static final String Key_offer = "offer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);



        path1 = getIntent().getStringExtra("path1");
        path2 = getIntent().getStringExtra("path2");
        position = getIntent().getStringExtra("position");
        extra = getIntent().getStringExtra("extra");

        buy = (Button) findViewById(R.id.buy);

        pic1x=(ImageView)findViewById(R.id.pic1x);
        pic2x=(ImageView)findViewById(R.id.pic2x);
        pic3x=(ImageView)findViewById(R.id.pic3x);
        pic4x=(ImageView)findViewById(R.id.pic4x);
        imagegroup=(ImageView)findViewById(R.id.imagegroup);

        name1=(TextView)findViewById(R.id.name1);
        name2=(TextView)findViewById(R.id.name2);
        finalprices=(TextView)findViewById(R.id.finalprice);
        price=(TextView)findViewById(R.id.price);
        offer=(TextView)findViewById(R.id.offer);

        selsize=(TextView)findViewById(R.id.selSIZE);
        selectx=(TextView)findViewById(R.id.selectx);






        selectx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    View view=getLayoutInflater().inflate(R.layout.bottomsheetdialog,null);
                    final BottomSheetDialog dialog=new BottomSheetDialog(ProductDetailsActivity.this,R.style.BottomSheetDialog);

                    dialog.setContentView(view);

                    final TextView five=(TextView)view.findViewById(R.id.one);
                    final TextView six=(TextView)view.findViewById(R.id.two);
                    final TextView seven=(TextView)view.findViewById(R.id.three);
                    final TextView eight=(TextView)view.findViewById(R.id.four);
                    final TextView nine=(TextView)view.findViewById(R.id.five);

                    five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            five.setBackgroundColor(getResources().getColor(R.color.white));
                            five.setTextColor(getResources().getColor(R.color.black));
                            selsize.setText("5");
                            dialog.cancel();


                        }
                    });
                    six.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            six.setBackgroundColor(getResources().getColor(R.color.white));
                            six.setTextColor(getResources().getColor(R.color.black));

                            selsize.setText("6");
                            dialog.cancel();

                        }
                    });
                    seven.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            seven.setBackgroundColor(getResources().getColor(R.color.white));
                            seven.setTextColor(getResources().getColor(R.color.black));

                            selsize.setText("7");

                            dialog.cancel();

                        }
                    });
                    eight.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            eight.setBackgroundColor(getResources().getColor(R.color.white));
                            eight.setTextColor(getResources().getColor(R.color.black));

                            selsize.setText("8");


                            dialog.cancel();
                        }
                    });

                    nine.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            nine.setBackgroundColor(getResources().getColor(R.color.white));
                            nine.setTextColor(getResources().getColor(R.color.black));

                            selsize.setText("9");

                            dialog.cancel();

                        }
                    });
                    dialog.show();
                }
                catch (Exception e) {
                    Toast.makeText(ProductDetailsActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();

                }


            }
        });


        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=selsize.getText().toString();
                if (s.equals("0"))
                {
                    Toast.makeText(ProductDetailsActivity.this, "Select A size.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);
                    startActivity(intent);
                }

            }
        });


        sliderLayout = (SliderLayout) findViewById(R.id.imageslider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setScrollTimeInSec(1);
        sliderLayout.setAutoScrolling(true);


        try {
            //Toast.makeText(this, "" + path1 + path2 + position, Toast.LENGTH_SHORT).show();
            setSliderViews();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String ok="a"+position;

            if (extra.equals("one"))
            {
                DocumentReference noteref2 = db.collection("category").document(path1).collection(path2).document(ok);

                noteref2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        String name1x = documentSnapshot.getString(Key_name1);
                        String name2x = documentSnapshot.getString(Key_name2);
                        String pricex = documentSnapshot.getString(Key_price);
                        String offerx = documentSnapshot.getString(Key_offer);

                        name1.setText(name1x);
                        name2.setText(name2x);
                        String pr=offerx+"%off";
                        offer.setText(pr);

                        int myprice=Integer.parseInt(pricex);
                        int myoffer=Integer.parseInt(offerx);
                        int off=((myprice*myoffer)/100);
                        int finalpricex=myprice - off;
                        //  Toast.makeText(ProductDetailsActivity.this, ""+finalpricex, Toast.LENGTH_SHORT).show();


                        finalprices.setText("₹"+Integer.toString(finalpricex));

                        String fi="₹"+pricex;
                        price.setText(fi);


                    }
                });
            }
            else {
                DocumentReference noteref2 = db.collection("Homepage").document(path1).collection(path2).document(ok);

                noteref2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        String name1x = documentSnapshot.getString(Key_name1);
                        String name2x = documentSnapshot.getString(Key_name2);
                        String pricex = documentSnapshot.getString(Key_price);
                        String offerx = documentSnapshot.getString(Key_offer);

                        name1.setText(name1x);
                        name2.setText(name2x);
                        String pr=offerx+"%off";
                        offer.setText(pr);

                        int myprice=Integer.parseInt(pricex);
                        int myoffer=Integer.parseInt(offerx);
                        int off=((myprice*myoffer)/100);
                        int finalpricex=myprice - off;
                        //  Toast.makeText(ProductDetailsActivity.this, ""+finalpricex, Toast.LENGTH_SHORT).show();


                        finalprices.setText("₹"+Integer.toString(finalpricex));



                        String fi="₹"+pricex;
                        price.setText(fi);


                    }
                });
            }



        }catch (Exception e){e.printStackTrace();}



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    private void setSliderViews() {


        if (extra.equals("one"))
        {

            String ok="a"+position;

            for (int i = 0; i <= 3; i++) {

                final DefaultSliderView sliderView = new DefaultSliderView(this);
                sliderView.setDescription("Scroll to load faster");
                sliderView.setDescriptionTextSize(10);
                switch (i) {
                    case 0:
                        DocumentReference noteref2 = db.collection("category").document(path1).collection(path2).document(ok);
                        noteref2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()) {
                                    String slide1 = documentSnapshot.getString(Key_pic1);

                                    sliderView.setImageUrl(slide1);
                                }
                            }
                        });
                        break;
                    case 1:
                        DocumentReference noteref3 = db.collection("category").document(path1).collection(path2).document(ok);
                        noteref3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()) {
                                    String slide2 = documentSnapshot.getString(Key_pic2);
                                    sliderView.setImageUrl(slide2);
                                }
                            }
                        });
                        break;
                    case 2:
                        DocumentReference noteref4 = db.collection("category").document(path1).collection(path2).document(ok);
                        noteref4.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()) {
                                    String slide3 = documentSnapshot.getString(Key_pic3);
                                    sliderView.setImageUrl(slide3);
                                }
                            }
                        });
                        break;
                    case 3:
                        DocumentReference noteref5 = db.collection("category").document(path1).collection(path2).document(ok);
                        noteref5.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()) {
                                    String slide4 = documentSnapshot.getString(Key_pic4);
                                    sliderView.setImageUrl(slide4);
                                }
                            }
                        });
                        break;



                }
                sliderView.setImageScaleType(ImageView.ScaleType.CENTER);
                sliderLayout.addSliderView(sliderView);


            }
        }
        else {
            String ok="a"+position;

            for (int i = 0; i <= 3; i++) {

                final DefaultSliderView sliderView = new DefaultSliderView(this);
                sliderView.setDescription("Scroll to load faster");
                sliderView.setDescriptionTextSize(10);
                switch (i) {
                    case 0:
                        DocumentReference noteref2 = db.collection("Homepage").document(path1).collection(path2).document(ok);
                        noteref2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()) {
                                    String slide1 = documentSnapshot.getString(Key_pic1);

                                    sliderView.setImageUrl(slide1);
                                }
                            }
                        });
                        break;
                    case 1:
                        DocumentReference noteref3 = db.collection("Homepage").document(path1).collection(path2).document(ok);
                        noteref3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()) {
                                    String slide2 = documentSnapshot.getString(Key_pic2);
                                    sliderView.setImageUrl(slide2);
                                }
                            }
                        });
                        break;
                    case 2:
                        DocumentReference noteref4 = db.collection("Homepage").document(path1).collection(path2).document(ok);
                        noteref4.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()) {
                                    String slide3 = documentSnapshot.getString(Key_pic3);
                                    sliderView.setImageUrl(slide3);
                                }
                            }
                        });
                        break;
                    case 3:
                        DocumentReference noteref5 = db.collection("Homepage").document(path1).collection(path2).document(ok);
                        noteref5.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if (documentSnapshot.exists()) {
                                    String slide4 = documentSnapshot.getString(Key_pic4);
                                    sliderView.setImageUrl(slide4);
                                }
                            }
                        });
                        break;



                }
                sliderView.setImageScaleType(ImageView.ScaleType.CENTER);
                sliderLayout.addSliderView(sliderView);

            }
        }


    }
}
