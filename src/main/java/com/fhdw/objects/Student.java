package com.fhdw.objects;

/**
 * Created by timon on 02.05.2017.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Student extends Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer MatrikelID;
    private Integer StudienGruppenID;
    private String Praxisfirma;

    public Integer getMatrikelID() {
        return MatrikelID;
    }

    public void setMatrikelID(Integer matrikelID) {
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
