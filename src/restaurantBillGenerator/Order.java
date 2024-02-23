package restaurantBillGenerator;

public class Order {
    private static int count=999;
    private int orderCode;
    private Dish dish;
    private int numberOfDish;//3
    private double orderPrice;
    //7-yemek ve yemek adedini kullanarak objemizi olusturalim
    public Order(Dish dish,int numberOfDish){
        count++;
        orderCode=count;
        this.dish=dish;
        this.numberOfDish=numberOfDish;

    }
    //8-orderPrice hesaplayalım
    public void setOrderPrice(){
        this.orderPrice=this.numberOfDish*this.dish.getPrice();
    }
    public void setNumberOfDish(int numberOfDish){
        this.numberOfDish=numberOfDish;
    }
    //getter methodlari


    public int getOrderCode() {
        return orderCode;
    }

    public Dish getDish() {
        return dish;
    }

    public int getNumberOfDish() {
        return numberOfDish;
    }

    public double getOrderPrice() {
        return orderPrice;
    }
}
