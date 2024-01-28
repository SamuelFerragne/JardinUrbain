package com.example.thewitcherscode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class inscriptionActivity extends AppCompatActivity {

    private TextView tv_connexionClick;
    private EditText Nom_Complet, NomUti, champ_courriel, champ_mtp, champ_confi_Mtp;
    private Button btn_inscription;

    BottomNavigationView bnv_navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        tv_connexionClick = findViewById(R.id.txt_connexionClick);
        Nom_Complet = findViewById(R.id.et_Inscri_nomComplet);
        NomUti = findViewById(R.id.et_Inscri_nomUtilisateur);
        champ_courriel = findViewById(R.id.et_Inscri_courriel);
        champ_confi_Mtp = findViewById(R.id.et_Inscri_confiMotPasse);
        champ_mtp = findViewById(R.id.et_Inscri_motpasse);

        tv_connexionClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent acc_connexion = new Intent(inscriptionActivity.this, ConnexionActivity.class);
                startActivity(acc_connexion);
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
                    intention = new Intent(inscriptionActivity.this, MainActivity.class);
                    startActivity(intention);

                } else if (item.getItemId() == R.id.action_reseau) {

                } else if (item.getItemId() == R.id.action_profil) {
                    intention = new Intent(inscriptionActivity.this, inscriptionActivity.class);
                    startActivity(intention);
                }


                return false;
            }
        });







    }
}