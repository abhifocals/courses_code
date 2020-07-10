package designpatterns.abstractfactory;

import java.util.Scanner;

public class TestAbstractFactory {

    public static void main(String[] args) {

        EnemyShipFactory shipFactory = new EnemyShipFactory();

        System.out.println("Enter desired Ship Type: ");

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {

            String shipType = scanner.next();

            if (shipFactory.makeEnemyShip(shipType) != null) {
                shipFactory.makeEnemyShip(shipType).doStuff();
            }
            else {
                System.out.println("This isn't a valid ship type.");
            }

        }


    }


}
