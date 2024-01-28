package com.example.thewitcherscode;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Arrays;

public class Utilisateur implements Parcelable {

    private String nom;
    private String userName;
    private String courriel;
    private String motpass;
    private int age;
    private String localisation;

    private String [] parcelLouer;
    private String [] parcelOffert;

    // constructeur
    public Utilisateur(String nom, String userName, String courriel, String motpass, int age, String localisation, String[] parcelLouer, String[] parcelOffert) {
        this.nom = nom;
        this.userName = userName;
        this.courriel = courriel;
        this.motpass = motpass;
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
        motpass = in.readString();
        age = in.readInt();
        localisation = in.readString();
        parcelLouer = in.createStringArray();
        parcelOffert = in.createStringArray();
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
        dest.writeString(motpass);
        dest.writeInt(age);
        dest.writeString(localisation);
        dest.writeStringArray(parcelLouer);
        dest.writeStringArray(parcelOffert);
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

    public String getMotpass() {
        return motpass;
    }

    public void setMotpass(String motpass) {
        this.motpass = motpass;
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

    public String[] getParcelLouer() {
        return parcelLouer;
    }

    public void setParcelLouer(String[] parcelLouer) {
        this.parcelLouer = parcelLouer;
    }

    public String[] getParcelOffert() {
        return parcelOffert;
    }

    public void setParcelOffert(String[] parcelOffert) {
        this.parcelOffert = parcelOffert;
    }



    // toString


    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", userName='" + userName + '\'' +
                ", courriel='" + courriel + '\'' +
                ", motpass='" + motpass + '\'' +
                ", age=" + age +
                ", localisation='" + localisation + '\'' +
                ", parcelLouer=" + Arrays.toString(parcelLouer) +
                ", parcelOffert=" + Arrays.toString(parcelOffert) +
                '}';
    }
}
