import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//import java.io.ObjectOutputStream;
//import java.io.FileOutputStream;
import java.io.*; // required for objectoutput & fileoutput Streams
// using java.io instead of several lines of imports for compatability

/**
 * Write a description of class HCTimplement here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HCTimplement implements HCTInterface
{
    // instance variables - replace the example below with your own
    private int customerIDCounter = 1; // Counter for customer ID
    private int drinkIDCounter = 1;// Counter for drink Id
    
    private static final String DATABASE_FILE = "HCTdata.ser"; // uses created HCTdata.ser
    // to store the created drinks, customers, orders
    private Map<Integer, Customer> customers = new HashMap<>(); // Stores customers
    private Map<Integer, Drinks> drinks = new HashMap<>(); // stores drinks
    private List<Order> orders = new ArrayList<>(); // stores orders

    private Scanner scanner = new Scanner(System.in); // Get input again

    // Override is being used to change the functions being inherited
    @Override
    public void addCustomer() {
        // Request information from the user to create the customer
        System.out.println("Adding a customer...");
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine(); // Saving each input -
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine();
        // - to then input them into the constructor!
        Customer customer = new Customer(customerIDCounter++, name, email, initialBalance);
        customers.put(customer.getId(), customer);
        System.out.println("Customer added: " + customer);
    }

    @Override
    public void removeCustomer() {
        System.out.print("Enter the ID of the customer to remove: ");
        int remove = scanner.nextInt(); // Save id to use it for removal
        scanner.nextLine();
        
        // If the int points out a valid customer
        if (customers.remove(remove) != null) {
            System.out.println("Customer removed.");
        } else { // Inform user that the id was not found/valid
            System.out.println("Customer ID not found.");
        }
    }

    @Override
    public void displayCustomerInfo() {
        System.out.print("Enter the ID of the customer to display: ");
        int display = scanner.nextInt();
        scanner.nextLine();
        
        // The above saves the customer id given by the user and passes it 
        // to the if statement to repeat the process of verify if the id is real 
        Customer customer = customers.get(display); // find the customer using the int
        if (customer != null) {
            // Display if the customer exists
            System.out.println(customer);
        } else {
            // Otherwise display error message instead
            System.out.println("Customer ID not found.");
        }
    }

    @Override
    public void displayAllCustomerIDs() {
        System.out.println("All Customer IDs:"); //show all IDs
        for (Integer id : customers.keySet()) { // This allows for displaying all the unique IDs
            Customer customer = customers.get(id); // get the customer so then it can also get their name
            System.out.println("Customer ID: " + id + "Customer Name: " + customer.getName());
            // Print out customer id and name as requested
        }
    }

    
    
    @Override
    public void addKitkatChocolate() {
        System.out.println("New Kitkat Chocolate");
        System.out.print("Do you want it chunky? true/false: ");
        // Save boolean to pass into the chunky field for kitkat
        boolean chunky = scanner.nextBoolean();
        Drinks kitkat = new KitkatChocolate(drinkIDCounter++, "Kitkat", 1.79, chunky);
        // Gives the new kitkat an ID, default name and price along with chunky boolean
        drinks.put(kitkat.getId(), kitkat); // enters it into the hashmap
        System.out.println("Drink added: " + kitkat); //Lets the user know
    }

    @Override
    public void addCadburyChocolate() {
        System.out.println("New Cadbury Chocolate");
        System.out.print("How many smarties?: "); //gets amount of smarties
        int smarties = scanner.nextInt();
        Drinks cadbury = new CadburyChocolate(drinkIDCounter++, "Cadbury", 1.99, smarties);
        // Same general passed in ID, price and smarties
        drinks.put(cadbury.getId(), cadbury);
        // Inserts it into the drinks hashmap
        System.out.println("Drink added: " + cadbury); // Lets user know again
    }

    @Override
    public void removeProduct() {
        System.out.print("Enter the ID of the drink to remove: ");
        int removeDrink = scanner.nextInt();
        scanner.nextLine();
        
        // Takes id of drink and verifys its existence to then remove it from hashmap
        if (drinks.remove(removeDrink) != null) {
            System.out.println("Drink removed.");
        } else {
            System.out.println("Drink ID not found.");
        }
    }

    @Override
    public void displayProductInfo() {
        System.out.print("Enter the ID of the drink to display: ");
        int displayDrink = scanner.nextInt();
        scanner.nextLine(); 
        
        // This uses the same method as display customer info by saving the int of
        // the ID and verifying if it exists or not by an if statement
        Drinks drink = drinks.get(displayDrink);
        if (drink != null) {
            System.out.println(displayDrink);
        } else {
            System.out.println("Drink ID not found.");
        }
    }

    @Override
    public void displayAllProductIDs() {
        System.out.println("All Drink IDs:");
        for (Integer id : drinks.keySet()) {
            System.out.println("Drink ID: " + id);
            // Show all drink ID by printing the information from each unique id
        }
    }

    
    
    @Override
    public void createOrder() {
        System.out.print("Enter Customer ID for the order: ");
        int customerId = scanner.nextInt(); // ensure an INT is being passed in
        scanner.nextLine();

        Customer customer = customers.get(customerId);
        // Gets customer by id and assigns the customer to a new order
        if (customer != null) {
            Order order = new Order(customer);
            orders.add(order); // Saves the new order
            System.out.println("Order created for customer: " + customer.getName());
            // Prints a message confirming creation of the order
        } else {
            System.out.println("Customer ID not found.");
        }
    }

    @Override
    public void addProductToOrder() {
        System.out.print("Enter Order ID to add a drink to: ");
        int orderId = scanner.nextInt();
        System.out.print("Enter Drink ID to add: ");
        int drinkId = scanner.nextInt();
        scanner.nextLine();
        // Add a drink to an order by getting the id of both
        
        
        // Verifying if the order number exists before inputting drink
        if (orderId < 1 || orderId > orders.size()) {
            System.out.println("Invalid Order ID.");
            return;
        }

        Order order = orders.get(orderId - 1); //adjusting size for order array
        Drinks drink = drinks.get(drinkId);
        
        // after confirming the order and drink exists it inserts it into the order
        if (drink != null) {
            order.addDrink(drink);
            System.out.println("Added " + drink.getName() + " to Order ID " + orderId);
        } else {
            System.out.println("Drink ID not found.");
            // provides an error message
        }
    }

    @Override
    public void displayOrderDetails() {
        System.out.print("Enter Order ID to display: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); 
        
        // if the id is above or below 1 - amount of orders
        if (orderId < 1 || orderId > orders.size()) {
            System.out.println("Invalid Order ID.");
            // give error
            return;
        }
        
        // else print it as toString
        Order order = orders.get(orderId - 1);
        System.out.println(order);
    }

    @Override
    public void displayAllOrders() {
        System.out.println("All Orders:");
        for (Order order : orders) {
            System.out.println(order);
            //print the toString details for all orders in the array
        }
    }

    
    
    
    @Override
    public void saveDatabase() {
        System.out.println("Saving to database");
        
        // try saving the data as an objectOutputStream to then save in the .ser file
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATABASE_FILE))) {
            // Write all objects (customers, drinks, and orders) to the file
            out.writeObject(customers);
            out.writeObject(drinks);
            out.writeObject(orders);
            System.out.println("Database saved successfully.");
        } catch (IOException e) {
            // io exception along with the message from console saying why
            System.out.println("Error saving database: " + e.getMessage());
        }
    }

    @Override
    public void loadDatabase() {
        System.out.println("Loading the database");
        
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATABASE_FILE))) {
            // Read all objects (customers, drinks, and orders) from the file
            customers = (Map<Integer, Customer>) in.readObject();
            drinks = (Map<Integer, Drinks>) in.readObject();
            orders = (List<Order>) in.readObject();
            System.out.println("Database loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading database: " + e.getMessage());
        }
    }
    
    
    
    
    // extra functionaltiy
    
    
    @Override
    public void addMoneyToCustomer() {
        // Ask for the customer ID
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        
        // Get the customer from the map
        Customer customer = customers.get(customerId);
        
        if (customer != null) {
            // Ask for the amount to add
            System.out.print("Enter amount to add: €");
            double amount = scanner.nextDouble();
            
            // Add money to the customer's balance
            customer.addMoney(amount);
            System.out.println("Added €" + amount + " to " + customer.getName() + " balance.");
        } else {
            System.out.println("Customer not found!");
        }
    }

    @Override
    public void removeMoneyFromCustomer() {
        // Ask for the customer ID
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        
        // Get the customer from the map
        Customer customer = customers.get(customerId);
        
        if (customer != null) {
            // Ask for the amount to remove
            System.out.print("Enter amount to deduct: €");
            double amount = scanner.nextDouble();
            
            // Attempt to deduct money from the customer's balance
            if (customer.deductMoney(amount)) {
                System.out.println("Deducted €" + amount + " from " + customer.getName() + " balance.");
            } else {
                System.out.println("Insufficient money.");
            }
        } else {
            System.out.println("Customer not found!");
        }
    }
}