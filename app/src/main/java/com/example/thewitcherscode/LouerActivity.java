package com.example.thewitcherscode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class LouerActivity extends AppCompatActivity {
    private Spinner spinnerNbParcelles;
    private TextView tvPrixTotal;
    private Jardin jardin;
    BottomNavigationView bnv_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_louer);

        ViewPager   VP_imageParcelle    =   findViewById(R.id.VP_imageParcelle);
        Toolbar     tb_retour           =   findViewById(R.id.tb_retour);
        TextView    tv_adresse          =   findViewById(R.id.tv_adresse);
        TextView    tv_superficie       =   findViewById(R.id.tv_superficie);
        TextView    tv_description      =   findViewById(R.id.tv_description);
        TextView    tv_contact          =   findViewById(R.id.tv_contact);
        TextView    tv_prixMensuel      =   findViewById(R.id.tv_prixMensuel);
        spinnerNbParcelles = findViewById(R.id.spinner_nbParcelles);
        tvPrixTotal = findViewById(R.id.tv_prixTotal);
        bnv_navigation = findViewById(R.id.bnv_navigation);
        bnv_navigation.setItemIconTintList(null);
        bnv_navigation.setItemIconSize(150);
        setSupportActionBar(tb_retour);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intention = getIntent();
        int id = intention.getIntExtra("id", 0);
        bnv_navigation.setSelectedItemId(id);
        bnv_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                Intent intention;
                int id = item.getItemId();

                if (id == R.id.action_louer) {
                    intention = new Intent(LouerActivity.this, ParcelleOffertActivity.class);
                    startActivity(intention);

                } else if (id == R.id.action_marche) {

                } else if (id == R.id.action_carte) {

                } else if (id == R.id.action_reseau) {

                } else if (id == R.id.action_profil) {
                    intention = new Intent(LouerActivity.this, inscriptionActivity.class);
                    intention.putExtra("id", id);
                    startActivity(intention);
                }


                return false;
            }
        });




        Intent intent = getIntent();
        if (intent != null) {
            jardin = intent.getParcelableExtra("jardin");

            if (jardin != null) {
                List<Integer> images = jardin.getImages();

                if (images != null && !images.isEmpty()) {
                    ImagePagerAdapter imageAdapter = new ImagePagerAdapter(this, getSupportFragmentManager(), images);
                    VP_imageParcelle.setAdapter(imageAdapter);
                } else {
                    // Log ou gestion d'erreur si la liste d'images est null ou vide
                }
            }

            List<String> options = generateParcellesOptions();
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_spinner_item,
                    options
            );
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerNbParcelles.setAdapter(adapter);

            spinnerNbParcelles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    // Mettre à jour le TextView avec le prix total en fonction du nombre de parcelles sélectionné
                    updatePrixTotal();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // Ne rien faire ici
                }
            });


            tv_adresse.setText(jardin.getAdresse());
            tv_superficie.setText(jardin.getSuperficieParcelle());
            tv_description.setText(jardin.getDescription());
            tv_contact.setText(jardin.getOwner());
            tv_prixMensuel.setText(jardin.getPrixParcelle()+"$");


        }
    }

    private List<String> generateParcellesOptions() {
        List<String> options = new ArrayList<>();
        int nbParcelles = jardin.getNbParcelles(); // Remplacez cela par la méthode appropriée pour obtenir le nombre de parcelles

        for (int i = 1; i <= nbParcelles; i++) {
            options.add(String.valueOf(i));
        }

        return options;
    }

    // Méthode pour mettre à jour le TextView du prix total
    private void updatePrixTotal() {
        int nbParcelles = Integer.parseInt(spinnerNbParcelles.getSelectedItem().toString());
        double prixParParcelle = jardin.getPrixParcelle(); // Remplacez cela par la méthode appropriée pour obtenir le prix par parcelle
        double prixTotal = nbParcelles * prixParParcelle;

        tvPrixTotal.setText("Prix Total: " + prixTotal);
    }
}