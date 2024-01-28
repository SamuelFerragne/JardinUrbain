package com.example.thewitcherscode;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv_navigation = findViewById(R.id.bnv_navigation);
        bnv_navigation.setItemIconTintList(null);
        bnv_navigation.setItemIconSize(150);

        Intent intention = getIntent();
        int id = intention.getIntExtra("id", 0);
        bnv_navigation.setSelectedItemId(id);
        bnv_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                Intent intention;
                int id = item.getItemId();

                if (id == R.id.action_louer) {

                } else if (id == R.id.action_marche) {

                } else if (id == R.id.action_carte) {

                } else if (id == R.id.action_reseau) {

                } else if (id == R.id.action_profil) {
                    intention = new Intent(MainActivity.this, inscriptionActivity.class);
                    intention.putExtra("id", id);
                    startActivity(intention);
                }


                return false;
            }
        });
    }
}
