package com.example.projectuts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MomentFollowing extends Fragment {

    private ArrayList namaMomentFollowing,profileMomentFollowing,statusMomentFollowing;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_moment_following, container, false);

        namaMomentFollowing=new ArrayList();
        profileMomentFollowing=new ArrayList();
        statusMomentFollowing = new ArrayList();

        for (int i=0;i<DataMomentFollowing.namaMomentFollowing.length;i++)
        {
            namaMomentFollowing.add(DataMomentFollowing.namaMomentFollowing);
            profileMomentFollowing.add(DataMomentFollowing.ProfileMomentFollowing);
            statusMomentFollowing.add(DataMomentFollowing.statusMomentFollowing);
        }

        RecylerMomentFollowing recylerMomentFollowing= new RecylerMomentFollowing(getContext(),namaMomentFollowing,profileMomentFollowing,statusMomentFollowing);
        RecyclerView recyclerView = view.findViewById(R.id.recylerMomentFollowing);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(recylerMomentFollowing);

        return view;
    }
}