package com.example.projectuts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class SearchTerdekat extends Fragment {

    private ArrayList namaNearby,profileNearby;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_terdekat, container, false);

        namaNearby=new ArrayList();
        profileNearby=new ArrayList();

        for (int i=0;i<DataNearby.namaNeaby.length;i++)
        {
            namaNearby.add(DataNearby.namaNeaby);
            profileNearby.add(DataNearby.ProfileNearby);
        }

        RecylerAdapterTerdekat recylerAdapterTerdekat= new RecylerAdapterTerdekat(getContext(),profileNearby,namaNearby);
        RecyclerView recyclerView = view.findViewById(R.id.recylerTerdekat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(recylerAdapterTerdekat);

        return view;
    }
}