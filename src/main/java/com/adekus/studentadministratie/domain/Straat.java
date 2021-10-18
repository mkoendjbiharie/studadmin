package com.adekus.studentadministratie.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Straat {
    @Id
	@GeneratedValue
    private int id;
    @Column
    private String naam;
    @OneToMany(mappedBy = "straat")
    private List<Persoon> personen;

	public int getId() {
		return id;
	}
	public void setId(int straatId) {
		this.id = straatId;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String straat) {
		this.naam = straat;
	}
	@Override
	public String toString() {
		return "Straat [straatId=" + id + ", straat=" + naam + "]";
	}

	public List<Persoon> getPersoonList() {
		return persoonList;
	}

	public void setPersoonList(List<Persoon> persoonList) {
		this.persoonList = persoonList;
	}

	@OneToMany(mappedBy = "straat")
	private List<Persoon> persoonList;

}
