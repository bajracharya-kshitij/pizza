import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by kshitij on 9/21/18.
 */
public class PizzaDemo {

    public static double totalCost = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to pizza store!");

        Set<Pizza> pizzas = getOrders();

        displayFinalOrderWithTotalCost(pizzas);
    }

    private static Set<Pizza> getOrders() {
        boolean endOfOrder = false;
        Set<Pizza> pizzas = new HashSet<Pizza>();
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

        Pizza pizza = pizzaFactory.getPizza(size);
        pizza.build();
        return pizza;
    }

    private static void displayFinalOrderWithTotalCost(Set<Pizza> pizzas) {
        System.out.println("Your order is ready. You have ");
        for(Pizza p : pizzas) {
            System.out.println("A "+ p.size + " pizza worth $" + p.cost);
            totalCost += p.cost;
        }
        System.out.println("That'll be $" + totalCost);
    }
}
