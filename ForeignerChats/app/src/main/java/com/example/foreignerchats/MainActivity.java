package com.example.foreignerchats;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.foreignerchats.BottomNavigation.ChatFragment;
import com.example.foreignerchats.BottomNavigation.ProfileFragment;
import com.example.foreignerchats.BottomNavigation.SearchFragment;
import com.example.foreignerchats.BottomNavigation.StatusFragment;
import com.example.foreignerchats.activity.AboutActivity;
import com.example.foreignerchats.activity.StartActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {




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
                return true;

            case R.id.ActLogout:
                Intent intentLogout = new Intent(getBaseContext(), StartActivity.class);
                FirebaseAuth.getInstance().signOut();
                startActivity(intentLogout);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Foreigner Chat");

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationView.OnItemSelectedListener mOnNavigationItemSelectedListener
                = item -> {

                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.chat:
                            selectedFragment = ChatFragment.newInstance();
                            break;
                        case R.id.status:
                            selectedFragment = StatusFragment.newInstance();
                            break;
                        case R.id.search:
                            selectedFragment = SearchFragment.newInstance();
                            break;
                        case R.id.profile:
                            selectedFragment = ProfileFragment.newInstance();
                            break;
                    }
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_container, selectedFragment);
                    transaction.commit();
                    return true;
                };
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, SearchFragment.newInstance());
        transaction.commit();

        navigation.setOnItemSelectedListener(mOnNavigationItemSelectedListener);





    }

    @Override
    public void onBackPressed() {
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setVisibility(View.VISIBLE);
        getSupportActionBar().show();

        super.onBackPressed();
    }
}