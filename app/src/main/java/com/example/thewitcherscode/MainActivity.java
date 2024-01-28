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
        Jardin jardinTest = createJardinTest();
        Intent intent = new Intent(this, LouerActivity.class);
        intent.putExtra("jardin", jardinTest);
        startActivity(intent);
    }

    private Jardin createJardinTest() {
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.terre_cultive);
        images.add(R.drawable.terre_agricole);

        Log.w("myApp",images+"");

        return new Jardin(
                "Adresse de test",
                500.0,
                "Description de test",
                "test@email.com",
                5,
                "150m",
                5,
                images
        );
    }
}