package com.example.thewitcherscode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParcelleOffertActivity extends AppCompatActivity {


    private static final int PICK_IMAGE_REQUEST_CODE = 1;
    private List<Uri> selectedImages = new ArrayList<>();

    private EditText etRue, etVille, etCode, editTextPrixParcelle, editTextNbParcelles, editTextDimension, editTextDescription;
    private Button btnEnregistrer, btnImportImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelle_offert);

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

                // Create a Jardin object with the user-entered values
                Jardin jardin = new Jardin(
                        rue + ", " + ville + ", " + code,
                        prixParcelle,
                        description,
                        "Owner Name", // You can replace "Owner Name" with the actual owner's name
                        0, // Default value for noteEtoile, you may want to change this
                        dimension,
                        nbParcelles,
                        new ArrayList<>() // An empty list for images, you can modify this based on your implementation
                );
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
            paths.add(uri.toString());
        }
        return paths;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}