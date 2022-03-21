package com.company;

public class Balok extends PersegiPanjang {
    private double tinggi, hasilVolume;

    public Balok(double panjang, double lebar, double tinggi) {
        super(panjang, lebar);
        this.tinggi = tinggi;
    }

    public double hitungVolume() {
        hasilVolume = super.getHasilLuas() * tinggi;
        return hasilVolume;
    }

    public double hitungVolume(double panjang, double lebar) {
        super.setPanjang(panjang);
        super.setLebar(lebar);

        hasilVolume = super.hitungLuas() * tinggi;
        return hasilVolume;
    }
}