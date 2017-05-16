package com.fhdw.objects;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by timon on 02.05.2017.
 */

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity // Hibernate erstellt eine Tabelle aus dieser Klasse
@TableGenerator(name="gen",initialValue=0, allocationSize=10000000)
@SequenceGenerator(name="seq", sequenceName="DATA_SEQ",initialValue=1, allocationSize=10000000)
@GenericGenerator(name="generator", strategy="increment")
public class Student{

    @Id
    @GeneratedValue(generator="generator")
    private Long MatrikelID;
    private String Vorname;
    private String Nachname;
    private String Geschlecht;
    private String Email;
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date Geburtsdatum;
    private Integer PLZ;
    private String Ort;
    private String Straße;
    private Boolean Activated;
    private Long StudienGruppenID;
    private String Praxisfirma;

    public Student(){}

    public Student(String vorname, String nachname, String geschlecht, String email, Date geburtsdatum, Integer PLZ, String ort, String straße, Boolean activated, Long studienGruppenID, String praxisfirma) {
        Vorname = vorname;
        Nachname = nachname;
        Geschlecht = geschlecht;
        Email = email;
        Geburtsdatum = geburtsdatum;
        this.PLZ = PLZ;
        Ort = ort;
        Straße = straße;
        Activated = activated;
        StudienGruppenID = studienGruppenID;
        Praxisfirma = praxisfirma;
    }

    public Long getMatrikelID() {
        return MatrikelID;
    }

    public void setMatrikelID(Long matrikelID) {
        MatrikelID = matrikelID;
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

    public Boolean getActivated() {
        return Activated;
    }

    public void setActivated(Boolean activated) {
        Activated = activated;
    }

    public Long getStudienGruppenID() {
        return StudienGruppenID;
    }

    public void setStudienGruppenID(Long studienGruppenID) {
        StudienGruppenID = studienGruppenID;
    }

    public String getPraxisfirma() {
        return Praxisfirma;
    }

    public void setPraxisfirma(String praxisfirma) {
        Praxisfirma = praxisfirma;
    }

    @Override
    public String toString() {
        return "Student{" +
                "MatrikelID=" + MatrikelID +
                ", Vorname='" + Vorname + '\'' +
                ", Nachname='" + Nachname + '\'' +
                ", Geschlecht='" + Geschlecht + '\'' +
                ", Email='" + Email + '\'' +
                ", Geburtsdatum=" + Geburtsdatum +
                ", PLZ=" + PLZ +
                ", Ort='" + Ort + '\'' +
                ", Straße='" + Straße + '\'' +
                ", Activated=" + Activated +
                ", StudienGruppenID=" + StudienGruppenID +
                ", Praxisfirma='" + Praxisfirma + '\'' +
                '}';
    }
}
