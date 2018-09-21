import java.util.Scanner;

/**
 * Created by kshitij on 9/21/18.
 */
public class PizzaDemo {

    public static void main(String[] args) {
        System.out.println("Welcome to pizza store!");
        System.out.println("Enter the size of your choice - Small, Medium or Large: ");

        Scanner scanner = new Scanner(System.in);
        String size = scanner.next();

        PizzaFactory pizzaFactory = new PizzaFactory();

        Pizza pizza = pizzaFactory.getPizza(size);
        pizza.build();
        System.out.println("The size of the pizza is " + pizza.size + " and it costs $" + pizza.cost);
    }
}
