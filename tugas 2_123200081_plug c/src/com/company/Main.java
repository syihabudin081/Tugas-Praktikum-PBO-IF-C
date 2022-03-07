package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double menu,panjang,lebar,tinggibalok,jari,tinggitabung;
        Scanner input = new Scanner(System.in);
        System.out.println("Menu\n");
        System.out.println("Menu 1 (persegi panjang dan balok)\n");
        System.out.println("Menu 2 (lingkaran dan tabung\n");


         do{
             System.out.println("pilih Menu : ");
             menu = input.nextInt();
        if(menu ==1){
            System.out.println("panjang : ");
            panjang = input.nextDouble();
            System.out.println("lebar: ");
            lebar = input.nextDouble();
            System.out.println("tinggi balok : ");
            tinggibalok = input.nextDouble();

            PersegiPanjang pp = new PersegiPanjang(panjang,lebar);
            Balok bb = new Balok(tinggibalok,panjang,lebar);
            System.out.println("keliling persegi panjang : " + pp.hitungKeliling());
            System.out.println("luas persegi panjang : " + pp.hitungLuas());
            System.out.println("volume balok : " + bb.hitungVolume());
            System.out.println("luas permukaan balok : " + bb.hitungLuasPermukaan());

        }else if(menu ==2 ){
            System.out.println("jari2 : ");
            jari = input.nextInt();
            System.out.println("tinggi : ");
            tinggitabung = input.nextInt();
            lingkaran ll = new lingkaran(jari);
            Tabung tb = new Tabung(jari,tinggitabung);
            System.out.println("keliling lingkaran : " + ll.hitungKeliling());
            System.out.println("luas lingkaran : " + ll.hitungLuas());
            System.out.println("volume tabung : " + tb.hitungVolume());
            System.out.println("luas permukaan tabung: " + tb.hitungLuasPermukaan());


        }
             } while(menu != 3);
    }





}
