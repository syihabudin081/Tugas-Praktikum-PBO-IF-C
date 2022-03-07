package com.company;

public class Balok  implements BangunRuang{
    private double panjang,lebar,tinggibalok;
    public Balok(double tinggibalok,double panjang,double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggibalok = tinggibalok;
    }

    @Override
    public double hitungVolume() {
        return (panjang*lebar*tinggibalok);
    }

    @Override
    public double hitungLuasPermukaan() {
        return ((2 *panjang * lebar) + (2 * lebar * tinggibalok) + (2 * panjang * tinggibalok));


    }
}
