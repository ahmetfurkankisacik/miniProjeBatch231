package restaurantBillGenerator;

import java.util.ArrayList;
import java.util.List;

//4. olarak yiyecek objeleri icin islemlerin yapıldıgı class
public class DishService {
    //5. olarak yiyecekleri listenin icinde koyalım
    private List<Dish>dishList=new ArrayList<>();


    public  DishService(){
        fillDishList();
    }

    private void fillDishList(){
        Dish dish1=new Dish(100,"ezogelin corbasi",80.5);
        Dish dish2=new Dish(101,"Urfa kebabı",150);
        Dish dish3=new Dish(102,"Adana kebabı",150);
        Dish dish4=new Dish(103,"Beyti kebabı",199.99);
        Dish dish5=new Dish(104,"Et şiş",300);
        Dish dish6=new Dish(105,"Musakka",110);
        Dish dish7=new Dish(106,"Sarma",120);
        Dish dish8=new Dish(200,"Kunefe",140.99);
        Dish dish9=new Dish(201,"Soguk baklava",210.5);
        Dish dish10=new Dish(202,"profitrol",100);
        Dish dish11=new Dish(203,"Burma kadayif",110.5);
        Dish dish12=new Dish(300,"Ayran",20.5);
        Dish dish13=new Dish(301,"Şalgam",25);
        Dish dish14=new Dish(302,"Meyveli Soda",20);
        Dish dish15=new Dish(303,"Demirhindi şerbeti",30);
        this.dishList.add(dish1);
        this.dishList.add(dish2);
        this.dishList.add(dish3);
        this.dishList.add(dish4);
        this.dishList.add(dish5);
        this.dishList.add(dish6);
        this.dishList.add(dish7);
        this.dishList.add(dish8);
        this.dishList.add(dish9);
        this.dishList.add(dish10);
        this.dishList.add(dish11);
        this.dishList.add(dish12);
        this.dishList.add(dish13);
        this.dishList.add(dish14);
        this.dishList.add(dish15);

    }
    //6. olarak menu gosterilsin
    public void showMenu(){
        System.out.println("        ******Lezzetlerimiz******        ");
        System.out.printf("%-3s     %-20s     %-6s     \n","kod","adı","fiyat");
        System.out.printf("%-3s     %-20s     %-6s     \n","***","****","**********");
        for (Dish dish:dishList
             ) {
            System.out.printf("%-3s     %-20s     %-6s     \n",dish.getCode(),dish.getName(),dish.getPrice());
        }


    }


    public Dish findDishByCode(int dishCode) {//301
        if (dishCode==0){
            System.out.println("ana menüye yonlendiriliyosunuz");
        }else {
            for (Dish dish:dishList
                 ) {
                if(dish.getCode()==dishCode){
                    return dish;
                }
            }
            System.out.println("ürün bulunamadi");
        }
        return null;
    }
}
