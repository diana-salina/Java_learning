package ru.nsu.salina.stages;

import ru.nsu.salina.Car;

public abstract class Stage {
    protected   int  length;
    protected  String description;
    public  String  getDescription () {
        return  description;
    }
    public   abstract   void   go (Car c);
}
