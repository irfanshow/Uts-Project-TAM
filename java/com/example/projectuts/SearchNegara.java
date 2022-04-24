package com.example.projectuts;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;



public class SearchNegara extends Fragment {




    private ArrayList bendera,namaNegara;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        View view = inflater.inflate(R.layout.fragment_search_negara2, container, false);

        bendera=new ArrayList();
        namaNegara=new ArrayList();

        for (int i=0;i<DataNegara.namaNegara.length;i++)
        {
            namaNegara.add(DataNegara.namaNegara);
            bendera.add(DataNegara.benderaNegara);
        }

        RecylerAdapter recylerAdapter= new RecylerAdapter(getContext(),bendera,namaNegara);
        RecyclerView recyclerView = view.findViewById(R.id.recylerNegara);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(recylerAdapter);

        return view;
         }



    }

