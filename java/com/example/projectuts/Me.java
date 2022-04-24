package com.example.projectuts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Me extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ImageView imageView;
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        imageView= view.findViewById(R.id.imageViewProfile);



       return view;
    }
}