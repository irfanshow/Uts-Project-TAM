package com.example.foreignerchats.TabLayout;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foreignerchats.Adapter.SemuaAdapter;
import com.example.foreignerchats.R;
import com.example.foreignerchats.activity.AboutActivity;
import com.example.foreignerchats.model.ModelSemua;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class SemuaFragment extends Fragment {
    private SemuaAdapter adapter;
    private RecyclerView recyclerView;
    View view;


    public SemuaFragment() {
        // Required empty public constructor
    }


    public static SemuaFragment newInstance() {
        SemuaFragment fragment = new SemuaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }
    public void onCancelled(@NonNull DatabaseError databaseError) { throw databaseError.toException(); }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_semua, container, false);
        recyclerView = view.findViewById(R.id.semuauser);
        setUpRecyclerView();

        return view;
    }
    public void onClick(View v) {
        if(v.getId() == R.id.tombolchat){
            Intent intent = new Intent(getActivity(), AboutActivity.class);
            startActivity(intent);
        }

    }

    public void setUpRecyclerView(){
        Query query = FirebaseDatabase.getInstance().getReference().child("Users");
        FirebaseRecyclerOptions<ModelSemua> options = new FirebaseRecyclerOptions.Builder<ModelSemua>()
                .setQuery(query, ModelSemua.class)
                .build();
        adapter = new SemuaAdapter(options);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (adapter != null) {
            adapter.startListening();
        }

    }
    @Override
    public void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.stopListening();
        }
    }
}