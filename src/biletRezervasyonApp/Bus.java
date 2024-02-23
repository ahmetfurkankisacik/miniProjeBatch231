package biletRezervasyonApp;

import java.util.ArrayList;
import java.util.List;

public class Bus {

    //2-plaka ve koltuk no
    public String numberPlate;//plaka
    public List<String>seats=new ArrayList<>();//koltuk no

    public Bus(String plaka){
        this.numberPlate=plaka;
        for (int i = 1; i < 33; i++) {
            this.seats.add(String.valueOf(i));
        }
    }
}
