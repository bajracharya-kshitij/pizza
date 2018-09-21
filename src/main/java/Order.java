import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kshitij on 9/21/18.
 */
public class Order {

    ArrayList<Pizza> items;
    String collectionType;
    String customerName;
    String phoneNumber;
    String address;
    boolean deliveryCharge = false;
    double totalCost = 0;

    void create() {
        this.items = getItems();
        this.getOrderCollectionDetails();
        for(Pizza p: this.items) {
            this.totalCost += p.cost;
        }
        if(this.totalCost<30) {
            this.deliveryCharge = true;
            this.totalCost += OrderUtil.DELIVERY_CHARGE;
        }
    }

    private static ArrayList<Pizza> getItems() {
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

    private void getOrderCollectionDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want the order to be collected or delivered: ");
        this.collectionType = scanner.next();

        System.out.println("Your name: ");
        this.customerName = scanner.next();

        System.out.println("Phone number: ");
        this.phoneNumber = scanner.next();

        if(this.collectionType.equalsIgnoreCase("Delivered")) {
            System.out.println("Address: ");
            this.address = scanner.next();
        }
    }
}
