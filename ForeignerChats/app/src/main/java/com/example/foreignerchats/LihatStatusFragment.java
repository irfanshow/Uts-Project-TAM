package com.example.foreignerchats;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foreignerchats.Adapter.SemuaAdapter;
import com.example.foreignerchats.model.ModelSemua;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class LihatStatusFragment extends Fragment {
    String namauser, photouser;
    View view;

    public LihatStatusFragment(String namauser, String photouser) {
        this.namauser = namauser;
        this.photouser = photouser;
    }

    public LihatStatusFragment() {

    }

    public static LihatStatusFragment newInstance(String param1, String param2) {
        LihatStatusFragment fragment = new LihatStatusFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lihat_status, container, false);
        ImageView photo = view.findViewById(R.id.photouser);
        TextView nama = view.findViewById(R.id.namauser);
        BottomNavigationView navBar = getActivity().findViewById(R.id.navigation);
        ActionBar a;
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        navBar.setVisibility(View.GONE);
        nama.setText(namauser);
        Glide.with(getContext()).load(photouser).into(photo);
        ImageView back = view.findViewById(R.id.imageView2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().onBackPressed();
                navBar.setVisibility(View.VISIBLE);

            }
        });


        return view;
    }
}