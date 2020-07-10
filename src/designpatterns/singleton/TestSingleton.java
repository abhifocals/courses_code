package designpatterns.singleton;

public class TestSingleton {

    public static void main(String[] args) {

        AnySingleton firstInstance = AnySingleton.getInstance();
        AnySingleton secondInstance = AnySingleton.getInstance();

//        System.out.println("Instance Id: " + System.identityHashCode(firstInstance));
//        System.out.println("Instance Id: " + System.identityHashCode(secondInstance));


        Runnable firstThread = new GetThread();
        Runnable secondThread = new GetThread();
        Runnable thirdThread = new GetThread();

        new Thread(firstThread).start();
        new Thread(secondThread).start();
        new Thread(thirdThread).start();



    }




}
