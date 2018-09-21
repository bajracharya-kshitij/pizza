/**
 * Created by kshitij on 9/21/18.
 */
public class PizzaDemo {

    public static void main(String[] args) {
        System.out.println("Welcome to pizza store!");

        Pizza smallPizza = new SmallPizza();
        smallPizza.setSize();
        smallPizza.printPizza();
        System.out.println("The size of the pizza is: " + smallPizza.getSize());

        Pizza mediumPizza = new MediumPizza();
        mediumPizza.setSize();
        mediumPizza.printPizza();
        System.out.println("The size of the pizza is: " + mediumPizza.getSize());

        Pizza largePizza = new LargePizza();
        largePizza.setSize();
        largePizza.printPizza();
        System.out.println("The size of the pizza is: " + largePizza.getSize());
    }
}
