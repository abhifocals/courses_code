package designpatterns.singleton;

public class AnySingleton {

    private static AnySingleton firstInstance = null;

    private static boolean firstThread = true;

    private AnySingleton() {

    }

    public static AnySingleton getInstance() {

        if (firstInstance == null) {

            if (firstThread) {

                firstThread = false;
                Thread.currentThread();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
            synchronized (AnySingleton.class) {
                if (firstInstance == null) {
                    firstInstance = new AnySingleton();
                }
            }



        return firstInstance;


    }




}
