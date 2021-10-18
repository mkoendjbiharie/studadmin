package com.adekus.studentadministratie.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Nationaliteit {
    @Id
	@GeneratedValue
    private int id;
    @Column
    private String naam;
    @OneToMany(mappedBy = "nationaliteit")
    private List<Persoon> personen;

	public int getId() {
		return id;
	}
	public void setId(int nationaliteitId) {
		this.id = nationaliteitId;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String nationaliteit) {
		this.naam = nationaliteit;
	}
	@Override
	public String toString() {
		return "Nationaliteit [nationaliteitId=" + id + ", nationaliteit=" + naam + "]";
	}
}
