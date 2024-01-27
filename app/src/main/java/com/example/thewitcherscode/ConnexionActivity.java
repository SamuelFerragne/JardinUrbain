package com.example.thewitcherscode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConnexionActivity extends AppCompatActivity {

    private TextView txtmtpOublier, txtInscriptionClick;
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

            }
        });
    }
}
