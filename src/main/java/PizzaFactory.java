/**
 * Created by kshitij on 9/21/18.
 */
public class PizzaFactory {

    public Pizza getPizza(String size) {
        if(size.equalsIgnoreCase("SMALL")) {
            return new SmallPizza();
        }

        if(size.equalsIgnoreCase("MEDIUM")) {
            return new MediumPizza();
        }

        if(size.equalsIgnoreCase("LARGE")) {
            return new LargePizza();
        }

        return null;
    }
}
