package com.adekus.studentadministratie.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Burgelijkestaat {
    @Id
	@GeneratedValue
    private int id;
    @Column
    private String naam;
	@OneToMany(mappedBy = "burgelijkestaat")
	private List<Persoon> personen;
/*
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String burgelijkestaat) {
		this.naam = burgelijkestaat;
	}

	public List<Persoon> getPersonen() {
		return personen;
	}

	public void setPersonen(List<Persoon> personen) {
		this.personen = personen;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public List<Persoon> getPersonen() {
		return personen;
	}

	public void setPersonen(List<Persoon> personen) {
		this.personen = personen;
	}
}
