import java.util.List;

public class CreditCard implements Payment{

    private int cardNumber;
    private String cardName;
    private String cvv;
    private String expiryDate;


    //--------------------------------------------------------

    public CreditCard(){

    }

    public CreditCard(int cardNumber, String cardName, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cvv = cvv;
        this.expiryDate = expiryDate;

    }

    //--------------------------------------------------------


    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }


    public boolean checkPay(int cardNumber, String cardName){
        if (cardNumber == cardNumber && cardName.equals(cardName)){
            System.out.println("Payment completed successfully");

        }else {
            System.out.println("Sorry, Payment was not completed successfully");
        }
        return false;
    }

    @Override
    public void pay(List<Item> items , double totalPrice) {
        checkPay(cardNumber,cardName);
        for (int i = 0; i < items.size() ; i++) {
            System.out.println( (i+1) + "- Item: "+ items.get(i).getName() + " Price: " + items.get(i).getPrice());

        }
        System.out.println("- Total Price= " +  totalPrice);

    }

    //--------------------------------------------------------


    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNumber=" + cardNumber +
                ", cardName='" + cardName + '\'' +
                ", cvv='" + cvv + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                '}';
    }
}
