package com.example.foreignerchats.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.foreignerchats.BottomNavigation.ChatFragment;
import com.example.foreignerchats.TabLayout.SemuaChatFragment;
import com.example.foreignerchats.TabLayout.TerkiniFragment;

public class VPAdapterChat extends FragmentStateAdapter {
    private String[] titles = new String[]{"Terkini","Semua"};

    public VPAdapterChat(@NonNull ChatFragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new TerkiniFragment();
            case 1 :
                return new SemuaChatFragment();
        }
        return new TerkiniFragment();
    }

    @Override

    public int getItemCount() {
        return titles.length;
    }

}
