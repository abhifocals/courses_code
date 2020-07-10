package designpatterns.strategy;

public class TestStrategy {


   public static void main(String[] args) {

       Dog dog = new Dog();

       System.out.println(dog.tryToFly());

       Bird bird = new Bird();

       System.out.println(bird.tryToFly());

       dog.setFlyingCapability(new CanFly());

       System.out.println(dog.tryToFly());

   }






}
