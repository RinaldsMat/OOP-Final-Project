import java.util.Scanner; //necessary for getting input
/**
 * MyMain is being used to call functions to display the menu & perform actions
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyMain
{
    // instance variables - replace the example below with your own
    public static void main(String[] args) {
        HCTimplement truck = new HCTimplement(); // Instance of functionality class
        Scanner scanner = new Scanner(System.in); //Using scanner for getting user input
        boolean exit = false; // This boolean controls wether to stop the menu or not

        while (!exit) {
            HCTInterface.printMenu(); // Uses the interface class to display the menu
            System.out.print("Enter choice: "); //asks user for input
            int choice = scanner.nextInt(); //saves the answer as variable
            scanner.nextLine(); // prepares new line

            switch (choice) {
                // each case number is assigned to a function corresponding
                // to the menu, doing what the title suggests
                case 0: exit = true; break; //breaks the while statement
                case 1: truck.addCustomer(); break;
                case 2: truck.removeCustomer(); break;
                case 3: truck.displayCustomerInfo(); break;
                case 4: truck.displayAllCustomerIDs(); break;
                case 5: truck.addKitkatChocolate(); break;
                case 6: truck.addCadburyChocolate(); break;
                case 7: truck.removeProduct(); break;
                case 8: truck.displayProductInfo(); break;
                case 9: truck.displayAllProductIDs(); break;
                case 10: truck.createOrder(); break;
                case 11: truck.addProductToOrder(); break;
                case 12: truck.displayOrderDetails(); break;
                case 13: truck.displayAllOrders(); break;
                case 14: truck.addMoneyToCustomer(); break;
                case 15: truck.removeMoneyFromCustomer(); break;
                case 16: truck.saveDatabase(); break;
                case 17: truck.loadDatabase(); break;
                default: System.out.println("Choice Not Valid!");
            }
        }
        System.out.println("End."); // The end
    }
}
