package com.example.foreignerchats.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foreignerchats.ChattingFragment;
import com.example.foreignerchats.HasilNegaraFragment;
import com.example.foreignerchats.R;
import com.example.foreignerchats.model.ModelSemua;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class SemuaAdapter extends FirebaseRecyclerAdapter<ModelSemua, SemuaAdapter.SemuaViewHolder> {

    public SemuaAdapter (@NonNull FirebaseRecyclerOptions<ModelSemua> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull SemuaViewHolder holder, int position, @NonNull ModelSemua model) {
        holder.nama.setText(model.getNamauser());
        holder.negara.setText(model.getNegarauser());
        holder.detail.setText(model.getDetailuser());
        Glide.with(holder.photo.getContext())
                .load(model.getPhotouser())
                .into(holder.photo);

        holder.chat.setOnClickListener(new View.OnClickListener() {
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
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_semua, viewGroup, false);
        return new SemuaViewHolder(v);
    }

    public class SemuaViewHolder extends RecyclerView.ViewHolder {

        TextView nama,negara,detail;
        ImageView photo;
        Button chat;

        public SemuaViewHolder(@NonNull View itemView) {
            super(itemView);
            chat = itemView.findViewById(R.id.tombolchat);
            nama = itemView.findViewById(R.id.namauser);
            negara = itemView.findViewById(R.id.negarauser);
            detail = itemView.findViewById(R.id.detailuser);
            photo = itemView.findViewById(R.id.photouser);
        }
    }

}