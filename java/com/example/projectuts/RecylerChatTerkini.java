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

public class RecylerChatTerkini extends RecyclerView.Adapter<RecylerChatTerkini.MyViewHolder>{

    private ArrayList namaChatTerkini, profileChatTerkini,pesanChatTerkini;
    Context context;



    public RecylerChatTerkini(Context context,ArrayList namaChatTerkini, ArrayList profileChatTerkini,ArrayList pesanChatTerkini){
        this.context=context;
        this.namaChatTerkini=namaChatTerkini;
        this.profileChatTerkini=profileChatTerkini;
        this.pesanChatTerkini= pesanChatTerkini;



    }



    @NonNull
    @Override
    public RecylerChatTerkini.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecylerChatTerkini.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_chat_terkini,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(DataChatTerkini.namaChatTerkini[position]);
        holder.pesanView.setText(DataChatTerkini.pesanChatTerkini[position]);
        holder.imageView.setImageResource(DataChatTerkini.ProfileChatTerkini[position]);
    }


    @Override
    public int getItemCount() {
        return namaChatTerkini.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        TextView pesanView;
        ImageView imageView;
        Button buttonChat;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.TextchatTerkini);
            pesanView = itemView.findViewById(R.id.status_chat_terkini);
            buttonChat = itemView.findViewById(R.id.chat_terkini);
            imageView = itemView.findViewById(R.id.img_chat_terkini);
        }
    }

}
