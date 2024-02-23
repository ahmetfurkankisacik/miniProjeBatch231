package biletRezervasyonApp;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Ticket {
    //4-mesafa(km),koltuk no,fiyat bilgisi,yolculuk tipi

    public double distance;

    public int typeNo;

    public String seatNo;

    public double price;



    //5- bilet fiyatini hesaplama
    public void getTotalPrice(int age){
        int seat=Integer.parseInt(this.seatNo);
        double total=0;
        switch (this.typeNo){
            case 1://tek yon
                if (seat%3==0){//tekli koltuk kontrol
                   total= this.distance*1.2;
                }else {
                    total=this.distance*1;
                }
                System.out.println("toplam tutar : "+total);
                break;

            case 2://cift yon
                if (seat%3==0){
                    total=this.distance*2.4;
                }else {
                    total=this.distance*2;
                }
                System.out.println("toplam tutar : "+total);//100
                //cift yon indirimi
                total=total*0.8;//80
                System.out.println("cift yon indirimli total tutar : "+total);
                break;

        }//son tutardan yas indirimi
        if (age<13){
            total=total/2;
            System.out.println("12 yas alti indirimli total tutar : "+total);
        }else if (age>64){
            total=total*0.7;
            System.out.println("65 yas ustu indirimli total tutar : "+total);
        }
        this.price=total;
    }
    //6- bileti yazdiralim
    public void printTicket(Bus otobus){
        LocalDateTime dateTime=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("hh:mm a\ndd.MM.yy");
        System.out.println("*********************************");
        System.out.println("---Bilet Detayi---");
        System.out.println("Otobüs Plakası : "+otobus.numberPlate);
        System.out.println("Otobüs Firmasi : "+otobus.marka);
        System.out.println("Hangi peron    : "+otobus.peron);
        System.out.println("Mesafe         : "+this.distance);
        System.out.println("Yolculuk tipi  : "+(this.typeNo==1?"Tek Yön":"Gidiş-Dönüş"));
        System.out.println("Koltuk No      : "+this.seatNo);
        System.out.println("Toplam tutar   : "+this.price);
        System.out.println("Keyifli yolculuklar dileriz...........");
        System.out.println(dtf.format(dateTime));
        System.out.println("**********************************");

    }




}
