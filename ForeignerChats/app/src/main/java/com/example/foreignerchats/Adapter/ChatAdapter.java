package com.example.foreignerchats.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foreignerchats.ChattingFragment;
import com.example.foreignerchats.R;
import com.example.foreignerchats.model.ModelSemua;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ChatAdapter extends FirebaseRecyclerAdapter<ModelSemua, ChatAdapter.SemuaViewHolder> {

    public ChatAdapter(@NonNull FirebaseRecyclerOptions<ModelSemua> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull SemuaViewHolder holder, int position, @NonNull ModelSemua model) {
        holder.nama.setText(model.getNamauser());
        Glide.with(holder.photo.getContext())
                .load(model.getPhotouser())
                .into(holder.photo);
        holder.wahyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,new ChattingFragment(model.getNamauser(),model.getNegarauser(),model.getPhotouser())).addToBackStack(null).commit();

            }
        });




    }

    @NonNull
    @Override
    public SemuaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_chat, viewGroup, false);
        return new SemuaViewHolder(v);
    }

    public class SemuaViewHolder extends RecyclerView.ViewHolder {

        TextView nama;
        ImageView photo;
        ConstraintLayout wahyu;

        public SemuaViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.namauser);
            photo = itemView.findViewById(R.id.photouser);
            wahyu = itemView.findViewById(R.id.kotakchat);
        }
    }

}