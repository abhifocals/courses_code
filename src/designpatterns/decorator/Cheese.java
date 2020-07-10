package designpatterns.decorator;

public class Cheese extends PizzaDecorator {

    PizzaInterface pizza;


    public Cheese(PizzaInterface pizza) {
        super(pizza);
        this.pizza = pizza;
    }

    public String getDesc(){

        return pizza.getDesc() + " + Cheese";

    }

    public double getPrice(){

        return pizza.getPrice() + 3.00;

    }
}
