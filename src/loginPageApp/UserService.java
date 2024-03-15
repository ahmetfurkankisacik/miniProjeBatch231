package loginPageApp;


import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class UserService {

    Scanner scan=new Scanner(System.in);
    List<String>emails=new ArrayList<>();

    List<String>passwords=new ArrayList<>();
    //3- ad soyad,email,sifre alıp listeye kaydedelim;
    public void register(){
        System.out.println("lutfen ad-soyad giriniz");
        String name= scan.nextLine();
        //4- email gecersizse tekrar girmeli
        String email;
        boolean isValid;
        do {
            System.out.println("lutfen email adresinizi giriniz");
            email=scan.nextLine();
            isValid=validateEmail(email);
            if (emails.contains(email)){
                System.out.println("bu email zaten kayıtlı lütfen başka bir email adresi deneyiniz");
            isValid=false;
            }

        }while (!isValid);
        //5 password olusturalim
         String password;
           boolean isValidPassword;
           do {
            System.out.println("lutfen sifrenizi olusturunuz : ");
            password= scan.nextLine();
            isValidPassword=validatePassword(password);
        }while (!isValidPassword);
        //6 user olusturmak
        User user=new User(name,email,password);
        emails.add(user.getEmail());
        passwords.add(user.getPassword());
        System.out.println("Tebrikler, kayıt işlemi başarıyla gerçeklesti");
        System.out.println("Email ve şifreniz ile sisteme giriş yapabilirsiniz");
    }



    public void login(){

        System.out.println("lutfen giriş yapmak için email adresinizi giriniz");
        String email= scan.nextLine();
        //girilen email listede var mi?
        boolean isExistEmail=emails.contains(email);
        if (isExistEmail){
            //kullanıcının kaydi vardır sifreyi kontrol edelim
            int sayac=3;
            while (sayac>0){
                System.out.println("sifrenizi giriniz : ");
                String  passw= scan.nextLine();
                //sifre ile email ayni indexte mi?
                int index=emails.indexOf(email);
                if (passwords.get(index).equals(passw)){//alican123==alican123
                    System.out.println("sisteme basarili bir sekilde giris yaptiniz. Hosgeldiniz");
                    break;
                }else {
                    sayac--;
                    System.out.println("sifrenizi yanlis ya da eksik girdiniz lutfen tekrar deneyiniz kalan deneme hakkınız : "+sayac);

                }
            }
        }else {//kullanicin kaydı yoktur tekrar denemesini soyleylim
            System.out.println("sisteme kayıtlı bir kullanıcı bulunamadı.");
            System.out.println("üyeyseniz bilgilerinizi kontrol edeniz, değilseniz üye olunuz!!");

        }

    }
      private boolean validatePassword(String password) {
        boolean isValid;
        boolean space=password.contains(" ");
        boolean lenght=password.length()>5;
          boolean kucukHarf = password.replaceAll("[^a-z]", "").length() > 0;
          boolean buyukHarf=password.replaceAll("[^A-Z]","").length()>0;
          boolean rakam=password.replaceAll("[^0-9]","").length()>0;
          boolean sembol=password.replaceAll("[\\P{Punct}]","").length()>0;
          if (space){
              System.out.println("password boşluk karakteri içeremez");
          }if (!lenght){
              System.out.println("şifre en az 6 karakter uzunluğunda olmak zorundadir");
          }if (!kucukHarf) {
              System.out.println("şifre en az 1 tane küçük harf içermek zorundadir");
          }if (!buyukHarf){
              System.out.println("şifre en az 1 tane büyük harf içermek zorundadir");
          }if (!rakam){
              System.out.println("şifre en az 1 tane rakam içermek zorundadir");
          }if (!sembol){
              System.out.println("şifre en az 1 tane sembol içermek zorundadir");
          }
          isValid=!space&&lenght&&kucukHarf&&buyukHarf&&rakam&&sembol;
          if (!isValid){
              System.out.println("geçersiz şifre, tekrar deneyiniz");
          }
          return isValid;


      }

















    private boolean validateEmail(String email) {

    boolean isValid;
    boolean space=email.contains(" ");
    boolean containsAt=email.contains("@");
    if (space){
        System.out.println("Email bosluk iceremez");
        isValid=false;
    }else if (!containsAt){
        System.out.println("Email @ sembolünü icermeli");
        isValid=false;
    }else {//xyz!?*@@123
        String firstPart=email.split("@")[0];//xyz!?*
        String secondPart=email.split("@")[1];//@123
        //büyük-küçük harf,rakam yada -._ disinda karakter var mı?
        int notValidCharLength=firstPart.replaceAll("[a-zA-Z0-9-._]","").length();
        boolean checkFirst=notValidCharLength==0;
        boolean checkSecond=secondPart.equals("gmail.com")||
                secondPart.equals("hotmail.com")||
                secondPart.equals("yahoo.com");
        if (!checkFirst){
            System.out.println("Email harf,rakam ved -._ ışında karakter iceremez");
        }else if (!checkSecond){
            System.out.println("Email gmail.com,hotmail.com veya yahoo.com ile bitmelidir!");
        }
        isValid=checkFirst&&checkSecond;
        if (!isValid){
            System.out.println("Gecersiz email,Tekrar deneyiniz");
        }
    }
        return isValid;
    }
}
