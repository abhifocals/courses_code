package designpatterns.adapter;

public class RobotToTankAdapter implements TankInterface {

    RobotInterface robot;

    public RobotToTankAdapter(RobotInterface robot) {
        this.robot = robot;
    }

    @Override
    public String fires() {
        return robot.tramps();
    }

    @Override
    public String drives() {
        return robot.walks();
    }
}
