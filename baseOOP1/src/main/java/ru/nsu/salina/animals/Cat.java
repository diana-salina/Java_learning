package ru.nsu.salina.animals;

public class Cat extends Animal{
    public Cat() {
        runLimit = 200;
    }
    @Override
    public void swim(int distance) {
        System.out.println("Кот плавать не умеет:(");
    }
    @Override
    public void run(int distance) {
        message = "Кот пробежал " + distance + " метров";
        super.run(distance);
    }
}
