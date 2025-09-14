import java.io.Serializable;
/**
 * Write a description of class Drinks here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Drinks implements Serializable
{
    private static final long serialVersionUID = 1L; // needed for serialization to manage any changes
    protected String name; // protected field encapsulation
    protected double price; // protected field encapsulation
    protected final int id;
    
    // drink constructor
    public Drinks(int i, String n, double p) { // Constructor
        this.id = i;
        this.name = n;
        this.price = p;
    }

    // Abstract to be implemented by subclasses
    public abstract String getDescription();
    
    
    // Getters and setters
    public int getId() {
        return id;
    }
    
    public String getName() { // Encapsulation: Getter
        return name;
    }

    public void setName(String name) { // Encapsulation: Setter
        this.name = name;
    }

    public double getPrice() { // Encapsulation: Getter
        return price;
    }

    public void setPrice(double price) { // Encapsulation: Setter
        this.price = price;
    }
    
    
    // This ensures that the toString is changed to print out better info
    @Override
    public String toString() { // Polymorphism: Overriding toString() method
        return "id: "+id + " " + name + " = €" + price;
    }
}
