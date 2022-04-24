package com.example.projectuts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MomentSemua extends Fragment {

    private ArrayList namaMomentAll,profileMomentAll,statusMomentSemua;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_moment_semua, container, false);

        namaMomentAll=new ArrayList();
        profileMomentAll=new ArrayList();
        statusMomentSemua = new ArrayList();

        for (int i=0;i<DataMomentAll.namaMomentAll.length;i++)
        {
            namaMomentAll.add(DataMomentAll.namaMomentAll);
            profileMomentAll.add(DataMomentAll.ProfileMomentAll);
            statusMomentSemua.add(DataMomentAll.statusMomentAll);
        }

        RecylerMomentSemua recylerMomentSemua= new RecylerMomentSemua(getContext(),namaMomentAll,profileMomentAll,statusMomentSemua);
        RecyclerView recyclerView = view.findViewById(R.id.recylerMomentSemua);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(recylerMomentSemua);

        return view;
    }
}