package com.adekus.studentadministratie.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class District {
    @Id
	@GeneratedValue
    private int id;
    @Column
    private String naam;
    @OneToMany(mappedBy = "district")
    private List<Persoon> personen;

	public int getId() {
		return id;
	}
	public void setId(int districtId) {
		this.id = districtId;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naamDistrict) {
		this.naam = naamDistrict;
	}
	@Override
	public String toString() {
		return "District [districtId=" + id + ", district=" + naam + "]";
	}
}
