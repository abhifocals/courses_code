package designpatterns.builder;

public class GenericRobot implements RobotInterface {

    String arms;

    public void buildArms(String arms) {
        this.arms = arms;
    }

    public String getArms() {
        return arms;
    }
}
