package com.adekus.studentadministratie.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Collegejaar {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private Long jaar;
    @OneToMany(mappedBy = "collegejaar")
    private List<Student> studenten;
    @OneToMany(mappedBy = "collegejaar")
    private List<Maxnummers> maxnummers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getJaar() {
        return jaar;
    }

    public void setJaar(Long jaar) {
        this.jaar = jaar;
    }

    public List<Student> getStudenten() {
        return studenten;
    }

    public void setStudenten(List<Student> studenten) {
        this.studenten = studenten;
    }

    public List<Maxnummers> getMaxnummers() {
        return maxnummers;
    }

    public void setMaxnummers(List<Maxnummers> maxnummers) {
        this.maxnummers = maxnummers;
    }
}
