package com.company;

public class Tabung implements BangunRuang{
    private double PI=3.14,jari,tinggitabung;
    public Tabung(double jari, double tinggitabung) {
        this.jari = jari;
        this.tinggitabung = tinggitabung;
    }

    @Override
    public double hitungLuasPermukaan() {
        return (2*PI*jari*(tinggitabung + jari));

    }

    @Override
    public double hitungVolume() {
        return (PI*jari*jari*tinggitabung);


    }
}
