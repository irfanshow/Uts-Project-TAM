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

public class RecylerAdapterSemua extends RecyclerView.Adapter<RecylerAdapterSemua.MyViewHolder> {

    private ArrayList namaSearchAll, profileSearchAll,AsalSearchAll;
    Context context;



    public RecylerAdapterSemua(Context context,ArrayList profileSearchAll,ArrayList namaSearchAll,ArrayList asalSearchAll){
        this.context=context;
        this.profileSearchAll=profileSearchAll;
        this.namaSearchAll=namaSearchAll;
        this.AsalSearchAll= asalSearchAll;


    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecylerAdapterSemua.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_semua,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(DataSearchAll.namaSearchAll[position]);
        holder.imageView.setImageResource(DataSearchAll.ProfileSearchAll[position]);
        holder.descView.setText("From "+DataSearchAll.AsalSemua[position]);
    }


    @Override
    public int getItemCount() {
        return namaSearchAll.size() ;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        TextView descView;
        ImageView imageView;
        Button buttonChat;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.nameSemua);
            descView = itemView.findViewById(R.id.desc_info_semua);
            buttonChat = itemView.findViewById(R.id.btn_chat_semua);
            imageView = itemView.findViewById(R.id.img_semua);
        }
    }
}