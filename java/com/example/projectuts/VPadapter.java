package com.example.projectuts;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class VPadapter extends FragmentStateAdapter {

    private String[] titles = new String[]{"Semua","Terdekat","Negara"};

    public VPadapter(@NonNull Search fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new SearchSemua();
            case 1 :
                return new SearchTerdekat();
            case 2:
                return new SearchNegara();
        }
        return new SearchSemua();
    }

    @Override

    public int getItemCount() {
        return titles.length;
    }
}
