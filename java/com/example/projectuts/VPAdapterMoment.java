package com.example.projectuts;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class VPAdapterMoment extends FragmentStateAdapter {
    private String[] titles = new String[]{"All","Following"};

    public VPAdapterMoment(@NonNull Moments fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new MomentSemua();
            case 1 :
                return new MomentFollowing();
        }
        return new MomentSemua();
    }

    @Override

    public int getItemCount() {
        return titles.length;
    }
}
