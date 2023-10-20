import java.util.List;

public class Bitcoin implements Payment{

    private int walletId;
    private String BitcoinEmail;
    private String BitcoinPassword;


    //--------------------------------------------------------


    public Bitcoin(int walletId, String bitcoinEmail, String bitcoinPassword) {
        this.walletId = walletId;
        BitcoinEmail = bitcoinEmail;
        BitcoinPassword = bitcoinPassword;

    }

    //--------------------------------------------------------


    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public String getBitcoinEmail() {
        return BitcoinEmail;
    }

    public void setBitcoinEmail(String bitcoinEmail) {
        BitcoinEmail = bitcoinEmail;
    }

    public String getBitcoinPassword() {
        return BitcoinPassword;
    }

    public void setBitcoinPassword(String bitcoinPassword) {
        BitcoinPassword = bitcoinPassword;
    }

    public boolean checkPay(String bitcoinEmail, String bitcoinPassword){
        if (bitcoinEmail.equals(bitcoinEmail)&& bitcoinPassword.equals(bitcoinPassword)){
            System.out.println("Payment completed successfully");

        }else {
            System.out.println("Sorry, Payment was not completed successfully");
        }
        return false;
    }

    @Override
    public void pay(List<Item> items , double totalPrice) {
        checkPay(getBitcoinEmail(),getBitcoinPassword());
        for (int i = 0; i < items.size() ; i++) {
            System.out.println( (i+1) + "- Item: "+ items.get(i).getName() + "Price: " + items.get(i).getPrice());

        }
        System.out.println("- Total Price= " +  totalPrice);
    }

    //--------------------------------------------------------


    @Override
    public String toString() {
        return "Bitcoin{" +
                "walletId=" + walletId +
                ", BitcoinEmail='" + BitcoinEmail + '\'' +
                ", BitcoinPassword='" + BitcoinPassword + '\'' +
                '}';
    }
}
