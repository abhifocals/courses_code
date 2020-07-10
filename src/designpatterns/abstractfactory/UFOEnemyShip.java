package designpatterns.abstractfactory;

public class UFOEnemyShip extends EnemyShip {

    @Override
    public void doStuff() {
        super.doStuff();

        System.out.println("Also doing UFO stuff");
    }
}
