import java.util.Scanner;
/**
 * HCTInterface just creates the skeleton for the menu and will be used
 * by another class to implement its functionaliyt.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface HCTInterface
{
    // Display menu options
    // Template used from examples for ease of use
    static void printMenu() {
        System.out.print("-----------------------------------\n");
        System.out.print("           HOT CHOCOLATE TRUCK MENU\n");
        System.out.print("-----------------------------------\n");
        System.out.print(" 0. Exit\n");
        System.out.print(" 1. Add Customer\n");
        System.out.print(" 2. Remove Customer\n");
        System.out.print(" 3. Display Customer Info\n");
        System.out.print(" 4. Display All Customer IDs\n");
        System.out.print(" 5. Add Kitkat Chocolate\n");
        System.out.print(" 6. Add Cadbury Chocolate\n");
        System.out.print(" 7. Remove Product\n");
        System.out.print(" 8. Display Product Info\n");
        System.out.print(" 9. Display All Product IDs\n");
        System.out.print("10. Create Order\n");
        System.out.print("11. Add Product to Order\n");
        System.out.print("12. Display Order Details\n");
        System.out.print("13. Display All Orders\n");
        System.out.print("14. Add Money to Customer Balance\n");
        System.out.print("15. Deduct Money from Customer Balance\n");
        System.out.print("16. Save Database\n");
        System.out.print("17. Load Database\n");
    }

    // Different menu operations
    // Customer related
    void addCustomer(); // Add a new customer
    void removeCustomer();  // Removes a customer by id
    void displayCustomerInfo(); // Display details of a specific customer
    void displayAllCustomerIDs();// Display Ids of all customers
    void addMoneyToCustomer(); // give money to a customer
    void removeMoneyFromCustomer();// take money away from a customer
    
    //Produtc related
    void addKitkatChocolate(); // add a Kitkat chocolate to the product list
    void addCadburyChocolate(); // add a Cadbury chocolate to products
    void removeProduct(); // remove a product by ID
    void displayProductInfo(); // display details of a specific product
    void displayAllProductIDs(); // display IDs of all products
    
    //Orders
    void createOrder();  // Create a new order for a customer
    void addProductToOrder();// Add a product to an existing order
    void displayOrderDetails();// Display details of an specific order
    void displayAllOrders(); // Display all orders
    
    //Data
    void saveDatabase(); // Saving current data to file
    void loadDatabase(); // Getting the saved data from the file
}
