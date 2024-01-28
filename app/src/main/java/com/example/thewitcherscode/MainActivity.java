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
        bnv_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                Intent intention;

                if (item.getItemId() == R.id.action_louer) {

                } else if (item.getItemId() == R.id.action_marche) {

                } else if (item.getItemId() == R.id.action_carte) {

                } else if (item.getItemId() == R.id.action_reseau) {

                } else if (item.getItemId() == R.id.action_profil) {
                    intention = new Intent(MainActivity.this, inscriptionActivity.class);
                    startActivity(intention);
                }

                /*switch (item.getItemId()) {
                    case R.id.action_louer:
                        // Action lorsque Item 1 est sélectionné
                        return true;
                    case R.id.action_marche:
                        // Action lorsque Item 2 est sélectionné
                        return true;
                    case R.id.action_carte:
                        // Action lorsque Item 3 est sélectionné
                        return true;
                    case R.id.action_reseau:
                        // Action lorsque Item 4 est sélectionné
                        return true;
                    case R.id.action_profil:
                        // Action lorsque Item 5 est sélectionné
                        return true;
                    default:
                        return false;
                }*/
                return false;
            }
        });
    }
}
