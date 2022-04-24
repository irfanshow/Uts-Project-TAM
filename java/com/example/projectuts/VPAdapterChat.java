package com.example.projectuts;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class VPAdapterChat extends FragmentStateAdapter {
    private String[] titles = new String[]{"Terkini","Semua"};

    public VPAdapterChat(@NonNull Chats fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new ChatTerkini();
            case 1 :
                return new ChatSemua();
        }
        return new ChatTerkini();
    }

    @Override

    public int getItemCount() {
        return titles.length;
    }

}
