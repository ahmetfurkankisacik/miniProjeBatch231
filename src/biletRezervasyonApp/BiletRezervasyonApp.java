package biletRezervasyonApp;

import java.util.Scanner;

public class BiletRezervasyonApp {
    /*
project: Bilet Rezervasyon ve Bilet Fiyatı Hesaplama Uygulaması

        1-Uygulama mesafe ve kurallara göre otobüs bileti fiyatı hesaplar sonuç olarak bilet bilgisini verir
        2- Kullanıcıdan     mesafe (KM),
        yolcu yaşı ,
        yolculuk tipi (Tek Yön, Gidiş-Dönüş)
        ve koltuk no bilgilerini alınır.
        NOT: Koltuk numaraları 1-32 aralığında olmalıdır.)
        Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
        Aksi halde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

        3-Fiyat hesaplama kuralları:
        -Mesafe başına ücret:
        Tek yön: 1 Lira / km       Çift Yön(Gidiş-Dönüş): 2 Lira/km
        -Tekli Koltuk ücreti:
        Koltuk no 3 veya 3 ün katı ise fiyat %20 daha fazladır(Tek yön: 1.2 Lira/km, Çift Yön:2.4 Lira/km).
        -İlk olarak seferin mesafe, yön ve koltuk no bilgisine göre fiyatı hesaplanır,
        sonrasında koşullara göre aşağıdaki indirimler uygulanır ;
        i)-Çift Yön indirimi:
        "Yolculuk Tipi" gidiş dönüş seçilmiş ise son bilet fiyatı üzerinden %20 indirim uygulanır.
        ii)-Yaş indirimi:
        Kişi 12 yaşından küçükse son bilet fiyatı üzerinden %50 indirim uygulanır.
        Kişi 65 yaşından büyük ise son bilet fiyatı üzerinden %30 indirim uygulanır.

        */
    public static void main(String[] args) {
        //1- bilet rezervasyonu yapabilmek icin bir otobuse ihtiyacimiz var
        Bus bus=new Bus("80 ab 80","Techpro","2. peron");
        //3- bilet objesi olusturalim
        Ticket ticket=new Ticket();
        //7-uygulamayi baslatan bir method
        start(bus,ticket);
    }

    private static void start(Bus bus, Ticket ticket) {
        Scanner scan=new Scanner(System.in);
        int select;//cıkıs ıcın 0 giricek
        do {
            //8- kullanıcıdan bilgileri alalım
            System.out.println("--Bilet rezervayson uygulamasina hosgeldiniz--");
            System.out.println("Lütfen yaşınızı giriniz");
            int age= scan.nextInt();


            System.out.println("Lutfen yolculuk tipini seçiniz:");
            System.out.println("1. Tek yön");
            System.out.println("2. Gidiş-Dönüş");
            int type= scan.nextInt();


            System.out.println("Lütfen gidilecek mesafe bilgisini KM olarak giriniz");
            double distance= scan.nextDouble();


            System.out.println("Lütfen koltuk no seciniz: ");
            System.out.println("Tekli koltuk ücreti %20 daha fazladır");
            System.out.println(bus.seats);//mevcut koltuk no'lari
            String seat= scan.next();
            //secilen koltuk no listede var mi,rezerve edilmiş mi
            boolean isReserved=!bus.seats.contains(seat);
            if (isReserved){
                System.out.println("secilen koltuk rezerve edilmiştir");
            }
            //girilen degerler gecerli mi?
            if (age>0&&distance>0&&(type==1||type==2)&&!isReserved) {
                //girilen degerler gecerli ise koltugu listeden silicez
                bus.seats.remove(seat);

                //bileti olusturalım
                ticket.distance = distance;
                ticket.seatNo = seat;
                ticket.typeNo = type;
                ticket.getTotalPrice(age);
                //bileti yazdiralim
                ticket.printTicket(bus);
            }else {
                System.out.println("Hatalı Veri Girdiniz !");
            }
            System.out.println("yeni islem icin bir sayi giriniz,Cıkış icin 0'i seciniz");
            select= scan.nextInt();
        }while (select!=0);
        System.out.println("iyi günler dileriz ve tekrar bekleriz <3");
    }


}
