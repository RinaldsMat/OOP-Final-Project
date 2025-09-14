import java.io.Serializable;
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer implements Serializable
{
    // instance variables - replace the example below with your own
    private static final long serialVersionUID = 1L; // required for serialization
    private final int id; // Using final because the id should not be changed
    private String name;
    private String email;
    private double balance; //double for money!

    // Constructor
    public Customer(int id, String name, String email, double initialBalance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = initialBalance; // Initial balance set during creation
    }

    // encapsulation - using getters and setters for variables
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Methods to manage balance
    public void addMoney(double amount) {
        // Add money to customer if more than 0
        if (amount > 0) {
            balance += amount;
            System.out.println("Added €" + amount + " to balance. Current balance: €" + balance);
        } else {
            System.out.println("Invalid amount. Cannot add money.");
        }
    }
    
    // boolean to either give a true or false statement
    public boolean deductMoney(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Deducted €" + amount + " from balance. Current balance: €" + balance);
            return true;
        } else {
            System.out.println("Insufficient balance or invalid amount.");
            return false;
        }
    }

    @Override
    public String toString() { // Overriding toString for better readability
        return "Customer ID: " + id + "\nName: " + name + "\nEmail: " + email + "\nBalance: €" + balance;
    }
}
