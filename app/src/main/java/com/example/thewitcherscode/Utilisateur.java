package com.example.thewitcherscode;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

public class Utilisateur implements Parcelable {

    private String nom;
    private String userName;
    private String courriel;
    private int age;
    private String localisation;

    private List<String> parcelLouer;
    private List<String> parcelOffert;

    // constructeur
    public Utilisateur(String nom, String userName, String courriel, int age, String localisation, List<String>  parcelLouer, List<String>  parcelOffert) {
        this.nom = nom;
        this.userName = userName;
        this.courriel = courriel;
        this.age = age;
        this.localisation = localisation;
        this.parcelLouer = parcelLouer;
        this.parcelOffert = parcelOffert;
    }

    // constructeur par defaut
    public Utilisateur(){

    }


    protected Utilisateur(Parcel in) {
        nom = in.readString();
        userName = in.readString();
        courriel = in.readString();
        age = in.readInt();
        localisation = in.readString();
        parcelLouer = in.createStringArrayList();
        parcelOffert = in.createStringArrayList();
    }

    public static final Creator<Utilisateur> CREATOR = new Creator<Utilisateur>() {
        @Override
        public Utilisateur createFromParcel(Parcel in) {
            return new Utilisateur(in);
        }

        @Override
        public Utilisateur[] newArray(int size) {
            return new Utilisateur[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeString(userName);
        dest.writeString(courriel);
        dest.writeInt(age);
        dest.writeString(localisation);
        dest.writeStringList(parcelLouer);
        dest.writeStringList(parcelOffert);
    }

    // getter et setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public List<String> getParcelLouer() {
        return parcelLouer;
    }

    public void setParcelLouer(List<String>  parcelLouer) {
        this.parcelLouer = parcelLouer;
    }

    public List<String> getParcelOffert() {
        return parcelOffert;
    }

    public void setParcelOffert(List<String>  parcelOffert) {
        this.parcelOffert = parcelOffert;
    }



    // toString


    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", userName='" + userName + '\'' +
                ", courriel='" + courriel + '\'' +
                ", age=" + age +
                ", localisation='" + localisation + '\'' +
                '}';
    }
}
