package Tugas1;

public class konversi {

    double toFahrenheit(){

        //°F = °C × 1,8 + 32
        return (suhu.suhuAwal*1.8+32);
    }
    double toReamur(){
        //°Ré = °C × 0,8
        return (suhu.suhuAwal*0.8);
    }

    double toKelvin(){
        //K = °C + 273,15
        return (suhu.suhuAwal+273.15);
    }

    String air(){
         if(suhu.suhuAwal < 0){
            return ("Suhu Air Beku ");
        }else if(suhu.suhuAwal >100){
            return("Suhu Air Mendidih ");
        }else{ return("Suhu Air Normal ");}


    }
}
