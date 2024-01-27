package com.example.thewitcherscode;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Parcelle implements Parcelable {

    private String adresse;
    private double prixParMois;
    private String description;
    private String contactCourriel;
    private String contactTelephone;
    private int noteEtoile;
    private double superficie;
    private List<Integer> images;

    public static final Parcelable.Creator<Parcelle> CREATOR = new Parcelable.Creator<Parcelle>() {
        @Override
        public Parcelle createFromParcel(Parcel in) {
            return new Parcelle(in);
        }

        @Override
        public Parcelle[] newArray(int size) {
            return new Parcelle[size];
        }
    };

    // Constructeur
    public Parcelle(String adresse, double prixParMois, String description, String contactCourriel,
                    String contactTelephone, int noteEtoile, double superficie,List<Integer> images) {
        this.adresse = adresse;
        this.prixParMois = prixParMois;
        this.description = description;
        this.contactCourriel = contactCourriel;
        this.contactTelephone = contactTelephone;
        this.noteEtoile = noteEtoile;
        this.superficie = superficie;
        this.images = images;
    }

    protected Parcelle(Parcel in) {
        adresse = in.readString();
        prixParMois = in.readDouble();
        description = in.readString();
        contactCourriel = in.readString();
        contactTelephone = in.readString();
        noteEtoile = in.readInt();
        superficie = in.readDouble();
        images = new ArrayList<>();
        in.readList(images, Integer.class.getClassLoader());
    }


    public void ajouterImage(int imageResource) {
        images.add(imageResource);
    }

    // Méthodes Getter

    public List<Integer> getImages() {
        return images;
    }
    public String getAdresse() {
        return adresse;
    }

    public double getPrixParMois() {
        return prixParMois;
    }

    public String getDescription() {
        return description;
    }

    public String getContactCourriel() {
        return contactCourriel;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public int getNoteEtoile() {
        return noteEtoile;
    }

    public double getSuperficie() {
        return superficie;
    }

    // Méthodes Setter
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setPrixParMois(double prixParMois) {
        this.prixParMois = prixParMois;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContactCourriel(String contactCourriel) {
        this.contactCourriel = contactCourriel;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public void setNoteEtoile(int noteEtoile) {
        this.noteEtoile = noteEtoile;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }
    public void setImages(List<Integer> images) {
        this.images = images;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(adresse);
        dest.writeDouble(prixParMois);
        dest.writeString(description);
        dest.writeString(contactCourriel);
        dest.writeString(contactTelephone);
        dest.writeInt(noteEtoile);
        dest.writeDouble(superficie);
        dest.writeList(images);
    }
}

