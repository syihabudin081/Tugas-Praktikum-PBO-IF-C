package Tugas1;

import java.util.Scanner;

public class suhu {
   static double suhuAwal;


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Suhu Dalam Celcius: ");
        double suhuCelcius = input.nextDouble();
        suhu.suhuAwal = suhuCelcius;
        konversi fromCelcius = new konversi(); //constructor
        int menu;
do{
      System.out.printf("\n1. Lihat Data Konversi : ");
      System.out.printf("\n2. Edit Data Konversi : ");
            System.out.printf("\n3. Exit ");

            System.out.println("Menu : ");
             menu = input.nextInt();
            double Reamur,Fahrenheit,Kelvin;
            String kadarAir;


            switch (menu){

                case 1 :
                    Reamur = fromCelcius.toReamur();
                    Fahrenheit = fromCelcius.toFahrenheit();
                    Kelvin = fromCelcius.toKelvin();
                    kadarAir = fromCelcius.air();

                    System.out.println("Celcius  : " + suhu.suhuAwal + " C");
                    System.out.println("Fahrenheit  : " + Fahrenheit + " F");
                    System.out.println("Reamur  : " + Reamur + " R");
                    System.out.println("Kelvin  : " + Kelvin + " K");
                    System.out.println(kadarAir);
                        break;


                case 2:
                    System.out.println("Suhu Dalam Celcius : ");
                    suhu.suhuAwal = input.nextDouble();
                    break;

                case 3:



            }



        }while(menu!=3);


    }

}
