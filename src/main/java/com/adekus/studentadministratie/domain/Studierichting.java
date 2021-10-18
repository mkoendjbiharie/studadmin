package com.adekus.studentadministratie.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Studierichting {
    @Id
    private String id;
    @Column
    private String naam;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "faculteit_id",referencedColumnName = "id")
    private Faculteit faculteit;
    @OneToMany(mappedBy = "studierichting")
    private List<Maxnummers> maxnummers;
    @OneToMany(mappedBy = "studierichting")
    private List<Orientatie> orientaties;
	@OneToMany(mappedBy = "studierichting")
	private List<Student> studenten;

	public String getId() {
		return id;
	}
	public void setId(String studierichtingCode) {
		this.id = studierichtingCode;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String studierichting) {
		this.naam = studierichting;
	}
	public Faculteit getFaculteit() {
		return faculteit;
	}
	/*public String getObjectFaculteit(){
		Faculteit f = new Faculteit();
		f.setId(this.getFaculteit());
		return f;
	}*/
	public void setFaculteit(Faculteit faculteit) {
		this.faculteit = faculteit;
	}
	@Override
	public String toString() {
		return "Studierichting [studierichtingCode=" + id + ", studierichting=" + naam
				+ ", faculteit=" + faculteit + "]";
	}


	public List<Student> getStudentList() {
		return studenten;
	}

	public void setStudentList(List<Student> studentList) {
		this.studenten = studentList;
	}
}
