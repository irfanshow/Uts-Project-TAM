package com.example.projectuts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ChatTerkini extends Fragment {

    private ArrayList namaChatTerkini,profileChatTerkini,pesanChatTerkini;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_terkini, container, false);

        namaChatTerkini=new ArrayList();
        profileChatTerkini=new ArrayList();
        pesanChatTerkini = new ArrayList();

        for (int i=0;i<DataChatTerkini.namaChatTerkini.length;i++)
        {
            namaChatTerkini.add(DataChatTerkini.namaChatTerkini);
            profileChatTerkini.add(DataChatTerkini.ProfileChatTerkini);
            pesanChatTerkini.add(DataChatTerkini.pesanChatTerkini);
        }

        RecylerChatTerkini recylerChatTerkini = new RecylerChatTerkini(getContext(),namaChatTerkini,profileChatTerkini,pesanChatTerkini);
        RecyclerView recyclerView = view.findViewById(R.id.recylerChatTerkini);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(recylerChatTerkini);


        return view;
    }
}
