package com.adekus.studentadministratie.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vooropleiding {
    @Id
    private String id;
    @Column
    private String naam;
    @OneToMany(mappedBy = "vooropleiding")
    private List<Persoon> persoon;

	public String getId() {
		return id;
	}
	public void setId(String vooropleidingCode) {
		this.id = vooropleidingCode;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String vooropleiding) {
		this.naam = vooropleiding;
	}
	@Override
	public String toString() {
		return "Vooropleiding [vooropleidingCode=" + id + ", vooropleiding=" + naam + "]";
	}

	@OneToMany(mappedBy = "vooropleiding")
	private List<Persoon> persoonList;

}
