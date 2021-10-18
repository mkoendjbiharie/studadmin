package com.adekus.studentadministratie.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
Een Persoon kan meerdere studies doen.
 */
@Entity
public class Student{
    @Id
    private String studentNr;//Waarde moet gegenereerd worden
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studierichting_id",referencedColumnName = "id")
    private Studierichting studierichting;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collegejaar_id",referencedColumnName = "id")
    private Collegejaar collegejaar;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "persoon_id", referencedColumnName = "id")
    @NotNull(message = "Verplicht invullen!")
    private Persoon persoon;

    private Long getInschrijfjaar(){
        return getCollegejaar().getJaar();
    }

    public Student() {
    }

    public String getStudentNr() {
        return studentNr;
    }

    public void setStudentNr(String studentNr) {
        this.studentNr = studentNr;
    }

    public Studierichting getStudierichting() {
        return studierichting;
    }

    public void setStudierichting(Studierichting studierichting) {
        this.studierichting = studierichting;
    }

    public Collegejaar getCollegejaar() {
        return collegejaar;
    }

    public void setCollegejaar(Collegejaar collegejaar) {
        this.collegejaar = collegejaar;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public String getNamen(){
        return this.getPersoon().getNamenEnId();
    }
}
