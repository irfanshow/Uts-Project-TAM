package com.example.projectuts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class SearchSemua extends Fragment {

    private ArrayList namaSearchAll,profileSearchAll,asalSearchSemua;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_semua2, container, false);

        namaSearchAll=new ArrayList();
        profileSearchAll=new ArrayList();
        asalSearchSemua = new ArrayList();

        for (int i=0;i<DataSearchAll.namaSearchAll.length;i++)
        {
            namaSearchAll.add(DataSearchAll.namaSearchAll);
            profileSearchAll.add(DataSearchAll.ProfileSearchAll);
        }

        RecylerAdapterSemua recylerAdapterSemua= new RecylerAdapterSemua(getContext(),profileSearchAll,namaSearchAll,asalSearchSemua);
        RecyclerView recyclerView = view.findViewById(R.id.recylerSemua);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(recylerAdapterSemua);

        return view;
    }
}