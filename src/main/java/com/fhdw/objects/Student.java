package com.fhdw.objects;

/**
 * Created by timon on 02.05.2017.
 */

import javassist.bytecode.ByteArray;
import javax.persistence.*;
import java.util.Date;

@Entity // Hibernate erstellt eine Tabelle aus dieser Klasse
public class Student extends Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long MatrikelID;
    private Integer StudienGruppenID;
    private String Praxisfirma;

    protected Student(){}

    public Student(String vorname, String nachname, String geschlecht, String email, Date geburtsdatum, Integer PLZ, String ort, String straße, ByteArray profilbild, Boolean activated, Integer studienGruppenID, String praxisfirma) {
        super(vorname, nachname, geschlecht, email, geburtsdatum, PLZ, ort, straße, profilbild, activated);
        StudienGruppenID = studienGruppenID;
        Praxisfirma = praxisfirma;
    }

    public Long getMatrikelID() {
        return MatrikelID;
    }

    public void setMatrikelID(Long matrikelID) {
        MatrikelID = matrikelID;
    }

    public Integer getStudienGruppenID() {
        return StudienGruppenID;
    }

    public void setStudienGruppenID(Integer studienGruppenID) {
        StudienGruppenID = studienGruppenID;
    }

    public String getPraxisfirma() {
        return Praxisfirma;
    }

    public void setPraxisfirma(String praxisfirma) {
        Praxisfirma = praxisfirma;
    }

}
