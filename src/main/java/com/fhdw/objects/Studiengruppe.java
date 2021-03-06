package com.fhdw.objects;

/**
 * Created by timon on 02.05.2017.
 */

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // Hibernate erstellt eine Tabelle aus dieser Klasse
public class Studiengruppe {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long StudiengruppenID;
    private String MentorEmail;
    private String StudiengruppeName;
    private String StudiengangName;
    private String AbschlussTitel;
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date StartDatum;
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date EndeDatum;

    public Studiengruppe(){};

    public Studiengruppe(Long studiengruppenID, String mentorEmail, String studiengruppeName, String studiengangName, String abschlussTitel, Date startDatum, Date endeDatum) {
        StudiengruppenID = studiengruppenID;
        MentorEmail = mentorEmail;
        StudiengruppeName = studiengruppeName;
        StudiengangName = studiengangName;
        AbschlussTitel = abschlussTitel;
        StartDatum = startDatum;
        EndeDatum = endeDatum;
    }

    public Long getStudiengruppenID() {
        return StudiengruppenID;
    }

    public void setStudiengruppenID(Long studiengruppenID) {
        StudiengruppenID = studiengruppenID;
    }

    public String getMentorEmail() {
        return MentorEmail;
    }

    public void setMentorEmail(String mentorEmail) {
        MentorEmail = mentorEmail;
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

    @Override
    public String toString() {
        return "Studiengruppe{" +
                "StudiengruppenID=" + StudiengruppenID +
                ", MentorEmail=" + MentorEmail +
                ", StudiengruppeName='" + StudiengruppeName + '\'' +
                ", StudiengangName='" + StudiengangName + '\'' +
                ", AbschlussTitel='" + AbschlussTitel + '\'' +
                ", StartDatum=" + StartDatum +
                ", EndeDatum=" + EndeDatum +
                '}';
    }
}
