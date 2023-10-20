import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartGUI extends JFrame {

    private ShoppingCart shoppingCart;
    private JTextArea cartTextArea;
    private JComboBox<String> paymentMethodComboBox;
    private JButton addItemButton;
    private JButton removeItemButton;
    private JButton checkoutButton;

    public ShoppingCartGUI() {
        shoppingCart = new ShoppingCart();

        setTitle("Shopping Cart GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        cartTextArea = new JTextArea(10, 40);
        cartTextArea.setEditable(false);

        paymentMethodComboBox = new JComboBox<>(new String[]{"Paypal", "Bitcoin", "Credit Card"});

        addItemButton = new JButton("Add Item");
        removeItemButton = new JButton("Remove Item");
        checkoutButton = new JButton("Checkout");

        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = JOptionPane.showInputDialog("Enter item name:");
                double itemPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter item price:"));

                Item newItem = new Item(itemName, itemPrice);
                shoppingCart.addItem(newItem);
                updateCartTextArea();
            }
        });

        removeItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = JOptionPane.showConfirmDialog(null, "Select an item to remove:", "Remove Item", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

                if (selectedIndex == JOptionPane.OK_OPTION) {
                    shoppingCart.removeItem(shoppingCart.getItems().get(selectedIndex));
                    updateCartTextArea();
                }
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPaymentMethod = (String) paymentMethodComboBox.getSelectedItem();
                Payment payment = null;

                if (selectedPaymentMethod.equals("Paypal")) {
                    String email = JOptionPane.showInputDialog("Enter Paypal email:");
                    String password = JOptionPane.showInputDialog("Enter Paypal password:");
                    payment = new Paypal(email, password);
                    JOptionPane.showMessageDialog(null, "Invalid age format. Please enter a valid number.", "Error occurred", JOptionPane.INFORMATION_MESSAGE);

                } else if (selectedPaymentMethod.equals("Bitcoin")) {
                    int walletId = Integer.parseInt(JOptionPane.showInputDialog("Enter Bitcoin wallet ID:"));
                    String email = JOptionPane.showInputDialog("Enter Bitcoin email:");
                    String password = JOptionPane.showInputDialog("Enter Bitcoin password:");
                    payment = new Bitcoin(walletId, email, password);
                } else if (selectedPaymentMethod.equals("Credit Card")) {
                    int cardNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter card number:"));
                    String cardName = JOptionPane.showInputDialog("Enter card name:");
                    String cvv = JOptionPane.showInputDialog("Enter CVV:");
                    String expiryDate = JOptionPane.showInputDialog("Enter expiry date:");
                    payment = new CreditCard(cardNumber, cardName, cvv, expiryDate);
                }

                if (payment != null) {
                    shoppingCart.setPayment(payment);
                    shoppingCart.perPay();
                    updateCartTextArea();
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addItemButton);
        buttonPanel.add(removeItemButton);
        buttonPanel.add(paymentMethodComboBox);
        buttonPanel.add(checkoutButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(cartTextArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void updateCartTextArea() {
        List<Item> items = shoppingCart.getItems();
        StringBuilder sb = new StringBuilder();

        for (Item item : items) {
            sb.append("Item: ").append(item.getName()).append(", Price: ").append(item.getPrice()).append("\n");
        }
        sb.append("Total Price: ").append(shoppingCart.getTotalPrice());

        cartTextArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShoppingCartGUI().setVisible(true);
            }
        });
    }
}
