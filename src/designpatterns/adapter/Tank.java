package designpatterns.adapter;

public class Tank implements TankInterface {


    @Override
    public String fires() {
        return "Tank Fired";
    }

    @Override
    public String drives() {
        return "Tank Drove";
    }
}
