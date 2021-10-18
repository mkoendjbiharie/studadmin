package com.adekus.studentadministratie.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Bevolkingsroep {
    @Id
	@GeneratedValue
    private int id;
    @Column
    private String naam;
    @OneToMany(mappedBy = "bevolkingsgroep")
    private List<Persoon> personen;

	public int getId() {
		return id;
	}
	public void setId(int bevolkingsgroepId) {
		this.id = bevolkingsgroepId;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String bevolkingsGroep) {
		this.naam = bevolkingsGroep;
	}
	@Override
	public String toString() {
		return "BevolkingsGroep [bevolkingsgroepId=" + id + ", bevolkingsGroep=" + naam + "]";
	}
    
}
