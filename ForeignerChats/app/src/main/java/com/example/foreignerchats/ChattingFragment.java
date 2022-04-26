package com.example.foreignerchats;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ChattingFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    String namauser, negarauser, photouser;
    public ChattingFragment() {

    }

    public ChattingFragment(String namauser, String negarauser, String photouser) {
        this.namauser=namauser;
        this.negarauser=negarauser;
        this.photouser=photouser;
    }

    public static HasilNegaraFragment newInstance(String param1, String param2) {
       HasilNegaraFragment fragment = new HasilNegaraFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_chatting, container, false);
        ImageView photo=view.findViewById(R.id.photouser);
        TextView nama=view.findViewById(R.id.namauser);
        TextView negara=view.findViewById(R.id.negarauser);
        BottomNavigationView navBar = getActivity().findViewById(R.id.navigation);
        navBar.setVisibility(View.GONE);
        nama.setText(namauser);
        negara.setText(negarauser);
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        Glide.with(getContext()).load(photouser).into(photo);
        ImageView back = view.findViewById(R.id.imageView2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().onBackPressed();
                navBar.setVisibility(View.VISIBLE);
            }
        });









        return  view;
    }






}