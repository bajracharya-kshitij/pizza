/**
 * Created by kshitij on 9/21/18.
 */
public class PizzaDemo {

    public static void main(String[] args) {
        System.out.println("Welcome to pizza store!");

        Pizza smallPizza = new SmallPizza();
        smallPizza.build();
        System.out.println("The size of the pizza is " + smallPizza.size + " and it costs $" + smallPizza.cost);

        Pizza mediumPizza = new MediumPizza();
        mediumPizza.build();
        System.out.println("The size of the pizza is " + mediumPizza.size + " and it costs $" + mediumPizza.cost);

        Pizza largePizza = new LargePizza();
        largePizza.build();
        System.out.println("The size of the pizza is " + largePizza.size + " and it costs $" + largePizza.cost);
    }
}
