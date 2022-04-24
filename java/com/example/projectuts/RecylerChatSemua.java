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

public class RecylerChatSemua extends RecyclerView.Adapter<RecylerChatSemua.MyViewHolder>{

    private ArrayList namaChatSemua, profileChatSemua,pesanChatSemua;
    Context context;



    public RecylerChatSemua(Context context,ArrayList namaChatSemua, ArrayList profileChatSemua,ArrayList pesanChatSemua){
        this.context=context;
        this.namaChatSemua=namaChatSemua;
        this.profileChatSemua=profileChatSemua;
        this.pesanChatSemua= pesanChatSemua;



    }



    @NonNull
    @Override
    public RecylerChatSemua.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecylerChatSemua.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_chat_semua,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(DataChatAll.namaChatAll[position]);
        holder.pesanView.setText(DataChatAll.pesanChatAll[position]);
        holder.imageView.setImageResource(DataChatAll.ProfileChatAll[position]);
    }


    @Override
    public int getItemCount() {
        return namaChatSemua.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        TextView pesanView;
        ImageView imageView;
        Button buttonChat;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.TextchatSemua);
            pesanView = itemView.findViewById(R.id.status_chat_semua);
            buttonChat = itemView.findViewById(R.id.chat_semua);
            imageView = itemView.findViewById(R.id.img_chat_semua);
        }
    }

}
