package com.example.foreignerchats.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foreignerchats.ChattingFragment;
import com.example.foreignerchats.LihatStatusFragment;
import com.example.foreignerchats.R;
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

public class StatusAdapter extends FirebaseRecyclerAdapter<ModelSemua, StatusAdapter.SemuaViewHolder> {
    DatabaseReference udahfollow;
    FirebaseUser users;
    FirebaseAuth auth;

    public StatusAdapter(@NonNull FirebaseRecyclerOptions<ModelSemua> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull SemuaViewHolder holder, int position, @NonNull ModelSemua model) {
        try {
            Thread.sleep(50);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        auth = FirebaseAuth.getInstance();
        users = auth.getCurrentUser();
        udahfollow = FirebaseDatabase.getInstance().getReference("Users").child(users.getUid());
        udahfollow.orderByChild(model.getNamauser()).equalTo(model.getId()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    holder.nama.setText(model.getNamauser());
                    Glide.with(holder.photo.getContext())
                            .load(model.getPhotouser())
                            .into(holder.photo);
                    holder.kotakstatus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            try { Thread.sleep(100); } catch (Exception e) { e.printStackTrace(); }
                            AppCompatActivity activity=(AppCompatActivity)view.getContext();
                            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,new LihatStatusFragment(model.getNamauser(),model.getPhotouser())).addToBackStack(null).commit();

                        }
                    });


                } else{
                    RecyclerView.LayoutParams param = (RecyclerView.LayoutParams)holder.itemView.getLayoutParams();
                    holder.itemView.setVisibility(View.GONE);
                    param.height = 0;
                    param.width = 0;




                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    @NonNull
    @Override
    public SemuaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_status, viewGroup, false);
        return new SemuaViewHolder(v);
    }

    public class SemuaViewHolder extends RecyclerView.ViewHolder {

        TextView nama;
        ImageView photo;
        ConstraintLayout kotakstatus;

        public SemuaViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.namauser);
            photo = itemView.findViewById(R.id.photouser);
            kotakstatus = itemView.findViewById(R.id.kotakstatus);
        }
    }

}