package com.example.thewitcherscode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class LouerActivity extends AppCompatActivity {

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
        TextView    tv_note             =   findViewById(R.id.tv_note);
        setSupportActionBar(tb_retour);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if (intent != null) {
            Parcelle parcelle = intent.getParcelableExtra("parcelle");

            if (parcelle != null) {
                List<Integer> images = parcelle.getImages();

                if (images != null && !images.isEmpty()) {
                    ImagePagerAdapter adapter = new ImagePagerAdapter(this, getSupportFragmentManager(), images);
                    VP_imageParcelle.setAdapter(adapter);
                } else {
                    // Log ou gestion d'erreur si la liste d'images est null ou vide
                }
            }

            tv_adresse.setText(parcelle.getAdresse());
            tv_superficie.setText(parcelle.getSuperficie());
            tv_description.setText(parcelle.getDescription());
            tv_contact.setText(parcelle.getContactCourriel());
            tv_prixMensuel.setText(parcelle.getPrixParMois()+"$");
            tv_note.setText(parcelle.getNoteEtoile()+" ");


        }
    }
}