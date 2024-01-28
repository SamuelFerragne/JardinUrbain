package com.example.thewitcherscode;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Jardin implements Parcelable {

    private String adresse;
    private double prixParcelle;
    private String description;
    private String owner;
    private int noteEtoile;
    private String superficieParcelle;
    private List<Integer> images;
    private int nbParcelles;


    public static final Parcelable.Creator<Jardin> CREATOR = new Parcelable.Creator<Jardin>() {
        @Override
        public Jardin createFromParcel(Parcel in) {
            return new Jardin(in);
        }

        @Override
        public Jardin[] newArray(int size) {
            return new Jardin[size];
        }
    };

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    // Constructeur
    public Jardin(String adresse, double prixParcelle, String description, String owner,
                  int noteEtoile, String superficieParcelle, int nbParcelles, List<Integer> images) {
        this.adresse = adresse;
        this.prixParcelle = prixParcelle;
        this.description = description;
        this.owner = owner;
        this.noteEtoile = noteEtoile;
        this.superficieParcelle = superficieParcelle;
        this.nbParcelles = nbParcelles;
        this.images = images;
    }

    protected Jardin(Parcel in) {
        adresse = in.readString();
        prixParcelle = in.readDouble();
        description = in.readString();
        owner = in.readString();
        noteEtoile = in.readInt();
        superficieParcelle = in.readString();
        nbParcelles = in.readInt();
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

    public double getPrixParcelle() {
        return prixParcelle;
    }

    public int getNbParcelles() {
        return nbParcelles;
    }

    public void setNbParcelles(int nbParcelles) {
        this.nbParcelles = nbParcelles;
    }

    public String getDescription() {
        return description;
    }

    public int getNoteEtoile() {
        return noteEtoile;
    }

    public String getSuperficieParcelle() {
        return superficieParcelle;
    }


    // Méthodes Setter
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setPrixParcelle(double prixParcelle) {
        this.prixParcelle = prixParcelle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNoteEtoile(int noteEtoile) {
        this.noteEtoile = noteEtoile;
    }

    public void setSuperficieParcelle(String superficieParcelle) {
        this.superficieParcelle = superficieParcelle;
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
        dest.writeDouble(prixParcelle);
        dest.writeString(description);
        dest.writeString(owner);
        dest.writeInt(noteEtoile);
        dest.writeString(superficieParcelle);
        dest.writeInt(nbParcelles);
        dest.writeList(images);
    }
}