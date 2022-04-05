package com.company;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        int menu2;
        String nama,asalSekolah;
        Scanner input = new Scanner(System.in).useDelimiter("\n");
       System.out.println("Terdapat Dua Jenis lomba\n 1.Animasi\n 2.Menulis Surat");
        System.out.println("Menu : ");
        int menu = input.nextInt();
        System.out.println("Input Nama : ");
        nama = input.next();
        System.out.println("Asal Sekolah : ");
        asalSekolah = input.next();

        if(menu==1) {
            double alur,konten,kreativitas,sinematografi;
            do {
                System.out.println("Nilai Alur Cerita : ");
                alur = input.nextDouble();
            } while (alur < 0 || alur > 100);

            do{
                System.out.println("Nilai Konten : ");
                konten = input.nextDouble();
            }while (konten < 0 || konten > 100);

            do{
                System.out.println("Nilai Kreativitas : ");
               kreativitas = input.nextDouble();
            }while (kreativitas < 0 || kreativitas > 100);

            do{
                System.out.println("Nilai Sinematografi : ");
               sinematografi = input.nextDouble();
            }while (sinematografi < 0 || sinematografi > 100);



            do {
                System.out.println("MENU++\n1.Tampil\n2.Edit\n3.Exit ");
                menu2 = input.nextInt();
                if (menu2 == 1) {
                    PesertaLomba pl = new PesertaLomba(alur, konten, kreativitas, sinematografi, nama, asalSekolah);
                    pl.hitungnilaiAnimasi();
                }
                if (menu2 == 2) {
                    do {
                        System.out.println("Nilai Alur Cerita : ");
                        alur = input.nextDouble();
                    } while (alur < 0 || alur > 100);

                    do{
                        System.out.println("Nilai Konten : ");
                        konten = input.nextDouble();
                    }while (konten < 0 || konten > 100);

                    do{
                        System.out.println("Nilai Kreativitas : ");
                        kreativitas = input.nextDouble();
                    }while (kreativitas < 0 || kreativitas > 100);

                    do{
                        System.out.println("Nilai Sinematografi : ");
                        sinematografi = input.nextDouble();
                    }while (sinematografi < 0 || sinematografi > 100);
                    PesertaLomba pl = new PesertaLomba(alur, konten, kreativitas, sinematografi, nama, asalSekolah);
                }



            } while (menu2 != 3);

        }

        if(menu==2){
            double struktur,isi,kreativitas,kaidah;

            do {
                System.out.println("Nilai Stuktur Surat : ");
                struktur = input.nextDouble();
            } while (struktur < 0 || struktur > 100);

            do{
                System.out.println("Nilai Isi Surat: ");
                isi = input.nextDouble();
            }while (isi < 0 || isi > 100);

            do{
                System.out.println("Nilai Kreativitas : ");
                kreativitas = input.nextDouble();
            }while (kreativitas < 0 || kreativitas > 100);

            do{
                System.out.println("Nilai Penerapan Kaidah Bahasa : ");
                kaidah = input.nextDouble();
            }while (kaidah < 0 || kaidah > 100);




            do{
                System.out.println("MENU++\n1.Tampil\n2.Edit\n3.Exit ");
                 menu2 = input.nextInt();

                if (menu2 == 1) {
                    PesertaLomba pl2 = new PesertaLomba(struktur, isi, kreativitas, kaidah, nama, asalSekolah);
                    pl2.hitungNIlaiSurat();

                }
                if (menu2 == 2) {
                    do {
                        System.out.println("Nilai Stuktur Surat : ");
                        struktur = input.nextDouble();
                    } while (struktur < 0 || struktur > 100);

                    do{
                        System.out.println("Nilai Isi Surat: ");
                        isi = input.nextDouble();
                    }while (isi < 0 || isi > 100);

                    do{
                        System.out.println("Nilai Kreativitas : ");
                        kreativitas = input.nextDouble();
                    }while (kreativitas < 0 || kreativitas > 100);

                    do{
                        System.out.println("Nilai Penerapan Kaidah Bahasa : ");
                        kaidah = input.nextDouble();
                    }while (kaidah < 0 || kaidah > 100);
                }

            }while (menu2!=3 );

        }






    }



}
