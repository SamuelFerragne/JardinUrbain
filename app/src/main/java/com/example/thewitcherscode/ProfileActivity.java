package com.example.thewitcherscode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    private EditText et_nomComplet, et_nomUti, et_age, et_courriel, et_pays;
    private Button btn_enregistrer;
    FirebaseAuth bdAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // recuperation du curriel et du nom
        et_nomComplet = findViewById(R.id.et_PP_nomComplet);
        et_nomUti = findViewById(R.id.et_PP_nomUti);
        et_age = findViewById(R.id.et_PP_age);
        et_courriel = findViewById(R.id.et_PP_courriel);
        et_pays = findViewById(R.id.et_PP_pays);

        // Initialisez FirebaseAuth
        bdAuth = FirebaseAuth.getInstance();

        FirebaseUser user = bdAuth.getCurrentUser();

        String userEmail = user.getEmail();
        String userName = user.getDisplayName();

        et_courriel.setText(userEmail);
        et_nomComplet.setText(userName);



    }
}