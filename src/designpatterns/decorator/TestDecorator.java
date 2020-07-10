package designpatterns.decorator;

public class TestDecorator {

    public static void main(String[] args) {


        SimplePizza simplePizza = new SimplePizza();

//        System.out.println(simplePizza.getDesc() + "; " + simplePizza.getPrice());

        PizzaDecorator cheesePizza = new Cheese(simplePizza);

//        System.out.println(cheesePizza.getDesc() + "; " + cheesePizza.getPrice());

        PizzaDecorator saucePizza = new Sauce(cheesePizza);

//        System.out.println(saucePizza.getDesc() + "; " + saucePizza.getPrice());


        // Double Sauce and Cheese Pizza
        PizzaDecorator doubleSauceCheesePizza = new Cheese(new Sauce(new Sauce(new SimplePizza())));
        System.out.println(doubleSauceCheesePizza.getDesc() + "; " + doubleSauceCheesePizza.getPrice());


    }




}
