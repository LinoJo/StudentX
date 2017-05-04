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
public class Studiengruppe {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer StudiengruppenID;
    private Integer MentorID;
    private String StudiengruppeName;
    private String StudiengangName;
    private String AbschlussTitel;
    private Date StartDatum;
    private Date EndeDatum;

    protected Studiengruppe(){};

    public Studiengruppe(Integer studiengruppenID, Integer mentorID, String studiengruppeName, String studiengangName, String abschlussTitel, Date startDatum, Date endeDatum) {
        StudiengruppenID = studiengruppenID;
        MentorID = mentorID;
        StudiengruppeName = studiengruppeName;
        StudiengangName = studiengangName;
        AbschlussTitel = abschlussTitel;
        StartDatum = startDatum;
        EndeDatum = endeDatum;
    }

    public Integer getStudiengruppenID() {
        return StudiengruppenID;
    }

    public void setStudiengruppenID(Integer studiengruppenID) {
        StudiengruppenID = studiengruppenID;
    }

    public Integer getMentorID() {
        return MentorID;
    }

    public void setMentorID(Integer mentorID) {
        MentorID = mentorID;
    }

    public String getStudiengruppeName() {
        return StudiengruppeName;
    }

    public void setStudiengruppeName(String studiengruppeName) {
        StudiengruppeName = studiengruppeName;
    }

    public String getStudiengangName() {
        return StudiengangName;
    }

    public void setStudiengangName(String studiengangName) {
        StudiengangName = studiengangName;
    }

    public String getAbschlussTitel() {
        return AbschlussTitel;
    }

    public void setAbschlussTitel(String abschlussTitel) {
        AbschlussTitel = abschlussTitel;
    }

    public Date getStartDatum() {
        return StartDatum;
    }

    public void setStartDatum(Date startDatum) {
        StartDatum = startDatum;
    }

    public Date getEndeDatum() {
        return EndeDatum;
    }

    public void setEndeDatum(Date endeDatum) {
        EndeDatum = endeDatum;
    }
}
