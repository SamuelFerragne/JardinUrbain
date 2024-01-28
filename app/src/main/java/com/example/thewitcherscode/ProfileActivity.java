package com.example.thewitcherscode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {
    Utilisateur currentUser = new Utilisateur();

    private EditText et_nomComplet, et_nomUti, et_age, et_courriel, et_pays;
    private Button btn_enregistrer;
    FirebaseAuth bdAuth;
    DatabaseReference bdRef;
    FirebaseDatabase bd = FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intention = getIntent();
        int id = intention.getIntExtra("id", 0);

        // recuperation du curriel et du nom
        et_nomComplet = findViewById(R.id.et_PP_nomComplet);
        et_nomUti = findViewById(R.id.et_PP_nomUti);
        et_age = findViewById(R.id.et_PP_age);
        et_courriel = findViewById(R.id.et_PP_courriel);
        et_pays = findViewById(R.id.et_PP_pays);

        // Initialisez FirebaseAuth
        bdAuth = FirebaseAuth.getInstance();
        bdRef = bd.getReference();
        DatabaseReference usersRef = bdRef.child("user");

        FirebaseUser user = bdAuth.getCurrentUser();
        String uID = user.getUid();

        Query query = usersRef.orderByKey().equalTo(uID);


        currentUser.setCourriel(user.getEmail());
        currentUser.setNom(user.getDisplayName()) ;

        /*
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot datasnap : snapshot.getChildren()) {
                    Utilisateur user = datasnap.child(uID).getValue(Utilisateur.class);
                    currentUser.setAge(user.getAge());
                    currentUser.setUserName(user.getUserName());
                    currentUser.setLocalisation(user.getLocalisation());
                    currentUser.setParcelLouer(user.getParcelLouer());
                    currentUser.setParcelOffert(user.getParcelOffert());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Log.d("USER", "onCreate: " + currentUser.toString());
        et_courriel.setText(currentUser.getCourriel().toString());
        et_nomComplet.setText(currentUser.getNom());
        et_nomUti.setText(currentUser.getUserName());
        et_pays.setText(currentUser.getLocalisation());
        et_age.setText(currentUser.getAge());

         */
    }
}