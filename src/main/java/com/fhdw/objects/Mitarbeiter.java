package com.fhdw.objects;

import javassist.bytecode.ByteArray;

import java.util.Date;

/**
 * Created by timon on 02.05.2017.
 */

public class Mitarbeiter extends Person {
    private Integer MitarbeiterID;
    private Integer Position; // 1 = Mitarbeiter | 2 = Mentor

    protected  Mitarbeiter(){}

    public Mitarbeiter(String vorname, String nachname, String geschlecht, String email, Date geburtsdatum, Integer PLZ, String ort, String straße, ByteArray profilbild, Boolean activated, Integer mitarbeiterID, Integer position) {
        super(vorname, nachname, geschlecht, email, geburtsdatum, PLZ, ort, straße, profilbild, activated);
        MitarbeiterID = mitarbeiterID;
        Position = position;
    }

    public Integer getMitarbeiterID() {
        return MitarbeiterID;
    }

    public void setMitarbeiterID(Integer mitarbeiterID) {
        MitarbeiterID = mitarbeiterID;
    }

    public Integer getPosition() {
        return Position;
    }

    public void setPosition(Integer position) {
        Position = position;
    }
}

