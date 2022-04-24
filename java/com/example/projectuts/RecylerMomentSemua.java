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

public class RecylerMomentSemua extends RecyclerView.Adapter<RecylerMomentSemua.MyViewHolder>{

    private ArrayList namaMomentAll, profileMomentAll,statusMomentAll;
    Context context;



    public RecylerMomentSemua(Context context,ArrayList namaMomentAll, ArrayList profileMomentAll,ArrayList statusMomentAll){
        this.context=context;
        this.profileMomentAll=profileMomentAll;
        this.namaMomentAll=namaMomentAll;
        this.statusMomentAll= statusMomentAll;



    }



    @NonNull
    @Override
    public RecylerMomentSemua.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecylerMomentSemua.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_moment_semua,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(DataMomentAll.namaMomentAll[position]);
        holder.statusView.setText(DataMomentAll.statusMomentAll[position]);
        holder.imageView.setImageResource(DataMomentAll.ProfileMomentAll[position]);
    }


    @Override
    public int getItemCount() {
        return namaMomentAll.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        TextView statusView;
        ImageView imageView;
        Button buttonChat;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.TextMomentSemua);
            statusView = itemView.findViewById(R.id.status_moment_semua);
            buttonChat = itemView.findViewById(R.id.comment_moment);
            imageView = itemView.findViewById(R.id.img_moment_semua);
        }
    }

}

