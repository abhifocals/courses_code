package designpatterns.command;

public class TestCommand {

    public static void main(String[] args){

        Command tvOn = new TurnTVOn(new TV());

        DeviceButtonInvoker invoker = new DeviceButtonInvoker(tvOn);

        invoker.pressButton();

        invoker.pressUndo();





    }
}
