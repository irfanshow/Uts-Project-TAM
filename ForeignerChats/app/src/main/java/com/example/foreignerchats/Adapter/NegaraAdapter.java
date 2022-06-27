package com.example.foreignerchats.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foreignerchats.HasilNegaraFragment;
import com.example.foreignerchats.R;

public class NegaraAdapter extends RecyclerView.Adapter<NegaraAdapter.MyViewHolder> {

    private String[] negara;

    public String[] getNegara() {
        return negara;
    }

    public void setNegara(String[] negara) {
        this.negara = negara;
    }

    public String[] getBendera() {
        return bendera;
    }

    public void setBendera(String[] bendera) {
        this.bendera = bendera;
    }

    private String[] bendera;


    public NegaraAdapter(String[]negara,String[]bendera){
        this.negara=negara;
        this.bendera=bendera;


    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_negara,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        try { Thread.sleep(50); }
        catch (Exception e) { e.printStackTrace(); }

        holder.negara.setText(negara[position]);
        Glide.with(holder.gambarbendera)
                .load(bendera[position])
                .into(holder.gambarbendera);

        holder.kotaknegara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try { Thread.sleep(100); } catch (Exception e) { e.printStackTrace(); }
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,new HasilNegaraFragment(negara[position])).addToBackStack(null).commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return negara.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView negara;
        ImageView gambarbendera;
        CardView kotaknegara;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            negara = itemView.findViewById(R.id.negara);
            gambarbendera = itemView.findViewById(R.id.benderanegara);
            kotaknegara = itemView.findViewById(R.id.kotaknegara);
        }
    }
}

