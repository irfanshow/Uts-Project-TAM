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

public class RecylerMomentFollowing extends RecyclerView.Adapter<RecylerMomentFollowing.MyViewHolder>{

    private ArrayList namaMomentFollowing, profileMomentFollowing,statusMomentAFollowing;
    Context context;



    public RecylerMomentFollowing(Context context,ArrayList namaMomentFollowing, ArrayList profileMomentFollowing,ArrayList statusMomentAFollowing){
        this.context=context;
        this.profileMomentFollowing=profileMomentFollowing;
        this.namaMomentFollowing=namaMomentFollowing;
        this.statusMomentAFollowing= statusMomentAFollowing;



    }



    @NonNull
    @Override
    public RecylerMomentFollowing.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecylerMomentFollowing.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_moment_following,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(DataMomentFollowing.namaMomentFollowing[position]);
        holder.statusView.setText(DataMomentFollowing.statusMomentFollowing[position]);
        holder.imageView.setImageResource(DataMomentFollowing.ProfileMomentFollowing[position]);
    }


    @Override
    public int getItemCount() {
        return namaMomentFollowing.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        TextView statusView;
        ImageView imageView;
        Button buttonChat;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.TextMomentFollowing);
            statusView = itemView.findViewById(R.id.status_moment_following);
            buttonChat = itemView.findViewById(R.id.comment_moment);
            imageView = itemView.findViewById(R.id.img_moment_following);
        }
    }

}

