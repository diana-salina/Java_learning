package ru.nsu.salina.animals;

public class Tiger extends Animal{
    public Tiger() {
        runLimit = 200;
        swimLimit = 150;
    }
    @Override
    public void swim(int distance) {
        successMessage = "Тигр проплыл " + distance + " метров";
        failureMessage = "Тигр не может проплыть целых " + distance + " метров";
        super.swim(distance);
    }
    @Override
    public void run(int distance) {
        successMessage = "Тигр пробежал " + distance + " метров";
        failureMessage = "Тигр не может пробежать целых " + distance + " метров";
        super.run(distance);
    }
}
