package com.example.foreignerchats.BottomNavigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foreignerchats.R;
import com.example.foreignerchats.TabLayout.NegaraFragment;
import com.example.foreignerchats.TabLayout.SemuaFragment;
import com.example.foreignerchats.TabLayout.TerdekatFragment;
import com.example.foreignerchats.model.ModelSemua;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;




public class SearchFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    ImageView fotouser;
    TextView namauser;
    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference reference;
    ViewPagerAdapter vp;
    private String[] titles = new String[]{"Semua","Terdekat","Negara"};

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_search, container, false);


        viewPager2 = view.findViewById(R.id.viewPagerChat);
        tabLayout = view.findViewById(R.id.tab_layout);

        vp = new ViewPagerAdapter(this);
        viewPager2.setAdapter(vp);
        viewPager2.setSaveEnabled(false);

        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> tab.setText(titles[position] ))).attach();
        fotouser = view.findViewById(R.id.profile);
        namauser = view.findViewById(R.id.nama);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        reference = FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ModelSemua users = snapshot.getValue(ModelSemua.class);
                namauser.setText(users.getNamauser());
                Glide.with(getActivity().getApplicationContext()).load(users.getPhotouser()).into(fotouser);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return view;

    }


    public class ViewPagerAdapter extends FragmentStateAdapter {
        private String[] titles = new String[]{"Semua","Terdekat","Negara"};

        public ViewPagerAdapter(@NonNull SearchFragment fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position)
            {
                case 0:
                    return new SemuaFragment();
                case 1 :
                    return new TerdekatFragment();
                case 2 :
                    return new NegaraFragment();
            }
            return new SemuaFragment();
        }

        @Override

        public int getItemCount() {
            return titles.length;
        }

    }

}