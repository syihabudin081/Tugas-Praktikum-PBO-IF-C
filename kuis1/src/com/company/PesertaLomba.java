package com.company;

import com.company.perlombaan.LombaAnimasi;
import com.company.perlombaan.LombaSurat;

public class PesertaLomba implements LombaAnimasi, LombaSurat
{
    double nilai,nilai1,nilai2,nilai3,nilai4;

    String nama,asalSekolah;

    public PesertaLomba(double nilai1, double nilai2, double nilai3, double nilai4, String nama,String asalSekolah) {
    this.nilai1 = nilai1;
    this.nilai2 = nilai2;
    this.nilai3 = nilai3;
    this.nilai4 = nilai4;
    this.nama = nama;
    this.asalSekolah = asalSekolah;
    }





    @Override
    public void hitungnilaiAnimasi() {
    nilai = nilai1*0.15 + nilai2*0.35 + nilai3*0.35 + nilai4*0.15;

    if(nilai >= 85 ){
        System.out.println("NIlai Akhir = " + nilai);
        System.out.println("Keterangan = LOLOS");
    System.out.println("Selamat Tim "+nama+" dari "+asalSekolah+" Lolos Selesi Lomba Animasi\n");
    }
    else{
        System.out.println("NIlai Akhir = " + nilai);
        System.out.println("Keterangan = GAGAl");
        System.out.println("MOhon Maaf Tim "+nama+" dari "+asalSekolah+" GAGAL Lolos Selesi Lomba Animasi\n");
    }


    }



    @Override
    public void hitungNIlaiSurat() {

        nilai = nilai1*0.1 + nilai2*0.4 + nilai3*0.3 + nilai4*0.2;

        if(nilai >= 85 ){
            System.out.println("NIlai Akhir = " + nilai);
            System.out.println("Keterangan = Lolos");
            System.out.println("Selamat Tim "+nama+" dari "+asalSekolah+" Lolos Selesi Lomba Animasi\n");
        }
        else{
            System.out.println("NIlai Akhir = " + nilai);
            System.out.println("Keterangan = GAGAl");
            System.out.println("MOhon Maaf "+nama+" dari "+asalSekolah+" GAGAL Lolos Selesi Lomba Menulis Surat\n");
        }
    }


}
