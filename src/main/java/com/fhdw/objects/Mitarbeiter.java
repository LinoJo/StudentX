package com.fhdw.objects;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
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
    private String Strasse;
    @Length(min = 5, message = "*Dein Passwort muss 5 Zeichen lang sein")
    @NotEmpty(message = "*Bitte gib ein Passwort ein")
    private String Passwort;
    @Enumerated(EnumType.STRING)
    private Role Role;
    private Integer Position; // 1 = Mitarbeiter | 2 = Mentor
    private Boolean Activated;

    public Mitarbeiter(){}

    public Mitarbeiter(String vorname, String nachname, String geschlecht, String email, Date geburtsdatum, Integer PLZ, String ort, String strasse, String passwort, Role role, Integer position, Boolean activated) {
        Vorname = vorname;
        Nachname = nachname;
        Geschlecht = geschlecht;
        Email = email;
        Geburtsdatum = geburtsdatum;
        this.PLZ = PLZ;
        Ort = ort;
        Strasse = strasse;
        Passwort = passwort;
        Role = role;
        Position = position;
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

    public String getStrasse() {
        return Strasse;
    }

    public void setStrasse(String strasse) {
        Strasse = strasse;
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
                ", Strasse='" + Strasse + '\'' +
                ", Passwort='" + Passwort + '\'' +
                ", Role=" + Role +
                ", Position=" + Position +
                ", Activated=" + Activated +
                '}';
    }
}

