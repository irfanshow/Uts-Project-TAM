package com.example.projectuts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecylerAdapterTerdekat extends RecyclerView.Adapter<RecylerAdapterTerdekat.MyViewHolder> {

    private ArrayList namaNearby, profileNearby;
    Context context;


    public RecylerAdapterTerdekat(Context context,ArrayList profileNearby,ArrayList namaNearby){
        this.context=context;
        this.profileNearby=profileNearby;
        this.namaNearby=namaNearby;


    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecylerAdapterTerdekat.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_terdekat,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(DataNearby.namaNeaby[position]);
        holder.imageView.setImageResource(DataNearby.ProfileNearby[position]);
    }


    @Override
    public int getItemCount() {
        return namaNearby.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        Button buttonChat;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.nameTerdekat);
            buttonChat = itemView.findViewById(R.id.btn_chat);
            imageView = itemView.findViewById(R.id.img_terdekat);
        }
    }
}
