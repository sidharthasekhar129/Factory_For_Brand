package com.example.factoryforbrand.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.factoryforbrand.AdapterRecyclerview;
import com.example.factoryforbrand.ProductDetailsActivity;
import com.example.factoryforbrand.R;

public class Home_trend extends RecyclerView.Adapter<Home_trend.Programmingviewholder> {



    private Context context1;
    //private Activity activity;



    private String[] data3;
    private String[] data2;
    private String[] data1;


    public Home_trend(String[] data1, String[] data2, String[] data3){
        this.data1=data1;
        this.data2=data2;
        this.data3=data3;

    }




    @NonNull
    @Override
    public Programmingviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.home_scroll_1,parent,false);
        return (new Programmingviewholder(view));

    }

    @Override
    public void onBindViewHolder(@NonNull Programmingviewholder holder, int position) {


        if (context1!=null)
        {

            String title2=data2[position];
            holder.txttitle2.setText(title2);

            String title3=data3[position];
            holder.txttitle3.setText(title3);
            String title1=data1[position];
            Glide.with(context1).load(title1).into(holder.imgicon);
        }


        /*holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"clicked on item: "+position,Toast.LENGTH_SHORT).show();
                Context context=v.getContext();
                String positionx=Integer.toString(position);
                Intent intent=new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("path1",path1[1]);
                intent.putExtra("path2",path2[1]);
                intent.putExtra("position",positionx);

                context.startActivity(intent);
            }
        });*/
    }




    @Override
    public int getItemCount() {
        return data1.length ;
    }


    public class Programmingviewholder extends RecyclerView.ViewHolder {

        ImageView imgicon;
        TextView txttitle2,txttitle3;
        LinearLayout linearLayout;
        public Programmingviewholder(@NonNull View itemView) {
            super(itemView);
            imgicon=(ImageView) itemView.findViewById(R.id.pic1);
            txttitle2=(TextView)itemView.findViewById(R.id.name1);
            txttitle3=(TextView)itemView.findViewById(R.id.name2);


            linearLayout=(LinearLayout)itemView.findViewById(R.id.linear1);

            context1=itemView.getContext();




        }
    }



}

