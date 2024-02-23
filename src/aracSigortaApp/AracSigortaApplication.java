package aracSigortaApp;

import java.util.Scanner;

public class AracSigortaApplication {
/*
Proje: Araç Sigorta Prim Hesaplama
       Araç tipleri:otomobil, kamyon, otobüs, motosiklet
                    -otobüs: 18-30 koltuk veya 31 ve üstü koltuk

       Tarife dönemi:Aralık 2024,Haziran 2024
          1.dönem :Haziran 2024               2.dönem:Aralık 2024
          otomobil: 2000                       otomobil: 2500
          kamyon:   3000                       kamyon:   3500
          otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
          motosiklet: 1500                     motosiklet: 1750

        1-Tekrar tekrar kullanılan bir seçim menüsü(form) gösterelim.//while-switch
        2-Tarife dönemi bilgisi,araç tipi bilgilerini kullanıcıdan alalım.
        3-Hatalı girişte hesaplama başarısız uyarısı verip tekrar menü(form) gösterilsin.
        4-Menüde yeni işlem veya çıkış için seçenek sunulsun .
        5-tarife dönemi ve araç tipine göre sigorta primi hesaplansın.
 */

    public static void main(String[] args) {
    //1. uygulmayi baslatan bir method
        start();
    }

    public static void start() {
        //2. kullanıcıdan bilgi alma
        Scanner input=new Scanner(System.in);
        boolean isAgain;
        //3. tekrar tekrar menü gosterilsin
        do {
            System.out.println("--Zorunlu Araç Sigorta Primi Hesaplama--");
            System.out.println("Tarife Donemi Seciniz");
            System.out.println("1. Haziran 2024");
            System.out.println("2. Aralık 2024");
            int donem= input.nextInt();
            //String str=input.nextLine();//dummpy
            String donemBilgi=donem==1?"Haziran 2024":"Aralık 2024";
            //tarife donemi dogru girilirse isleme devam et hatali ise uyari verip tekrar forma gonderme islemi yap
            if (donem==1||donem==2){
                //4. bir arac objesi olusturalim
                Arac arac=new Arac();//default
                System.out.println("Arac tipini seciniz: ");
                System.out.println("otomobil, kamyon, motosiklet, otobüs");//OTOMOBIL
                arac.type=input.next().toLowerCase();
                arac.primHesapla(donem);
                //prim=0 ise hatali giris yapmış yeni işlem yapsın
                //prim>0 ise hesaplama islemi basarili bir sekilde yapilmistir sonucu gosterelim
                if (arac.prim>0){
                    System.out.println("--------------------------------");
                    System.out.println("Arac tipi : "+arac.type);
                    System.out.println("Tarife donemi : "+donemBilgi);
                    System.out.println("Aracinizin ilgili donem sigorta primi : "+arac.prim);
                    System.out.println("--------------------------------");
                    System.out.println("yeni islem icin 1, cıkıs icin 0'ı seciniz");
                    int select=input.nextInt();
                    isAgain=select==1?true:false;

                }else {
                    System.out.println("Hesaplama islemi basarisiz, tekrar deneyiniz");
                    System.out.println("yeni islem icin 1, cıkış icin 0'ı seciniz");
                    int select=input.nextInt();
                    isAgain=select==1?true:false;
                }




            }else {//hatali giriste
                System.out.println("Hatali giriş!!!");
                isAgain=true;
            }
        }while (isAgain);

    }

}
