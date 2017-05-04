package com.fhdw.objects;

import javassist.bytecode.ByteArray;

import java.util.Date;

/**
 * Created by timon on 02.05.2017.
 */
public class Person {

    private String Vorname;
    private String Nachname;
    private String Geschlecht;
    private String Email;
    private Date Geburtsdatum;
    private Integer PLZ;
    private String Ort;
    private String Straße;
    private ByteArray Profilbild;
    private Boolean Activated;



    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public String getGeschlecht() {
        return Geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        Geschlecht = geschlecht;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getGeburtsdatum() {
        return Geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        Geburtsdatum = geburtsdatum;
    }

    public Integer getPLZ() {
        return PLZ;
    }

    public void setPLZ(Integer PLZ) {
        this.PLZ = PLZ;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String ort) {
        Ort = ort;
    }

    public String getStraße() {
        return Straße;
    }

    public void setStraße(String straße) {
        Straße = straße;
    }

    public ByteArray getProfilbild() {
        return Profilbild;
    }

    public void setProfilbild(ByteArray profilbild) {
        Profilbild = profilbild;
    }

    public Boolean getActivated() {
        return Activated;
    }

    public void setActivated(Boolean activated) {
        Activated = activated;
    }

}
