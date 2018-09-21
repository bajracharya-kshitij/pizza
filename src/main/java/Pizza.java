import java.util.Set;

/**
 * Created by kshitij on 9/21/18.
 */
public abstract class Pizza {

    protected String size;
    protected Double cost;
    protected Set<String> toppings;

    public void printPizza() {
        System.out.println("a type of pizza");
    }

    public String getSize() {
        return this.size;
    }

    abstract public void setSize();
}
