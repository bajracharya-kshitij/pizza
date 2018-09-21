import java.util.Set;

/**
 * Created by kshitij on 9/21/18.
 */
public abstract class Pizza {

    protected String size;
    protected int cost;
    protected Set<String> toppings;

    abstract public void build();
}
