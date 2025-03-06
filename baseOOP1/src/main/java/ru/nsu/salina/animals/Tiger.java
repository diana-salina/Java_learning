package ru.nsu.salina.animals;

public class Tiger extends Animal{
    public Tiger() {
        runLimit = 200;
        swimLimit = 150;
    }
    @Override
    public void swim(int distance) {
        message = "Тигр проплыл " + distance + " метров";
        super.swim(distance);
    }
    @Override
    public void run(int distance) {
        message = "Тигр пробежал " + distance + " метров";
        super.run(distance);
    }
}
