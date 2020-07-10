package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    List<ObserverInterface> observers;
    ObserverInterface observer = null;

    public Subject() {
        observers = new ArrayList<>();
    }


    public void register(ObserverInterface o){
        System.out.println("Adding the Observer");
        observers.add(o);
    }

    public void unregister(ObserverInterface o){
        System.out.println("Removing the Observer");
        int observerIndex = observers.indexOf(o);
        observers.remove(observerIndex);
    }

    public void set(String updatedMessage){

        for (ObserverInterface observer: observers) {
            observer.update(updatedMessage);
        }


    }
}
