package designpatterns.abstractfactory;

public class EnemyShipFactory {

    public EnemyShip makeEnemyShip(String shipType) {

        if (shipType.equals("UFO")) {
            return new UFOEnemyShip();
        }
        else return null;
    }


}
