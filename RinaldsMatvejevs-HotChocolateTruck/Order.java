import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
/**
 * Write a description of class Order here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Order implements Serializable
{
    // instance variables - replace the example below with your own
    private static final long serialVersionUID = 1L;
    private static int orderIDCounter = 1;  // Unique counter for each order
    private int orderID;
    private Customer customer;
    private List<Drinks> drinks; // List of products (drinks) in the order
    private double totalAmount;

    // Constructor to create a new order for a customer
    public Order(Customer customer) {
        this.orderID = orderIDCounter++;
        this.customer = customer;
        this.drinks = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    // Method to add a drink to the order
    public void addDrink(Drinks d) {
        drinks.add(d);
        totalAmount += d.getPrice(); // Add the price of the drink to total amount
    }

    // Method to display order details
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Drinks in Order:");
        for (Drinks drink : drinks) {
            System.out.println(" - " + drink.getName() + " (" + drink.getPrice() + ")");
        }
        System.out.println("Total Amount: $" + totalAmount);
    }

    // Getters for order ID, customer, and total amount
    public int getOrderID() {
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<Drinks> getDrinks() {
        return drinks;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderID + ", Customer: " + customer.getName() + " Drinks: "+ drinks +", Total Amount: €" + totalAmount;
    }
}
