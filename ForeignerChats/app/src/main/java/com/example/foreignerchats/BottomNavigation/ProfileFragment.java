package com.example.foreignerchats.BottomNavigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foreignerchats.R;
import com.example.foreignerchats.model.ModelSemua;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileFragment extends Fragment {
    ImageView fotouser;
    TextView namauser,namauser2,detailuser2,negarauser,detailuser;
    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference reference;


    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        fotouser = view.findViewById(R.id.imageView);
        namauser = view.findViewById(R.id.namaUser);
        namauser2= view.findViewById(R.id.namaUser2);
        negarauser = view.findViewById(R.id.negarauser);
        detailuser = view.findViewById(R.id.detailuser);
        detailuser2 = view.findViewById(R.id.detailuser2);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        reference = FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ModelSemua users = snapshot.getValue(ModelSemua.class);
                namauser.setText(users.getNamauser());
                namauser2.setText("Nama    :  " + users.getNamauser());
                detailuser.setText(users.getDetailuser());
                detailuser2.setText("Tentang :  " + users.getDetailuser());
                negarauser.setText("Negara  :  " + users.getNegarauser());
                Glide.with(getActivity().getApplicationContext()).load(users.getPhotouser()).into(fotouser);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return view;




    }
}