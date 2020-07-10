package designpatterns.command;

public class TurnTVOn implements Command {

    TV tv;

    public TurnTVOn(TV newTV) {
        this.tv = newTV;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
