package com.fhdw.objects;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Base64;
import java.util.Date;
import com.fhdw.enums.Role;

/**
 * Created by timon on 02.05.2017.
 */

@Entity // Hibernate erstellt eine Tabelle aus dieser Klasse
public class Mitarbeiter{
    @Id
    @Column(nullable = false, unique = true)
    private String Email;
    private String Vorname;
    private String Nachname;
    private String Geschlecht;
    private Date Geburtsdatum;
    private Integer PLZ;
    private String Ort;
    private String Straße;
    @Length(min = 5, message = "*Dein Passwort muss 5 Zeichen lang sein")
    @NotEmpty(message = "*Bitte gib ein Passwort ein")
    private String Passwort;
    @Enumerated(EnumType.STRING)
    private Role Role;
    private Integer Position; // 1 = Mitarbeiter | 2 = Mentor
    private Base64 Profilbild;
    private Boolean Activated;

    public Mitarbeiter(){}

    public Mitarbeiter(String vorname, String nachname, String geschlecht, String email, Date geburtsdatum, Integer PLZ, String ort, String straße, String passwort, Role role, Integer position, Base64 profilbild, Boolean activated) {
        Vorname = vorname;
        Nachname = nachname;
        Geschlecht = geschlecht;
        Email = email;
        Geburtsdatum = geburtsdatum;
        this.PLZ = PLZ;
        Ort = ort;
        Straße = straße;
        Passwort = passwort;
        Role = role;
        Position = position;
        Profilbild = profilbild;
        Activated = activated;
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

    public String getPasswort() {
        return Passwort;
    }

    public void setPasswort(String passwort) {
        Passwort = passwort;
    }

    public Role getRole() {
        return Role;
    }

    public void setRole(Role role) {
        Role = role;
    }

    public Integer getPosition() {
        return Position;
    }

    public void setPosition(Integer position) {
        Position = position;
    }

    public Base64 getProfilbild() {
        return Profilbild;
    }

    public void setProfilbild(Base64 profilbild) {
        Profilbild = profilbild;
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
                "Email='" + Email + '\'' +
                ", Vorname='" + Vorname + '\'' +
                ", Nachname='" + Nachname + '\'' +
                ", Geschlecht='" + Geschlecht + '\'' +
                ", Geburtsdatum=" + Geburtsdatum +
                ", PLZ=" + PLZ +
                ", Ort='" + Ort + '\'' +
                ", Straße='" + Straße + '\'' +
                ", Passwort='" + Passwort + '\'' +
                ", Role=" + Role +
                ", Position=" + Position +
                ", Profilbild=" + Profilbild +
                ", Activated=" + Activated +
                '}';
    }
}

