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

public class RecylerAbout extends RecyclerView.Adapter<RecylerAbout.MyViewHolder>{

    private ArrayList namaAbout, profileAbout,npm;
    Context context;



    public RecylerAbout(Context context,ArrayList namaAbout, ArrayList profileAbout,ArrayList npm){
        this.context=context;
        this.namaAbout=namaAbout;
        this.profileAbout=profileAbout;
        this.npm= npm;



    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_about_item,parent,false);
        RecyclerView.ViewHolder viewHolder = new MyViewHolder(view);
        return (MyViewHolder) viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(DataAbout.namaAbout[position]);
        holder.npm.setText(DataAbout.NPM[position]);
        holder.imageView.setImageResource(DataAbout.ProfileAbout[position]);
    }




    @Override
    public int getItemCount() {
        return namaAbout.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        TextView npm;
        ImageView imageView;
        Button buttonChat;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.namaAbout);
            npm = itemView.findViewById(R.id.npm);
            imageView = itemView.findViewById(R.id.img_about);
        }
    }

}
