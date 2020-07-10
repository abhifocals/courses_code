package designpatterns.decorator;

public class PizzaDecorator implements PizzaInterface {

    PizzaInterface pizza;

    public PizzaDecorator(PizzaInterface pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDesc() {
        return pizza.getDesc();
    }

    @Override
    public double getPrice() {
        return pizza.getPrice();
    }
}
