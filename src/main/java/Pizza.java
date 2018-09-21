import java.util.*;

/**
 * Created by kshitij on 9/21/18.
 */
public abstract class Pizza {

    protected String size;
    protected int cost;
    protected ArrayList<String> toppings = new ArrayList<String>();

    private static final int NO_OF_TOPPINGS = 4;
    public static final List<String> PIZZA_TOPPINGS = Collections.unmodifiableList(Arrays.asList(
                                                    "Bacon", "Olives", "Ham", "Mushrooms",
                                                    "Pineapple", "Salami", "Anchovies"));

    public void build() {
        specifySizeAndCost();
        buildWithToppings();
    }

    private void buildWithToppings() {
        boolean finishedAddingToppings = false;
        while (this.toppings.size() < NO_OF_TOPPINGS) {
            System.out.print("You have ");
            OrderUtil.displayCurrentStateOfPizza(this.size, this.toppings);
            System.out.println("\nYou can add up to " + (NO_OF_TOPPINGS - this.toppings.size()) + " more toppings. Available options:");
            getToppings();
            finishedAddingToppings = addToppings();
            if(finishedAddingToppings) {
                break;
            }
        }
        if(!finishedAddingToppings) {
            System.out.println("You have reached the maximum amount of toppings you can add.");
        }
        System.out.print("You have ");
        OrderUtil.displayCurrentStateOfPizza(this.size, this.toppings);
    }

    private static void getToppings() {
        for(int i=1; i<=PIZZA_TOPPINGS.size(); i++) {
            System.out.println(i + ". " + PIZZA_TOPPINGS.get(i-1));
        }
        System.out.println(PIZZA_TOPPINGS.size()+1 + ". That's all the toppings I want.");
    }

    abstract public void specifySizeAndCost();

    public boolean addToppings() {
        boolean finishedAddingToppings = false;
        Scanner scanner = new Scanner(System.in);
        int selectedToppingId = scanner.nextInt();
        if((selectedToppingId > 0) && (selectedToppingId <= PIZZA_TOPPINGS.size())) {
            String selectedTopping = PIZZA_TOPPINGS.get(selectedToppingId-1);
            if(this.toppings.contains(selectedTopping)) {
                System.out.println("You've already added " + selectedTopping + ". Choose another.");
            } else {
                this.toppings.add(selectedTopping);
                this.cost++;
            }
        } else if(selectedToppingId == PIZZA_TOPPINGS.size()+1) {
            finishedAddingToppings = true;
        } else {
            System.out.println("That's not a valid input. Please choose from the available options");
        }
        return finishedAddingToppings;
    }
}
