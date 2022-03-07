package com.company;

public class lingkaran implements BangunDatar {
private final double jari,PI = 3.14;
    public lingkaran(double jari) {
        this.jari = jari;

    }

    @Override
    public double hitungKeliling() {
        return (2*PI*jari);
    }

    @Override
    public double hitungLuas() {
        return (PI*jari*jari);
    }

}
