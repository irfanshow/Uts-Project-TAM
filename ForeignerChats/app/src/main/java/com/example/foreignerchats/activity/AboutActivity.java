package com.example.foreignerchats.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foreignerchats.Adapter.RecylerAbout;
import com.example.foreignerchats.MainActivity;
import com.example.foreignerchats.R;
import com.example.foreignerchats.model.DataAbout;

import java.util.ArrayList;

public class AboutActivity extends AppCompatActivity {

    private ArrayList namaAbout,profileAbout,npm;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.acton_back,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intentMain = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intentMain);

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setTitle("Foreigner Chat");

        namaAbout= new ArrayList();
        profileAbout=new ArrayList();
        npm= new ArrayList();

        for (int i = 0; i< DataAbout.namaAbout.length; i++)
        {
            namaAbout.add(DataAbout.namaAbout);
            profileAbout.add(DataAbout.ProfileAbout);
            npm.add(DataAbout.NPM);
        }

        RecylerAbout recylerAbout = new RecylerAbout(this,namaAbout,profileAbout,npm);
        RecyclerView recyclerView = findViewById(R.id.recylerAbout);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recylerAbout);

    }
}