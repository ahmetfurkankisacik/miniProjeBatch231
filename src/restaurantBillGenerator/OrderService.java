package restaurantBillGenerator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//9-orderla ilgili islemler
public class OrderService {

    List<Order>orderList=new ArrayList<>();
    //10 siparis olusturma
    public void createOrder(DishService dishService){
        Scanner scan=new Scanner(System.in);
        int dishCode;
        do {
            System.out.println("lutfen urun kodunu giriniz(ÇIKIŞ için 0'i tuslayiniz)");
            dishCode=scan.nextInt();
            Dish dish=dishService.findDishByCode(dishCode);
            if(dish!=null){
                System.out.println("lutfen adet sayisini giriniz : ");
                int number= scan.nextInt();
                //bu yemek daha once siparis edildi mi?
                Order order= findOrderByCode(dish);
                if (order==null){
                    //yeni yemek siparisi
                    order=new Order(dish,number);
                    order.setOrderPrice();
                    this.orderList.add(order);
                }else {
                    //siparis ekleme
                    System.out.println("bu siparis daha once "+order.getNumberOfDish()+" kere soylenmis");
                    order.setNumberOfDish(order.getNumberOfDish()+number);
                    order.setOrderPrice();
                }


            }
            //12-siparis listesini yazdıralim
            listOrders();

        }while (dishCode!=0);
         scan.close();
    }
    public void listOrders(){
        this.orderList.forEach(order -> System.out.printf("Siparis kodu:%-5s Lezzet kodu:%-4s Lezzet Adi:%-20s Adet:%-2s tutar:%-5s\n", order.getOrderCode(),order.getDish().getCode(),order.getDish().getName(),order.getNumberOfDish(),order.getOrderPrice()));
    }

    private Order findOrderByCode(Dish dish) {
        for (Order order:orderList
             ) {
            if (order.getDish().equals(dish)){
                return order;
            }
        }
        return null;
    }

    public void deleteOrder() {
        Scanner scan=new Scanner(System.in);
        System.out.println("lutfen iptal etmek istediginiz siparisin kodunu giriniz : ");
        int code= scan.nextInt();//1001 1002
        boolean isFound=false;
        for (Order order:orderList
             ) {
            if (order.getOrderCode()==code){//kac tane iptal etmek istiyor
                System.out.println("kac tanesini iptal etmek istersiniz");
                int number= scan.nextInt();
                if (number>0&&number< order.getNumberOfDish()){
                    order.setNumberOfDish(order.getNumberOfDish()-number);
                    order.setOrderPrice();
                    System.out.println(order.getDish().getName()+" siparişinizin "+number+" adedi iptal edildi.");
                } else if (number== order.getNumberOfDish()) {
                    this.orderList.remove(order);
                    System.out.println(order.getDish().getName()+" siparişiniz iptal edildi.");

                }else {
                    System.out.println("hatali giriş!");
                }
                isFound=true;
                break;
            }
        }
        if (!isFound){
            System.out.println("İptal işlemi başarısız ,sipariş kodu gecersiz");
        }
        System.out.println("        Mevcut Siparişleriniz        ");
        listOrders();

         scan.close();
    }

    public void printBill() {
        LocalDateTime dateTime=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("hh:mm a \ndd.MM.yy");
        double total=0;
        System.out.println("         Techpro Restaurant Lezzet Fişi         ");
        listOrders();
        for (Order order:orderList
             ) {
            total+=order.getOrderPrice();
        }
        System.out.println("Toplam tutar : "+total);
        System.out.println("Afiyet olsun... yine bekleriz");
        System.out.println(dtf.format(dateTime));
        //adisyon kapatıldı yeni siparislere gecebilir
        orderList.clear();

    }
}
