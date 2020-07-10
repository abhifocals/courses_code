package designpatterns.singleton;

public class GetThread implements Runnable {

    @Override
    public void run() {

        AnySingleton anySingleton = AnySingleton.getInstance();

        System.out.println("Instance Id: " + System.identityHashCode(anySingleton));



    }
}
