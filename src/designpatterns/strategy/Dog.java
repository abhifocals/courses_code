package designpatterns.strategy;

public class Dog extends Animal {


    public Dog() {
        fly = new CantFly();
    }

}
