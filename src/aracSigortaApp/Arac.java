package aracSigortaApp;

import java.util.Scanner;

public class Arac {
   // Tarife dönemi:Aralık 2024,Haziran 2024
   //         1.dönem :Haziran 2024               2.dönem:Aralık 2024
   // otomobil: 2000                       otomobil: 2500
   // kamyon:   3000                       kamyon:   3500
   // otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
   // motosiklet: 1500                     motosiklet: 1750

    public String type;//otobus//otomobil
    public int prim;//tarife donemine gore prim
    //5. prim hesaplama
    public void primHesapla(int donem){
        //tipine gore hesaplama
        switch (this.type){
            case"otomobil":
                this.prim=donem==1?2000:2500;
                break;
            case "kamyon":
                this.prim=donem==1?3000:3500;
                break;
            case "otobüs":
                primHesaplaOtobus(donem);
                break;
            case "motosiklet":
                this.prim=donem==1?1500:1750;
                break;
            default:
                System.out.println("Hatali giriş!");
                this.prim=0;
                break;

        }
    }

    public void primHesaplaOtobus(int donem){
        Scanner scan=new Scanner(System.in);
        System.out.println("Otobus tipini seçiniz");
        System.out.println("1. 18-30 arasi koltuk sayisi");
        System.out.println("2. 31 ve üstü koltuk sayisi");
        int otobusTipi= scan.nextInt();
        switch (otobusTipi){
            case 1:
                this.prim=donem==1?4000:4500;
                break;
            case 2:
                    this.prim=donem==1?5000:5500;
                    break;
            default:
                System.out.println("Hatali Giriş");
                this.prim=0;
                break;
        }


    }

}
