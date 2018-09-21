import java.util.ArrayList;

/**
 * Created by kshitij on 9/21/18.
 */
public class OrderUtil {

    public static final int DELIVERY_CHARGE = 8;

    static void displayCurrentStateOfPizza(String size, ArrayList<String> toppings) {
        System.out.println("a " + size + " pizza with tomato base and cheese topping. ");
        if(toppings.size() > 0) {
            System.out.print("You've also added ");
            for(int i=0; i<toppings.size(); i++) {
                System.out.print(toppings.get(i));
                if(toppings.size() > 1) {
                    if(i == (toppings.size() - 2)) {
                        System.out.print(" and ");
                    } else if(i != (toppings.size() - 1)){
                        System.out.print(", ");
                    }
                }
            }
            System.out.print(" as additional topping(s)\n");
        }
    }

    static void displayFinalOrder(Order order) {
        System.out.println("Hi " + order.customerName + "(" + order.phoneNumber + "),");
        System.out.println("Your order is ready. You have");
        for(Pizza p : order.items) {
            displayCurrentStateOfPizza(p.size, p.toppings);
            System.out.println("Cost for this pizza will be $" + p.cost);
        }
        if(order.deliveryCharge) {
            System.out.println("An additional $" + DELIVERY_CHARGE + " will be added as delivery charge.");
        }
        System.out.println("Your total bill amount is: $" + order.totalCost);
        if(order.address != null) {
            System.out.println("Your order will be delivered to " + order.address + " shortly!");
        } else {
            System.out.println("You can now collect your order!");
        }
        System.out.println("Thank you for shopping with the Pizza Store! Enjoy and do come again :)");
    }
}
