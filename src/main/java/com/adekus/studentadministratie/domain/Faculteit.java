package com.adekus.studentadministratie.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Faculteit {
    @Id
    private String id;
    @Column
    private String naam;
    @OneToMany(mappedBy = "faculteit")
    private List<Studierichting> studierichtingen;

	public String getId() {
		return id;
	}
	public void setId(String faculteitCode) {
		this.id = faculteitCode;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String faculteit) {
		this.naam = faculteit;
	}
	@Override
	public String toString() {
		return "Faculteit [faculteitCode=" + id + ", faculteit=" + naam + "]";
	}
}
