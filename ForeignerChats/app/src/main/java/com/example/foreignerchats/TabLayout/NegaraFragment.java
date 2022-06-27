package com.example.foreignerchats.TabLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foreignerchats.Adapter.NegaraAdapter;
import com.example.foreignerchats.R;



public class NegaraFragment extends Fragment {

    private String[] negara = {"Indonesia","Arabia","India","Jepang","Korea","Rusia","Swizz"
            ,"Netherland","Singapore","Vietnam"

    };
    private String[] gambarnegara = {"https://www.countryflags.com/wp-content/uploads/indonesia-flag-png-large.png","https://www.countryflags.com/wp-content/uploads/saudi-arabia-flag-png-large.png","https://cdn.countryflags.com/thumbs/india/flag-800.png","https://cdn.countryflags.com/thumbs/japan/flag-800.png","https://cdn.countryflags.com/thumbs/south-korea/flag-800.png","https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Flag_of_Russia.svg/1280px-Flag_of_Russia.svg.png","https://www.countryflags.com/wp-content/uploads/switzerland-flag-png-large.png"
            ,"https://www.countryflags.com/wp-content/uploads/netherlands-flag-png-large.png","https://cdn.countryflags.com/thumbs/singapore/flag-800.png","https://www.countryflags.com/wp-content/uploads/vietnam-flag-png-large.png"

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_negara, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.negararecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new NegaraAdapter(negara,gambarnegara));

        return view;
    }



}