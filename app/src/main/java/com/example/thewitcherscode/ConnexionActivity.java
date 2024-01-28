package com.example.thewitcherscode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ConnexionActivity extends AppCompatActivity {

    private TextView txtmtpOublier, txtInscriptionClick;
    BottomNavigationView bnv_navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        txtmtpOublier = findViewById(R.id.tv_mtpOublier);
        txtInscriptionClick = findViewById(R.id.tv_inscriptionClick);


        // TODO:: ALLER VERS LA PAGE OUBLIER MTP
        txtmtpOublier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent acc_isncription = new Intent(ConnexionActivity.this, MainActivity.class);
                startActivity(acc_isncription);
            }
        });

        // TODO:: ALLER VERS LA PAGE INSCRIPTION
        txtInscriptionClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // INTENT POUR ALLER VERS LA PAGE INSCRIPTION
                Intent acc_isncription = new Intent(ConnexionActivity.this, inscriptionActivity.class);
                startActivity(acc_isncription);

            }
        });

        bnv_navigation = findViewById(R.id.bnv_navigation);
        bnv_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                Intent intention;

                if (item.getItemId() == R.id.action_louer) {

                } else if (item.getItemId() == R.id.action_marche) {

                } else if (item.getItemId() == R.id.action_carte) {
                    intention = new Intent(ConnexionActivity.this, MainActivity.class);
                    startActivity(intention);

                } else if (item.getItemId() == R.id.action_reseau) {

                } else if (item.getItemId() == R.id.action_profil) {
                    intention = new Intent(ConnexionActivity.this, ConnexionActivity.class);
                    startActivity(intention);
                }


                return false;
            }
        });
    }
}
