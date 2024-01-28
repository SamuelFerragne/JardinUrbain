package com.example.thewitcherscode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Patterns;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ConnexionActivity extends AppCompatActivity {

    private TextView txtmtpOublier, txtInscriptionClick;
    private EditText champ_Courriel, champs_mtp;
    private Button btn_connexion;
    FirebaseAuth bdAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        txtmtpOublier = findViewById(R.id.tv_mtpOublier); // TODO a ne pas oublier !!!!!!!!!!!!
        txtInscriptionClick = findViewById(R.id.tv_inscriptionClick);
        btn_connexion = findViewById(R.id.btn_Connexion);
        champ_Courriel = findViewById(R.id.et_courriel);
        champs_mtp = findViewById(R.id.et_mtp);
        bdAuth = FirebaseAuth.getInstance();



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

        btn_connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String champCourriel = champ_Courriel.getText().toString();
                String champMtp = champs_mtp.getText().toString();

                // TODO:: CONNEXION AU COMPTE
                if(Patterns.EMAIL_ADDRESS.matcher(champCourriel).matches()&& champMtp.length() >= 10){
                    // is good
                    bdAuth.signInWithEmailAndPassword(champCourriel,champMtp)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Log.d("autho", "Courriel " + champCourriel);
                                    Log.d("autho", "mtp " + champMtp);
                                    if(task.isSuccessful()){
                                        Log.d("autho", "is Successful");
                                        FirebaseUser usager = bdAuth.getCurrentUser();
                                        Intent intconnexion = new Intent(ConnexionActivity.this, MainActivity.class);
                                        startActivity(intconnexion);

                                    }else {
                                        Toast.makeText(getApplicationContext(), "Erreur de connexion", Toast.LENGTH_SHORT).show();
                                    }
                                }

                            });
                }

                else if(!Patterns.EMAIL_ADDRESS.matcher(champCourriel).matches()){
                    champ_Courriel.setError("Erreur de courriel");
                    champ_Courriel.requestFocus();
                }else{
                    // erreur
                    champs_mtp.setError("Mots de passe incorrect");
                    champs_mtp.requestFocus();
                }


            }
        });
    }
}
