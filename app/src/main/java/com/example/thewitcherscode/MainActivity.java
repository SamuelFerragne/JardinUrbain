package com.example.thewitcherscode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    Toolbar tb_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb_navigation = findViewById(R.id.tb_navigation);
        setSupportActionBar(tb_navigation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // Ajoutez des actions en fonction de l'item sélectionné
        if (id == R.id.action_louer) {
            // Faites quelque chose quand l'item "Settings" est sélectionné
            return true;
        } else if (id == R.id.action_marche) {

        } else if (id == R.id.action_carte) {

        } else if (id == R.id.action_reseau) {

        } else if (id == R.id.action_profil) {

        }

        return super.onOptionsItemSelected(item);
    }
}