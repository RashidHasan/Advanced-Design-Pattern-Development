import java.util.ArrayList;
import java.util.List;

    public class Tester {
    public static void main(String[] args) {


        ShoppingCart shoppingCart2 = new ShoppingCart();
        Item item1 = new Item("toy",20);
        Item item2 = new Item("toy",10);
        shoppingCart2.addItem(item1);
        shoppingCart2.addItem(item2);
        shoppingCart2.setPayment(new CreditCard(1,"Omar","1/1/2022","Nothing"));
        shoppingCart2.perPay();


        System.out.println("--------------------------------------------------");

        // Reset:
        // shoppingCart2.setPayment(new CreditCard(1,"Omar","1/1/2022","Nothing"));
        // shoppingCart2.perPay();

        System.out.println("--------------------------------------------------");
        ShoppingCart shoppingCart1 = new ShoppingCart();
        Item item3 = new Item("Pc",200);
        Item item4 = new Item("Laptop",200);
        shoppingCart1.addItem(item3);
        shoppingCart1.addItem(item4);
        shoppingCart1.setPayment(new Paypal("ra@gmail.com","123"));
        shoppingCart1.perPay();

        // Reset:
        // shoppingCart1.setPayment(new Paypal("ra@gmail.com","123"));
       // shoppingCart1.perPay();

        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");

        ShoppingCart shoppingCart3 = new ShoppingCart();
        Item item5 = new Item("Iphone 12 ",1000);
        Item item6 = new Item("Iphone 11 ",600);
        shoppingCart3.addItem(item5);
        shoppingCart3.addItem(item6);
        shoppingCart3.setPayment(new Bitcoin(12,"we@gmail.com","984"));
        shoppingCart3.perPay();




}
}
