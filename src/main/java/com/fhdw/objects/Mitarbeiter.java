package com.fhdw.objects;

/**
 * Created by timon on 02.05.2017.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // Hibernate erstellt eine Tabelle aus dieser Klasse
public class Mitarbeiter{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long MitarbeiterID;
    private String Vorname;
    private String Nachname;
    private String Geschlecht;
    private String Email;
    private Date Geburtsdatum;
    private Integer PLZ;
    private String Ort;
    private String Straße;
    private String PasswortHash;
    private Integer Position; // 1 = Mitarbeiter | 2 = Mentor
    private Boolean Activated;

    protected Mitarbeiter(){}

    public Mitarbeiter(String vorname, String nachname, String geschlecht, String email, Date geburtsdatum, Integer PLZ, String ort, String straße, String passwortHash, Integer position, Boolean activated) {
        Vorname = vorname;
        Nachname = nachname;
        Geschlecht = geschlecht;
        Email = email;
        Geburtsdatum = geburtsdatum;
        this.PLZ = PLZ;
        Ort = ort;
        Straße = straße;
        PasswortHash = passwortHash;
        Position = position;
        Activated = activated;
    }

    public Long getMitarbeiterID() {
        return MitarbeiterID;
    }

    public void setMitarbeiterID(Long mitarbeiterID) {
        MitarbeiterID = mitarbeiterID;
    }

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

    public String getPasswortHash() {
        return PasswortHash;
    }

    public void setPasswortHash(String passwortHash) {
        PasswortHash = passwortHash;
    }

    public Integer getPosition() {
        return Position;
    }

    public void setPosition(Integer position) {
        Position = position;
    }

    public Boolean getActivated() {
        return Activated;
    }

    public void setActivated(Boolean activated) {
        Activated = activated;
    }

    @Override
    public String toString() {
        return "Mitarbeiter{" +
                "MitarbeiterID=" + MitarbeiterID +
                ", Vorname='" + Vorname + '\'' +
                ", Nachname='" + Nachname + '\'' +
                ", Geschlecht='" + Geschlecht + '\'' +
                ", Email='" + Email + '\'' +
                ", Geburtsdatum=" + Geburtsdatum +
                ", PLZ=" + PLZ +
                ", Ort='" + Ort + '\'' +
                ", Straße='" + Straße + '\'' +
                ", PasswortHash='" + PasswortHash + '\'' +
                ", Position=" + Position +
                ", Activated=" + Activated +
                '}';
    }
}

