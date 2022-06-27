package com.example.foreignerchats.TabLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foreignerchats.Adapter.ChatAdapter;
import com.example.foreignerchats.Adapter.ChatTerkiniAdapter;
import com.example.foreignerchats.R;
import com.example.foreignerchats.model.ModelSemua;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TerkiniFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TerkiniFragment extends Fragment {
    private ChatTerkiniAdapter adapter;
    private RecyclerView recyclerView;
    View view;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser user = auth.getCurrentUser();


    public TerkiniFragment() {
        // Required empty public constructor
    }


    public static TerkiniFragment newInstance() {
        TerkiniFragment fragment = new TerkiniFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }
    public void onCancelled(@NonNull DatabaseError databaseError) { throw databaseError.toException(); }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_terkini, container, false);
        recyclerView = view.findViewById(R.id.recylerChatTerkini);
        setUpRecyclerView();

        return view;
    }
    public void onClick(View v) {
        if(v.getId() == R.id.tombolchat){
            Intent intent = new Intent(getActivity(), NegaraFragment.class);
            startActivity(intent);
        }

    }

    public void setUpRecyclerView(){
        Query query = FirebaseDatabase.getInstance().getReference().child("Users").child(user.getUid()).child("PernahChat");

        FirebaseRecyclerOptions<ModelSemua> options = new FirebaseRecyclerOptions.Builder<ModelSemua>()
                .setQuery(query, ModelSemua.class)
                .build();
        adapter = new ChatTerkiniAdapter(options);
        LinearLayoutManager linearLayoutManager = new CustLinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
    public class CustLinearLayoutManager extends LinearLayoutManager {

        public CustLinearLayoutManager(Context context) {
            super(context);
        }

        public CustLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
            super(context, orientation, reverseLayout);
        }

        public CustLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }
        @Override
        public boolean supportsPredictiveItemAnimations() {
            return false;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (adapter != null) {
            adapter.startListening();
        }

    }
    @Override
    public void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.stopListening();
        }
    }
}