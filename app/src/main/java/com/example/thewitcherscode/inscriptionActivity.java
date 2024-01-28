package com.example.thewitcherscode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
import com.google.firebase.auth.UserProfileChangeRequest;

import org.intellij.lang.annotations.Pattern;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class inscriptionActivity extends AppCompatActivity {

    private TextView tv_connexionClick;

    FirebaseAuth bdAuth;

    private EditText Nom_Complet, NomUti, champ_courriel, champ_mtp, champ_confi_Mtp;
    private Button btn_inscription;

    BottomNavigationView bnv_navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

       Intent intention = getIntent();
       int id = intention.getIntExtra("id", 0);



        tv_connexionClick = findViewById(R.id.txt_connexionClick);
        champ_Nom_Complet = findViewById(R.id.et_Inscri_nomComplet);
        champ_NomUti = findViewById(R.id.et_Inscri_nomUtilisateur);
        champ_courriel = findViewById(R.id.et_Inscri_courriel);
        champ_confi_Mtp = findViewById(R.id.et_Inscri_confiMotPasse);
        champ_mtp = findViewById(R.id.et_Inscri_motpasse);
        btnInscription = findViewById(R.id.btn_inscription);

        tv_connexionClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent acc_connexion = new Intent(inscriptionActivity.this, ConnexionActivity.class);
                acc_connexion.putExtra("id", id);
                startActivity(acc_connexion);
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
                    intention = new Intent(inscriptionActivity.this, MainActivity.class);
                    intention.putExtra("id", id);
                    startActivity(intention);

                } else if (id == R.id.action_reseau) {

                } else if (id == R.id.action_profil) {
                    intention = new Intent(inscriptionActivity.this, inscriptionActivity.class);
                    intention.putExtra("id", id);
                    startActivity(intention);
                }


                return false;
            }
        });



        // TODO bouton inscription
        btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courriel = champ_courriel.getText().toString();
                String mtp = champ_mtp.getText().toString();
                String confiMtp = champ_confi_Mtp.getText().toString();
                String userName = champ_NomUti.getText().toString();
                String nomComplet = champ_Nom_Complet.getText().toString();

                bdAuth = FirebaseAuth.getInstance();

                // TODO: creation d'un compte

                if(Patterns.EMAIL_ADDRESS.matcher(courriel).matches()){

                    if(mtp.matches(confiMtp) && mtp.length() >= 10){
                        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                        bdAuth.createUserWithEmailAndPassword(courriel, mtp)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        // si ca marche
                                        if(task.isSuccessful()){
                                            // direction vers le main
                                            Toast.makeText(getApplicationContext(), "Creation du compte avec succes !", Toast.LENGTH_SHORT).show();
                                            FirebaseUser usager = bdAuth.getCurrentUser();

                                            if(usager != null){
                                                usager.updateProfile(new UserProfileChangeRequest.Builder().setDisplayName(nomComplet).build());
                                                Intent intgestionBD = new Intent(inscriptionActivity.this, MainActivity.class);
                                                startActivity(intgestionBD);
                                                finish();
                                            }
                                        }else{
                                            Toast.makeText(getApplicationContext(), "Une erreur est survenu", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }else if(mtp.length() < 10){
                        champ_mtp.setError("Mots de passe de contenir plus de 10 caracteres");
                        champ_mtp.requestFocus();
                    }else{
                        // TODO: reviens sur ca
                        champ_confi_Mtp.setError("non = a mtp");
                        champ_confi_Mtp.requestFocus();
                    }


                }else {
                    champ_courriel.setError("Courriel non valide");
                    champ_courriel.requestFocus();
                }
            }
        });

    }
}