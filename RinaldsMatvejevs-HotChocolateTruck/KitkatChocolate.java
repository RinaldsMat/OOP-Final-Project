
/**
 * Write a description of class KitkatChocolate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class KitkatChocolate extends Drinks
{
    // instance variables - replace the example below with your own
    private boolean chunky; // Additional property unique to KitkatChocolate

    // Constructor demonstrating upcasting
    public KitkatChocolate(int i, String n, double p, boolean c) {
        super(i, n, p); // Calls the superclass constructor
        this.chunky = c;
    }

    public boolean getChunky() { // Encapsulation: Getter
        return this.chunky;
    }

    public void setChunky(boolean c) { // Encapsulation: Setter
        this.chunky = c;
    }

    @Override
    public String getDescription() { // Dynamic Polymorphism: Implementing abstract method
        if (chunky) {
            return name + " with chunks, priced €" + price;
        }
        else {
            return name + " with NO chunks, priced €" + price;
        }
    }
}
