package com.example.models;

import java.io.Serializable;

public class Staff implements Serializable {

    private Integer staff_id;
    private String ime;
    private int broj_godina;
    private String adresa;
    private double visina_dohotka;

    public Staff() {}

    public Staff(String ime, int broj_godina, String adresa, double visina_dohotka) {
        this.staff_id = null;
        this.ime = ime;
        this.broj_godina = broj_godina;
        this.adresa = adresa;
        this.visina_dohotka = visina_dohotka;
    }

    public Integer getStaff_id() {
        return staff_id;
    }
    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }

    public String getIme() {
        return ime;
    }
    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getBroj_godina() {
        return broj_godina;
    }
    public void setBroj_godina(int broj_godina) {
        this.broj_godina = broj_godina;
    }

    public String getAdresa() {
        return adresa;
    }
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public double getVisina_dohotka() {
        return visina_dohotka;
    }
    public void setVisina_dohotka(double visina_dohotka) {
        this.visina_dohotka = visina_dohotka;
    }
}