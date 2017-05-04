package com.fhdw.objects;

/**
 * Created by timon on 02.05.2017.
 */
public class Mitarbeiter extends Person {
    private Integer MitarbeiterID;
    private Integer Position; // 1 = Mitarbeiter | 2 = Mentor

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

