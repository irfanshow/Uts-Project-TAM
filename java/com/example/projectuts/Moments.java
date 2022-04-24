package com.example.projectuts;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class Moments extends Fragment {

    private String[] titles = new String[]{"All","Following"};

    VPAdapterMoment vpAdapterMoment;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        TabLayout tabLayout = view.findViewById(R.id.tablayout_search);
        ViewPager2 viewPager2 = view.findViewById(R.id.viewPagerSearch);

        vpAdapterMoment= new VPAdapterMoment(this);


        viewPager2.setAdapter(vpAdapterMoment);
        viewPager2.setSaveEnabled(false);

        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> tab.setText(titles[position] ))).attach();

        return view;
    }
}