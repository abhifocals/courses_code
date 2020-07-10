package designpatterns.observer;

public class TestObserver {


    public static void main(String[] args) {


        Subject subject = new Subject();

        Observer observer1 = new Observer(subject);


        subject.set("Running Test Observer.");






    }





}
