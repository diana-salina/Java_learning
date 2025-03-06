package ru.nsu.salina.animals;

public class Dog extends Animal{
    public Dog() {
        super();
        runLimit = 500;
        swimLimit = 10;
    }
    @Override
    public void run(int distance) {
        successMessage = "Собака пробежала " + distance + " метров";
        failureMessage = "Собака не может пробежать целых " + distance + " метров";
        super.run(distance);
    }
    @Override
    public void swim(int distance) {
        successMessage = "Собака проплыла " + distance + " метров";
        failureMessage = "Собака не может проплыть целых " + distance + " метров";
        super.swim(distance);
    }
}
