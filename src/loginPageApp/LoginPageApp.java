package loginPageApp;

import java.util.Scanner;

public class LoginPageApp {
    /*

        Project: Bir siteye üye olma ve giriş yapma sayfası tasarlayınız.

        menü: kullanıcıya işlem seçimi için menü gösterilir.//switch+do while

        üye olma(register): kullanıcıdan ad-soyad, email ve şifre bilgileri alınız.
        email ve şifre birer listede tutulur.
        aynı email kabul edilmez.//unique

        giriş(login): email ve şifre girilir.
        email bulunamazsa kayıtlı değil, üye olun uyarısı verilir.
        email ile aynı indekste kayıtlı şifre doğrulanırsa siteye giriş yapılır.

        email validation: boşluk içermemeli
        : @ içermeli
                         : gmail.com,hotmail.com veya yahoo.com ile bitmeli.
                                 : mailin kullanıcı adı kısmında(@ den önce) sadece büyük-küçük harf,rakam yada -._ sembolleri olabilir.

        password validation: boşluk içermemeli
        : en az 6 karakter olmalı
        : en az bir tane küçük harf içermeli
        : en az bir tane büyük harf içermeli
        : en az bir tane rakam içermeli
        : en az bir tane sembol içermeli
        */
    public static void main(String[] args) {
        //1- tum userlarin ozelliklerini bir class'a tasıyalım
        //2- userla ilgili islemleri yapmak icin bir userService classi olusturalim
        //UserService service=new UserService();// denemek icin olusturduk normalde burada bunun işi yok!!
        //service.register();
        start();

    }

    private static void start() {
        Scanner scanner=new Scanner(System.in);
        //user service'ten bir service objesi olusturalim
        UserService service=new UserService();
        //1-uye ol
        int select;
        do {
            System.out.println("*******TECHPROEDUCATION*******");
            System.out.println("1-üye ol");
            System.out.println("2-giriş yap");
            System.out.println("0-çıkış");
            select= scanner.nextInt();
            switch (select){
                case 1: service.register();
                    break;
                case 2:
                    service.login();
                    break;
                case 0:
                    System.out.println("iyi günler dileriz...");
                    break;
                default:
                    System.out.println("hatalı giriş yaptiniz tekrar deneyiniz");
                    break;
            }

        }while (select!=0);

    }


}
