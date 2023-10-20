import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private double totalPrice;
    private List<Item> items;
    private Payment payment;

    //--------------------------------------------------------

    public ShoppingCart(){
        this.items= new ArrayList<>();
        this.totalPrice=0;
    }

    //--------------------------------------------------------

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
    this.payment=payment;

    }


    public void addItem(Item item){
        items.add(item);
        totalPrice = totalPrice + item.getPrice();


    }

    public void removeItem(Item item){
        items.remove(item);
        totalPrice-=item.getPrice();

    }

    public void perPay(){
        payment.pay( items,totalPrice);
        totalPrice=0 ;
        items.clear();
    }




    //--------------------------------------------------------


    @Override
    public String toString() {
        return "ShoppingCart{" +
                "totalPrice=" + totalPrice +
                ", items=" + items +
                ", payment=" + payment +
                '}';
    }
}
