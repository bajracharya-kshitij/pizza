import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kshitij on 9/21/18.
 */
public class PizzaDemo {

    public static void main(String[] args) {
        System.out.println("Welcome to the Pizza Store!");

        Order order = new Order();
        order.create();

        OrderUtil.displayFinalOrder(order);
    }
}
