package ru.nsu.salina.animals;

public class Dog extends Animal{
    public Dog() {
        super();
        runLimit = 500;
        swimLimit = 10;
    }
    @Override
    public void run(int distance) {
        message = "Собака пробежала " + distance + " метров";
        super.run(distance);
    }
    @Override
    public void swim(int distance) {
        message = "Собака проплыла " + distance + " метров";
        super.swim(distance);
    }
}
