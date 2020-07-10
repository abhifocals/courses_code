package designpatterns.decorator;

public class SimplePizza implements PizzaInterface {
    @Override
    public String getDesc() {

        return "Simple Pizza";
    }

    @Override
    public double getPrice() {
        return 4.00;
    }
}
