package designpatterns.strategy;

public class Animal {

    protected Fly fly;

    public String walk() {
        return "I can walk!";
    }

    public String tryToFly() {
        return fly.tryToFly();
    }

    public void setFlyingCapability(Fly newfly) {
        this.fly = newfly;
    }

}
