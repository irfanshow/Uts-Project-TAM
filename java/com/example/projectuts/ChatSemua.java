package com.example.projectuts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ChatSemua extends Fragment {

    private ArrayList namaChatSemua,profileChatSemua,pesanChatSemua;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_semua, container, false);

        namaChatSemua=new ArrayList();
        profileChatSemua=new ArrayList();
        pesanChatSemua = new ArrayList();

        for (int i=0;i<DataChatAll.namaChatAll.length;i++)
        {
            namaChatSemua.add(DataChatAll.namaChatAll);
            profileChatSemua.add(DataChatAll.ProfileChatAll);
            pesanChatSemua.add(DataChatAll.pesanChatAll);
        }

        RecylerChatSemua recylerChatSemua= new RecylerChatSemua(getContext(),namaChatSemua,profileChatSemua,pesanChatSemua);
        RecyclerView recyclerView = view.findViewById(R.id.recylerChatSemua);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(recylerChatSemua);

        return view;
    }
}