package com.company;

public class PersegiPanjang {

    private double panjang, lebar, hasilLuas, keliling;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }

    public double getHasilLuas() {
        hitungLuas();
        return hasilLuas;
    }

    public double hitungLuas() {
        hasilLuas = panjang * lebar;
        return hasilLuas;
    }
    public double hitungKeliling() {
        keliling = 2*(panjang+lebar);
        return keliling;
    }

}
