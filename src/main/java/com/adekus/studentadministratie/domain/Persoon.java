package com.adekus.studentadministratie.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*
De gegeven attributen voor klasse Persoon zijn dezelfde velden die beschikbaarbaar 
zijn op de aanmeldingsformulieren voor studenten bij de inschrijving.
Van klasse Persoon worden o.a. afgeleid klasse Student, Docent
 */

@Entity
public class Persoon {
    @Id
    @GeneratedValue
    private Long id;
    @Lob
    @Column
    private byte[] foto;
    @Column
    private String idKaartNr;
    @Column
    private String naam;
    @Column
    private String voornaam1;
    @Column
    private String voornaam2;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "geslacht_id",referencedColumnName = "id")
    private Geslacht geslacht;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "burgelijkestaat_id",referencedColumnName = "id")
    private Burgelijkestaat burgelijkestaat;
    @Column
    private String gehuwdeNaam;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "nationaliteit_id",referencedColumnName = "id")
    private Nationaliteit nationaliteit;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "geboorteland_id",referencedColumnName = "id")
    private Geboorteland geboorteland;
    @Column
    private String geboortePlaats;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    @Column
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    //@Temporal(TemporalType.DATE)
    private Date geboorteDatum;
    @Column
    private String geloof;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "vooropleidind_id",referencedColumnName = "id")
    private Vooropleiding vooropleiding;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bevolkingsgroep_id",referencedColumnName = "id")
    private Bevolkingsroep bevolkingsgroep;
    @Column
    private String woonplaats;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id",referencedColumnName = "id")
    private District district;
    @Column
    private String wijk;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "straat_id",referencedColumnName = "id")
    private Straat straat;
    @Column
    private String huisNummer;
    @Column
    private String telefoon1;
    @Column
    private String telefoon2;
    @Column
    private String telefoonWerk;
    @Column
    private String telefoonWerkExtentie;
    @Column
    private String telefoonContactPersoon;
    @Column
    private String email1;
    @Column
    private String email2;
    @Column
    private String bankRekeningNr;
    @Column
    private String bank;
    @Column
    private String hobbies;
    @OneToMany(mappedBy = "persoon")
    private List<Student> student;

    public Persoon() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdKaartNr() {
        return idKaartNr;
    }

    public void setIdKaartNr(String idKaartNr) {
        this.idKaartNr = idKaartNr;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam1() {
        return voornaam1;
    }

    public void setVoornaam1(String voornaam1) {
        this.voornaam1 = voornaam1;
    }

    public String getVoornaam2() {
        return voornaam2;
    }

    public void setVoornaam2(String voornaam2) {
        this.voornaam2 = voornaam2;
    }

    public Burgelijkestaat getBurgelijkestaat() {
        return burgelijkestaat;
    }

    public void setBurgelijkestaat(Burgelijkestaat burgelijkeStaat) {
        this.burgelijkestaat = burgelijkeStaat;
    }

    public String getGehuwdeNaam() {
        return gehuwdeNaam;
    }

    public void setGehuwdeNaam(String gehuwdeNaam) {
        this.gehuwdeNaam = gehuwdeNaam;
    }

    public Nationaliteit getNationaliteit() {
        return nationaliteit;
    }

    public void setNationaliteit(Nationaliteit nationaliteit) {
        this.nationaliteit = nationaliteit;
    }

    public Geboorteland getGeboorteland() {
        return geboorteland;
    }

    public void setGeboorteland(Geboorteland geboorteLand) {
        this.geboorteland = geboorteLand;
    }

    public String getGeboortePlaats() {
        return geboortePlaats;
    }

    public void setGeboortePlaats(String geboortePlaats) {
        this.geboortePlaats = geboortePlaats;
    }

    public Date getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(Date geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public String getGeloof() {
        return geloof;
    }

    public void setGeloof(String geloof) {
        this.geloof = geloof;
    }

    public Vooropleiding getVooropleiding() {
        return vooropleiding;
    }

    public void setVooropleiding(Vooropleiding voorOpleiding) {
        this.vooropleiding = voorOpleiding;
    }

    public Bevolkingsroep getBevolkingsgroep() {
        return bevolkingsgroep;
    }

    public void setBevolkingsgroep(Bevolkingsroep bevolkingsGroep) {
        this.bevolkingsgroep = bevolkingsGroep;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getWijk() {
        return wijk;
    }

    public void setWijk(String wijk) {
        this.wijk = wijk;
    }

    public Straat getStraat() {
        return straat;
    }

    public void setStraat(Straat straat) {
        this.straat = straat;
    }

    public String getHuisNummer() {
        return huisNummer;
    }

    public void setHuisNummer(String huisNummer) {
        this.huisNummer = huisNummer;
    }

    public String getTelefoon1() {
        return telefoon1;
    }

    public void setTelefoon1(String telefoon1) {
        this.telefoon1 = telefoon1;
    }

    public String getTelefoon2() {
        return telefoon2;
    }

    public void setTelefoon2(String telefoon2) {
        this.telefoon2 = telefoon2;
    }

    public String getTelefoonWerk() {
        return telefoonWerk;
    }

    public void setTelefoonWerk(String telefoonWerk) {
        this.telefoonWerk = telefoonWerk;
    }

    public String getTelefoonWerkExtentie() {
        return telefoonWerkExtentie;
    }

    public void setTelefoonWerkExtentie(String telefoonWerkExtentie) {
        this.telefoonWerkExtentie = telefoonWerkExtentie;
    }

    public String getTelefoonContactPersoon() {
        return telefoonContactPersoon;
    }

    public void setTelefoonContactPersoon(String telefoonContactPersoon) {
        this.telefoonContactPersoon = telefoonContactPersoon;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getBankRekeningNr() {
        return bankRekeningNr;
    }

    public void setBankRekeningNr(String bankRekeningNr) {
        this.bankRekeningNr = bankRekeningNr;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht) {
        this.geslacht = geslacht;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Persoon{" +
                "id=" + id +
                ", foto=" + Arrays.toString(foto) +
                ", idKaartNr='" + idKaartNr + '\'' +
                ", naam='" + naam + '\'' +
                ", voornaam1='" + voornaam1 + '\'' +
                ", voornaam2='" + voornaam2 + '\'' +
                ", geslacht=" + geslacht +
                ", burgelijkeStaat=" + burgelijkestaat +
                ", gehuwdeNaam='" + gehuwdeNaam + '\'' +
                ", nationaliteit=" + nationaliteit +
                ", geboorteLand=" + geboorteland +
                ", geboortePlaats='" + geboortePlaats + '\'' +
                ", geboorteDatum=" + geboorteDatum +
                ", geloof='" + geloof + '\'' +
                ", voorOpleiding='" + vooropleiding + '\'' +
                ", bevolkingsGroep=" + bevolkingsgroep +
                ", woonplaats='" + woonplaats + '\'' +
                ", district=" + district +
                ", wijk='" + wijk + '\'' +
                ", straat=" + straat +
                ", huisNummer='" + huisNummer + '\'' +
                ", telefoon1='" + telefoon1 + '\'' +
                ", telefoon2='" + telefoon2 + '\'' +
                ", telefoonWerk='" + telefoonWerk + '\'' +
                ", telefoonWerkExtentie='" + telefoonWerkExtentie + '\'' +
                ", telefoonContactPersoon='" + telefoonContactPersoon + '\'' +
                ", email1='" + email1 + '\'' +
                ", email2='" + email2 + '\'' +
                ", bankRekeningNr='" + bankRekeningNr + '\'' +
                ", bank='" + bank + '\'' +
                ", hobbies='" + hobbies + '\'' +
                '}';
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public String getNamenEnId(){
        return naam+", "+voornaam1+" - "+idKaartNr;
    }
}
