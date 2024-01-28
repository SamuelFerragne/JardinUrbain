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

        Intent intention = getIntent();
        int id = intention.getIntExtra("id", 0);

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
                acc_isncription.putExtra("id", id);
                startActivity(acc_isncription);

            }
        });

        bnv_navigation = findViewById(R.id.bnv_navigation);
        bnv_navigation.setSelectedItemId(id);
        bnv_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                Intent intention;
                int id = item.getItemId();

                if (id == R.id.action_louer) {

                } else if (id == R.id.action_marche) {

                } else if (id == R.id.action_carte) {
                    intention = new Intent(ConnexionActivity.this, MainActivity.class);
                    intention.putExtra("id", id);
                    startActivity(intention);

                } else if (id == R.id.action_reseau) {

                } else if (id == R.id.action_profil) {
                    intention = new Intent(ConnexionActivity.this, ConnexionActivity.class);
                    intention.putExtra("id", id);
                    startActivity(intention);
                }


                return false;
            }
        });
    }
}
