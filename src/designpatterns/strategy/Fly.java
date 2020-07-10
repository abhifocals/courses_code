package designpatterns.strategy;

public interface Fly {

    public String tryToFly();
}

class CanFly implements Fly {

    @Override
    public String tryToFly() {
        return "I can fly!";
    }
}

class CantFly implements Fly {

    @Override
    public String tryToFly() {
        return "I can't fly!";
    }
}