package com.example.stippejan.aufgabe2;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
    private int speciesStringId;        // Id eines Strings, um die Art eines Tiers festzulegen
    private int genderStringId;         // Id eines Strings, um das Geschlecht eines Tiers festzulegen
    private int age;                    // Alter des Tiers

    // Getter- und Setter-Methoden
    public int getSpeciesStringId() {
        return speciesStringId;
    }

    public int getGenderStringId() {
        return genderStringId;
    }

    public int getAge() {
        return age;
    }

    public void setSpeciesStringId(int speciesStringId) {
        this.speciesStringId = speciesStringId;
    }

    public void setGenderStringId(int genderStringId) {
        this.genderStringId = genderStringId;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Konstruktor
    public Animal(int speciesStringId, int genderStringId, int age) {
        this.speciesStringId = speciesStringId;
        this.genderStringId = genderStringId;
        this.age = age;
    }

    // Methoden, die für die Parcelable-Funktionalität benötigt werden
    protected Animal(Parcel in) {
        speciesStringId = in.readInt();
        genderStringId = in.readInt();
        age = in.readInt();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(speciesStringId);
        dest.writeInt(genderStringId);
        dest.writeInt(age);
    }
}
