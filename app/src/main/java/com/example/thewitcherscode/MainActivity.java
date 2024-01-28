package com.example.thewitcherscode;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.widget.SearchView;

import android.location.Address;
import android.location.Geocoder;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentActivity;

import java.util.List;
import java.io.IOException;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.CameraUpdateFactory;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    BottomNavigationView bnv_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the SupportMapFragment and request notification when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
      
        bnv_navigation = findViewById(R.id.bnv_navigation);

        Intent intention = getIntent();
        int id = intention.getIntExtra("id", 0);
        bnv_navigation.setSelectedItemId(id);
        bnv_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                Intent intention;
                int id = item.getItemId();

                if (id == R.id.action_louer) {

                } else if (id == R.id.action_marche) {

                } else if (id == R.id.action_carte) {

                } else if (id == R.id.action_reseau) {

                } else if (id == R.id.action_profil) {
                    intention = new Intent(MainActivity.this, ProfileActivity.class);
                    intention.putExtra("id", id);
                    startActivity(intention);
                }


                return false;
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.

        LatLng defaultPos = new LatLng(45.49502662776999, -73.56203619520896);
        CameraPosition camPos = new CameraPosition.Builder().target(defaultPos).zoom(15).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(camPos));

    }
}
