package designpatterns.builder;

public class RobotEngineer {

    RobotBuilder builder;


    public RobotEngineer(RobotBuilder builder) {
        this.builder = builder;
    }

    public void makeRobot() {
        builder.buildRobotArms();
    }

    public RobotInterface getRobot() {
        System.out.println("I have: " + builder.getRobot().getArms());
        return builder.getRobot();
    }

}
