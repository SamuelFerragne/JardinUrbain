package com.example.thewitcherscode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ouvrirLouerActivity(View view) {
        Parcelle parcelleTest = createParcelleTest();
        Intent intent = new Intent(this, LouerActivity.class);
        intent.putExtra("parcelle", parcelleTest);
        startActivity(intent);
    }

    private Parcelle createParcelleTest() {
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.terre_cultive);
        images.add(R.drawable.terre_agricole);

        Log.w("myApp",images+"");

        return new Parcelle(
                "Adresse de test",
                500.0,
                "Description de test",
                "test@email.com",
                "123456789",
                5,
                "150m",
                images
        );
    }
}