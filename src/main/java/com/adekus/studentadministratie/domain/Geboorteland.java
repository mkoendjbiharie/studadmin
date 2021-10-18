package com.adekus.studentadministratie.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Geboorteland {
    @Id
	@GeneratedValue
    private int id;
    @Column
    private String naam;
    @OneToMany(mappedBy = "geboorteland")
    private List<Persoon> personen;

	public int getId() {
		return id;
	}
	public void setId(int geboorteLandId) {
		this.id = geboorteLandId;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String geboorteLand) {
		this.naam = geboorteLand;
	}
	@Override
	public String toString() {
		return "GeboorteLand [geboorteLandId=" + id + ", geboorteLand=" + naam + "]";
	}
}
