import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;

/**
 * Created by kshitij on 9/21/18.
 */
public class OrderUtil {

    public static double totalCost = 0;

    static void displayCurrentStateOfPizza(String size, ArrayList<String> toppings) {
        System.out.println("a " + size + " pizza with tomato base and cheese topping. ");
        if(toppings.size() > 0) {
            System.out.print("You've also added ");
            System.out.print(StringUtils.join(toppings, ","));
            System.out.print(" as additional topping(s)\n");
        }
    }

    static void displayFinalOrder(ArrayList<Pizza> pizzas) {
        System.out.println("Your order is ready. You have");
        for(Pizza p : pizzas) {
            displayCurrentStateOfPizza(p.size, p.toppings);
            System.out.println("Cost for this pizza will be " + p.cost);
            totalCost += p.cost;
        }
        System.out.println("That'll be $" + totalCost);
    }
}
