package designpatterns.builder;

public class FireyRobotBuilder implements RobotBuilder {

    GenericRobot robot;


    public FireyRobotBuilder() {
        this.robot = new GenericRobot();
    }

    @Override
    public void buildRobotArms() {
        robot.buildArms("Firey Arms");
    }

    @Override
    public GenericRobot getRobot() {
        return robot;
    }
}
