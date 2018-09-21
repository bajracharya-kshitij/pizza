import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kshitij on 9/21/18.
 */
public class PizzaDemo {

    public static void main(String[] args) {
        System.out.println("Welcome to pizza store!");

        ArrayList<Pizza> pizzas = getOrders();

        OrderUtil.displayFinalOrder(pizzas);
    }

    private static ArrayList<Pizza> getOrders() {
        boolean endOfOrder = false;
        ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
        Scanner scanner = new Scanner(System.in);

        Pizza pizza;
        while(!endOfOrder) {
            pizza = buildPizza();
            pizzas.add(pizza);
            System.out.println("Anything else? (Yes/No): ");
            String anyMorePizzas = scanner.next();
            endOfOrder = !(anyMorePizzas.equalsIgnoreCase("Y") || anyMorePizzas.equalsIgnoreCase("Yes"));
        }

        return pizzas;
    }

    private static Pizza buildPizza() {
        System.out.println("Enter the size of your choice - Small, Medium or Large: ");
        Scanner scanner = new Scanner(System.in);
        String size = scanner.next();

        PizzaFactory pizzaFactory = new PizzaFactory();

        Pizza pizza = null;
        try {
            pizza = pizzaFactory.getPizza(size);
            pizza.build();
        } catch (Exception e) {
            System.out.println("That's not a valid input");
            pizza = buildPizza();
        }
        return pizza;
    }
}
