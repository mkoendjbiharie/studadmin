package com.adekus.studentadministratie.domain;

import javax.persistence.*;

@Entity
public class Maxnummers {
    @Id
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Studierichting studierichting;
    @ManyToOne(fetch = FetchType.LAZY)
    private Collegejaar collegejaar;
    @Column
    private int max;

    public Maxnummers(Collegejaar collegejaar, Studierichting studierichting, int max) {
        this.collegejaar = collegejaar;
        this.studierichting = studierichting;
        this.max = max;
    }

    public Maxnummers() {

    }

    public Collegejaar getCollegejaar() {
        return collegejaar;
    }

    public void setCollegejaar(Collegejaar collegejaar) {
        this.collegejaar = collegejaar;
    }

    public Studierichting getStudierichting() {
        return studierichting;
    }

    public void setStudierichting(Studierichting studierichting) {
        this.studierichting = studierichting;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
