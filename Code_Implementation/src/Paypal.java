import java.util.List;

public class Paypal implements Payment{

    private static String email;
    private static String password;


    //--------------------------------------------------------


    public Paypal(){


    }

    public Paypal(String email, String password) {
        this.email = email;
        this.password = password;
    }

    //--------------------------------------------------------


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



        public boolean checkPay(String email, String password){
        if (email.equals(email)&&password.equals(password)){
            System.out.println("Payment completed successfully");

        }else {
            System.out.println("Sorry, Payment was not completed successfully");
        }
        return false;
            }

      @Override
         public void pay(List<Item> items , double totalPrice) {

            checkPay(email,password);
            for (int i = 0; i < items.size() ; i++) {
                System.out.println( (i+1) + "- Item: "+ items.get(i).getName() + ", Price: " + items.get(i).getPrice());

            }
            System.out.println("- Total Price= " +  totalPrice);
                 }


    //--------------------------------------------------------


    @Override
    public String toString() {
        return "Paypal{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
