package com.example.projectuts;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class Chats extends Fragment {
    VPAdapterChat vpAdapterChat;

    private String[] titles = new String[]{"Recent","All"};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        TabLayout tabLayout = view.findViewById(R.id.tablayout_search);
        ViewPager2 viewPager2 = view.findViewById(R.id.viewPagerSearch);

        vpAdapterChat= new VPAdapterChat(this);


        viewPager2.setAdapter(vpAdapterChat);
        viewPager2.setSaveEnabled(false);

        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> tab.setText(titles[position] ))).attach();

        return view;
    }


}