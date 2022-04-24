package com.example.projectuts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager.widget.ViewPager;


import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    BadgeDrawable badgeDrawable;
    BottomNavigationView bottomNavigationView;
    Me me = new Me();
    Chats chats = new Chats();
    Moments moments = new Moments();
    Search search = new Search();


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbaroption,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.ActAbout:
                Intent intentAbout = new Intent(getBaseContext(), AboutActivity.class);
                startActivity(intentAbout);
//            case R.id.ActSettings:
//                Intent intentActivity = new Intent(getBaseContext(), SettingActivity.class);
//                startActivity(intentActivity);
//            case R.id.ActMakeMoment:
//                Intent intentMakeMoment = new Intent(getBaseContext(), MakeMomentActivity.class);
//                startActivity(intentMakeMoment);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportActionBar().setTitle("Foreigner Chat");


        badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.moments);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(9);

        getSupportFragmentManager().beginTransaction().replace(R.id.containerBottomNav,chats).commit();




        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.chats:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerBottomNav,chats).commit();
                        return true;
                    case R.id.moments:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerBottomNav,moments).commit();
                        return true;
                    case R.id.seacrh:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerBottomNav,search).commit();
                        return true;
                    case R.id.me:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerBottomNav,me).commit();
                        return true;


                }
                return false;
            }
        });



    }
}