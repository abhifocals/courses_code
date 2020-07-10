package designpatterns.observer;

public class Observer implements ObserverInterface {

    Subject subject;


    public Observer(Subject subject) {
        this.subject = subject;

        subject.register(this);
    }


    public void update(String message) {

        System.out.println("This Observer is updated with message: " + message);
    }


}
