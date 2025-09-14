
/**
 * Write a description of class CadburyChocolate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CadburyChocolate extends Drinks
{
    
    private int smarties; // unique to Cadbury

    // this constructor is demonstrating upcasting
    public CadburyChocolate(int i, String n, double p, int s) {
        super(i,n, p); // calling the superclass constructor
        this.smarties = s;
    }

    public int getChunky() { // Encapsulation: Getter
        return this.smarties;
    }

    public void setSmarties(int s) { // Encapsulation: Setter
        if (s > 10){
        s = 10;
        }else if (s < 0) {
        s = 0;
        // ensure the user doesnt put too many or less than 0 smarties
        }
        this.smarties = s;
    }

    @Override
    public String getDescription() { // this is dynamic polymorphism as its implementing an abstract method
       return name + " with " + smarties + " smarties, priced €" + price;
    }
}
