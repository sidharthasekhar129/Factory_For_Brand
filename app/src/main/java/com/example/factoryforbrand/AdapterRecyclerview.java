package com.example.factoryforbrand;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;



public class AdapterRecyclerview extends RecyclerView.Adapter<AdapterRecyclerview.Programmingviewholder> {

  private   Context context1;


    private String[] data5;
    private String[] data4;
    private String[] data3;
    private String[] data2;
    private String[] data1;
    private String[] path1;
    private String[] path2;

    public AdapterRecyclerview(String[] data1, String[] data2, String[] data3, String[] data4,
                               String[] data5, String[] path1x, String[] path2x){
        this.data1=data1;
        this.data2=data2;
        this.data3=data3;
        this.data4=data4;
        this.data5=data5;

        this.path1=path1x;
        this.path2=path2x;
    }

            @NonNull
    @Override
    public Programmingviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.list_item_layout,parent,false);
         return (new Programmingviewholder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull final Programmingviewholder holder, final int position) {

        String title1=data1[position];

         if (context1!=null)
        {
            Glide.with(context1).load(title1).into(holder.imgicon);

            String title2=data2[position];
            holder.txttitle2.setText(title2);

            String title3=data3[position];
            holder.txttitle3.setText(title3);

            String pricex=data4[position];
            holder.price.setText(pricex);

            String offerx=data5[position];
            // holder.offer.setText(offerx+"%off");

            String pr=offerx+"%off";
            holder.offer.setText(pr);

            holder.finalprice.setText("₹"+Integer.toString(pricecalci(pricex,offerx)));
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"clicked on item: "+position,Toast.LENGTH_SHORT).show();
                Context context=v.getContext();
                String positionx=Integer.toString(position);
                Intent intent=new Intent(context,ProductDetailsActivity.class);
                intent.putExtra("path1",path1[1]);
                intent.putExtra("path2",path2[1]);
                intent.putExtra("position",positionx);
                intent.putExtra("extra","one");

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length ;
    }


    public class Programmingviewholder extends RecyclerView.ViewHolder {

        ImageView imgicon;
        TextView txttitle2,txttitle3,offer,finalprice,price;
        LinearLayout linearLayout;
         public Programmingviewholder(@NonNull View itemView) {
            super(itemView);
            imgicon=(ImageView) itemView.findViewById(R.id.pic1);
            txttitle2=(TextView)itemView.findViewById(R.id.name1);
            txttitle3=(TextView)itemView.findViewById(R.id.name2);
             finalprice=(TextView)itemView.findViewById(R.id.finalpricex);
             price=(TextView)itemView.findViewById(R.id.price);
             offer=(TextView)itemView.findViewById(R.id.offer);

            linearLayout=(LinearLayout)itemView.findViewById(R.id.linear);

             context1=itemView.getContext();


        }
    }

    public int pricecalci(String pricex,String offerx)
    {
        int finalpricexx = 0;
        try {

            int myprice=Integer.parseInt(pricex);
            int myoffer=Integer.parseInt(offerx);
            int off=((myprice*myoffer)/100);
            finalpricexx=myprice - off;


        }
        catch (Exception e){
            e.printStackTrace();
        }
        return finalpricexx;
    }

}
