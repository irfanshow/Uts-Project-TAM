package com.example.foreignerchats.Adapter;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.foreignerchats.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foreignerchats.ChattingFragment;
import com.example.foreignerchats.model.ModelSemua;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class SemuaAdapter extends FirebaseRecyclerAdapter<ModelSemua, SemuaAdapter.SemuaViewHolder> {
    boolean followed = false;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser userini = auth.getCurrentUser();
    DatabaseReference udahfollow;
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

        QueryFollowing(model,holder);
        holder.follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Thread.sleep(1200);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                holder.follow.setVisibility(View.GONE);
                udahfollow = FirebaseDatabase.getInstance().getReference("Users").child(userini.getUid()).child("following");
                HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put(model.getNamauser(), model.getId());
                udahfollow.updateChildren(hashMap);


            }
        });









    }

    @NonNull
    @Override
    public SemuaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_semua, viewGroup, false);
        return new SemuaViewHolder(v);
    }

    public void QueryFollowing (ModelSemua model,SemuaViewHolder holder){
        udahfollow = FirebaseDatabase.getInstance().getReference("Users").child(userini.getUid());
        udahfollow.orderByChild(model.getNamauser()).equalTo(model.getId()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    holder.follow.setVisibility(View.GONE);
                } else{
                    holder.follow.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    public class SemuaViewHolder extends RecyclerView.ViewHolder {

        TextView nama,negara,detail;
        ImageView photo;
        Button chat,follow;

        public SemuaViewHolder(@NonNull View itemView) {
            super(itemView);
            chat = itemView.findViewById(R.id.tombolchat);
            nama = itemView.findViewById(R.id.namauser);
            negara = itemView.findViewById(R.id.negarauser);
            detail = itemView.findViewById(R.id.detailuser);
            photo = itemView.findViewById(R.id.photouser);
            follow = itemView.findViewById(R.id.tombolfollow);
        }
    }

}