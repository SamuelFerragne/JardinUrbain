package com.example.thewitcherscode;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParcelleOffertActivity extends AppCompatActivity {

    String projectID = "thewitchercode";
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    FirebaseAuth bdAuth;
    DatabaseReference databaseReference = database.getReference(projectID);
    private static final int PICK_IMAGE_REQUEST_CODE = 1;
    private List<Uri> selectedImages = new ArrayList<>();

    private EditText etRue, etVille, etCode, editTextPrixParcelle, editTextNbParcelles, editTextDimension, editTextDescription;
    private Button btnEnregistrer, btnImportImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelle_offert);

        FirebaseApp.initializeApp(this);

        bdAuth = FirebaseAuth.getInstance();

        etRue = findViewById(R.id.et_rue);
        etVille = findViewById(R.id.et_ville);
        etCode = findViewById(R.id.et_Code);
        editTextPrixParcelle = findViewById(R.id.editTextText);
        editTextNbParcelles = findViewById(R.id.editTextText2);
        editTextDimension = findViewById(R.id.editTextText3);
        editTextDescription = findViewById(R.id.editTextTextMultiLine);

        btnImportImage = findViewById(R.id.btnImportImage);
        btnEnregistrer = findViewById(R.id.btnEnregistrer);

        btnImportImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagePicker();
            }
        });

        btnEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get values entered by the user
                String rue = etRue.getText().toString();
                String ville = etVille.getText().toString();
                String code = etCode.getText().toString();
                double prixParcelle = Double.parseDouble(editTextPrixParcelle.getText().toString());
                int nbParcelles = Integer.parseInt(editTextNbParcelles.getText().toString());
                String dimension = editTextDimension.getText().toString();
                String description = editTextDescription.getText().toString();

                DatabaseReference jardinsRef = databaseReference.child("jardins");
                // Create a Jardin object with the user-entered values
                Jardin jardin = new Jardin(
                        rue + ", " + ville + ", " + code,
                        prixParcelle,
                        description,
                        bdAuth.getCurrentUser().getUid(),
                        0,
                        dimension,
                        nbParcelles,
                        getImagesIds(selectedImages) // Pass the list of image URLs as strings
                );
                // Get a reference to the "jardins" node in your database
                Log.d("DBREPORT","first shit");


                Map<String, Jardin> jardins = new HashMap<>();
                jardins.put(jardin.getOwner() + "_" + code, jardin);

                //jardinsRef.setValueAsync(jardins);
                jardinsRef.setValue(jardins);

                //Push the Jardin object to the database
                DatabaseReference newJardinRef = jardinsRef.push();
                newJardinRef.setValue(jardin);

                // Display a success message
                showToast("Jardin enregistré avec succès");
            }
        });

    }
    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(intent, PICK_IMAGE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                if (data.getClipData() != null) {
                    // Multiple images are selected
                    int count = data.getClipData().getItemCount();
                    for (int i = 0; i < count; i++) {
                        Uri imageUri = data.getClipData().getItemAt(i).getUri();
                        selectedImages.add(imageUri);
                    }
                } else if (data.getData() != null) {
                    // Single image is selected
                    Uri imageUri = data.getData();
                    selectedImages.add(imageUri);
                }

                // Handle the selected images as needed (e.g., display thumbnails)
                showToast("Images selected: " + selectedImages.size());
            }
        }
    }

    private List<String> getImagesPaths(List<Uri> uris) {
        List<String> paths = new ArrayList<>();
        for (Uri uri : uris) {
            paths.add(uri.toString());  // Convert Uri to String
        }
        return paths;
    }

    private List<Integer> getImagesIds(List<Uri> uris) {
        List<Integer> ids = new ArrayList<>();
        for (Uri uri : uris) {
            int imageId = uri.hashCode(); // Convert Uri to Integer using hashCode
            ids.add(imageId);
        }
        return ids;
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    private void checkAndCreateJardinsNode() {
        DatabaseReference jardinsRef = databaseReference.child("jardins");
        jardinsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!dataSnapshot.exists()) {
                    // "jardins" node doesn't exist, create it
                    jardinsRef.setValue(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors if needed
            }
        });
    }
    private void setupDatabase() {
        checkAndCreateJardinsNode();
    }
}