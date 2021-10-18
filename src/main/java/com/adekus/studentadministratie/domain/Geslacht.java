package com.adekus.studentadministratie.domain;

import org.thymeleaf.exceptions.TemplateProcessingException;

import javax.persistence.*;
import java.util.List;

@Entity
public class Geslacht {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String naam;

    @OneToMany(mappedBy = "geslacht")
    private List<Persoon> personen;

    public Geslacht() {

    }

    public int getId() {
        return id;
    }

    public void setId(int geslacht_id) {
        this.id = geslacht_id;
    }

    public String getNaam() {
            return naam;
     }

    public void setNaam(String geslacht) {
        this.naam = geslacht;
    }
}
