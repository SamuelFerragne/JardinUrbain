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


        }
    }
}