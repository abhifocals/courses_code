package designpatterns.command;

public class DeviceButtonInvoker {

    Command command;

    public DeviceButtonInvoker(Command newCommand) {
        command = newCommand;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndo() {
        command.undo();
    }

}
