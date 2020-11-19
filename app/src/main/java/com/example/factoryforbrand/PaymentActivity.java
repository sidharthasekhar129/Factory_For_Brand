package com.example.factoryforbrand;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class PaymentActivity extends AppCompatActivity {
    private Button placeorder;
    LinearLayout linearLayout1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        linearLayout1=(LinearLayout)findViewById(R.id.linearL1);
        linearLayout1.setVisibility(View.GONE);

        placeorder=(Button)findViewById(R.id.placeorder);
        placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final Dialog dialog=new Dialog(PaymentActivity.this);
                dialog.setContentView(R.layout.order_confirmation_dialog);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Button ok=(Button)dialog.findViewById(R.id.ok);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });


        final RadioGroup radio = (RadioGroup)findViewById(R.id.radioGroup1);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                View radioButton = radio.findViewById(checkedId);
                int index = radio.indexOfChild(radioButton);

                // Add logic here

                switch (index) {
                    case 0: // first button

                        linearLayout1.setVisibility(View.GONE);

                        break;
                    case 1: // secondbutton
                        linearLayout1.setVisibility(View.VISIBLE);


                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
