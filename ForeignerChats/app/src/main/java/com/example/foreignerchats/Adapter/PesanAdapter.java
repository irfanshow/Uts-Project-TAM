package com.example.foreignerchats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foreignerchats.model.ModelPesan;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class PesanAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<ModelPesan> ListPesan;
    int PesanDikirim = 1,PesanDiterima = 2;

    public PesanAdapter(Context context, ArrayList<ModelPesan> ListPesan) {
        this.context = context;
        this.ListPesan = ListPesan;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==PesanDikirim)
        {
            View view= LayoutInflater.from(context).inflate(R.layout.pesandikirim,parent,false);
            return new PengirimViewHolder(view);
        }
        else
        {
            View view= LayoutInflater.from(context).inflate(R.layout.pesanditerima,parent,false);
            return new PenerimaViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ModelPesan pesan=ListPesan.get(position);
        if(holder.getClass()==PengirimViewHolder.class)
        {
            PengirimViewHolder viewHolder=(PengirimViewHolder)holder;
            viewHolder.TextPesan.setText(pesan.getPesan());
            viewHolder.WaktuPesan.setText(pesan.getWaktupesan());
        }
        else
        {
            PenerimaViewHolder viewHolder=(PenerimaViewHolder)holder;
            viewHolder.TextPesan.setText(pesan.getPesan());
            viewHolder.WaktuPesan.setText(pesan.getWaktupesan());
        }








    }


    @Override
    public int getItemViewType(int position) {
        ModelPesan pesan =ListPesan.get(position);
        if(FirebaseAuth.getInstance().getCurrentUser().getUid().equals(pesan.getPengirim()))

        {
            return  PesanDikirim;
        }
        else
        {
            return PesanDiterima;
        }
    }

    @Override
    public int getItemCount() {
        return ListPesan.size();
    }








    class PengirimViewHolder extends RecyclerView.ViewHolder
    {

        TextView TextPesan;
        TextView WaktuPesan;


        public PengirimViewHolder(@NonNull View itemView) {
            super(itemView);
            TextPesan=itemView.findViewById(R.id.pesanpengirim);
            WaktuPesan=itemView.findViewById(R.id.waktupesan);
        }
    }

    class PenerimaViewHolder extends RecyclerView.ViewHolder
    {

        TextView TextPesan;
        TextView WaktuPesan;


        public PenerimaViewHolder(@NonNull View itemView) {
            super(itemView);
            TextPesan=itemView.findViewById(R.id.pesanpenerima);
            WaktuPesan=itemView.findViewById(R.id.waktupesan);
        }
    }




}
