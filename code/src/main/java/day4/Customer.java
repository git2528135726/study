package day4;

//接口解耦合
public class Customer {

    public static void main(String[] args) {

        FoodMenu foodMenu = new ChineseFoodMenu();
        FoodMenu foodMenu1 = new AmiercFoodMenu();

        Customer customer = new Customer();
        customer.order(foodMenu1);

    }

    public void order(FoodMenu foodMenu) {
        foodMenu.xihongsi();
        foodMenu.yangchong();
    }

}
