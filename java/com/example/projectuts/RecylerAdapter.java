package com.example.projectuts;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.MyViewHolder> {


    private ArrayList arrayListBendera , arrayListNegara;
    Context context;


    public RecylerAdapter(Context context,ArrayList arrayListBendera,ArrayList arrayListNegara){
        this.context=context;
        this.arrayListBendera=arrayListBendera;
        this.arrayListNegara=arrayListNegara;


    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_negara,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textView.setText(DataNegara.namaNegara[position]);
        holder.imageView.setImageResource(DataNegara.benderaNegara[position]);

        holder.buttonChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayListNegara.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        Button buttonChat;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.negaraName);
            buttonChat = itemView.findViewById(R.id.btn_search);
            imageView = itemView.findViewById(R.id.img_bendera);
        }
    }
}
