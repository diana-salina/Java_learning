package ru.nsu.salina.fruits;

public abstract class Fruit {
    double weight;
    public Fruit(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
}
