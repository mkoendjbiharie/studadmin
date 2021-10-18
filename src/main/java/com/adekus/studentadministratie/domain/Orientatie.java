package com.adekus.studentadministratie.domain;

import javax.persistence.*;

@Entity
public class Orientatie {
    @Id
    private String id;
    @Column
    private String naam;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studierichting_id",referencedColumnName = "id")
    private Studierichting studierichting;

    public String getId() {
        return id;
    }

    public void setId(String orientaieCode) {
        this.id = orientaieCode;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String orientatie) {
        this.naam = orientatie;
    }

    public Studierichting getStudierichting() {
        return studierichting;
    }

    public void setStudierichting(Studierichting studierichting) {
        this.studierichting = studierichting;
    }

    @Override
    public String toString() {
        return "Orientatie{" +
                "orientaieCode='" + id + '\'' +
                ", orientatie='" + naam + '\'' +
                ", studierichting='" + studierichting + '\'' +
                '}';
    }
}
