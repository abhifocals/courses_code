package designpatterns.strategy;

public class Bird extends Animal {

    public Bird() {
        fly = new CanFly();
    }
}
