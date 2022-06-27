package com.example.foreignerchats.BottomNavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.foreignerchats.Adapter.VPAdapterChat;
import com.example.foreignerchats.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class ChatFragment extends Fragment {
    VPAdapterChat vpAdapterChat;

    private String[] titles = new String[]{"Recent","All"};

    public static ChatFragment newInstance() {
        ChatFragment fragment = new ChatFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        TabLayout tabLayout = view.findViewById(R.id.tablayout_chat);
        ViewPager2 viewPager2 = view.findViewById(R.id.viewPagerChat);

        vpAdapterChat= new VPAdapterChat(this);


        viewPager2.setAdapter(vpAdapterChat);
        viewPager2.setSaveEnabled(false);

        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> tab.setText(titles[position] ))).attach();

        return view;
    }


}