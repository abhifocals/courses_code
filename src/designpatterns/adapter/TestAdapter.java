package designpatterns.adapter;

public class TestAdapter {

    public static void main(String[] args) {

        Tank tank = new Tank();

        System.out.println("--- Tank ---");
        System.out.println(tank.fires());
        System.out.println(tank.drives());

        Robot robot = new Robot();

        System.out.println("--- Robot ---");
        System.out.println(robot.tramps());
        System.out.println(robot.walks());

        RobotToTankAdapter adapter = new RobotToTankAdapter(robot);

        System.out.println("--- Adapter ---");
        System.out.println(tank.fires());
        System.out.println(tank.drives());

    }




}
