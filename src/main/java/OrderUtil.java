import java.util.ArrayList;

/**
 * Created by kshitij on 9/21/18.
 */
public class OrderUtil {

    public static final int DELIVERY_CHARGE = 8;

    static void displayCurrentStateOfPizza(String size, ArrayList<String> toppings) {
        System.out.println("a " + size + " pizza with tomato base and cheese topping. ");
        if(toppings.size() > 0) {
            System.out.print("You've also added " + getToppings(toppings) + " as additional topping(s)\n");
        }
    }

    private static StringBuilder getToppings(ArrayList<String> toppings) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<toppings.size(); i++) {
            sb.append(toppings.get(i));
            if(toppings.size() > 1) {
                if(i == (toppings.size() - 2)) {
                    sb.append(" and ");
                } else if(i != (toppings.size() - 1)){
                    sb.append(", ");
                }
            }
        }
        return sb;
    }

    static void displayFinalOrder(Order order) {
        System.out.println("Hi " + order.customerName + "(" + order.phoneNumber + "),");
        System.out.println("Your order is ready. Following are the details: ");


        String format = "%-10s%-10s%-55s%-5s%n";
        System.out.format(format, "Size", "Base", "Toppings", "Cost");
        System.out.println("_______________________________________________________________________________");
        for(Pizza p : order.items) {
            ArrayList<String> toppingsWithCheese = p.toppings;
            toppingsWithCheese.add(0, "Cheese");
            System.out.format(format, p.size, "Tomato", getToppings(toppingsWithCheese), "$"+p.cost);
        }
        System.out.println("_______________________________________________________________________________");

        if(order.deliveryCharge) {
            System.out.format("%-75s%-5s%n", "Delivery Charge:", "$"+DELIVERY_CHARGE);
        }
        System.out.format("%-75s%-5s%n", "Total:", "$"+order.totalCost);

        if(order.address != null) {
            System.out.println("\nYour order will be delivered to " + order.address + " shortly!");
        } else {
            System.out.println("\nYou can now collect your order!");
        }
        System.out.println("\nThank you for shopping with the Pizza Store! Enjoy and do come again :)");
    }
}
