package designpatterns.builder;

public class TestBuilder {

    public static void main(String[] args) {

        RobotEngineer engineer = new RobotEngineer(new FireyRobotBuilder());

        engineer.makeRobot();

        engineer.getRobot();


        FireyRobotBuilder builder = new FireyRobotBuilder();

        builder.buildRobotArms();
    }

}


