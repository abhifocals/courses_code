package designpatterns.decorator;

public class Sauce extends PizzaDecorator {

    PizzaInterface pizza;


    public Sauce(PizzaInterface pizza) {
        super(pizza);
        this.pizza = pizza;
    }

    public String getDesc(){

        return pizza.getDesc() + " + Sauce";

    }

    public double getPrice(){

        return pizza.getPrice() + 2.00;

    }

}
