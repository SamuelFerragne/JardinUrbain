package com.example.thewitcherscode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the SupportMapFragment and request notification when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
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