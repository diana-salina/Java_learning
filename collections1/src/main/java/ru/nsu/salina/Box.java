package ru.nsu.salina;

import ru.nsu.salina.fruits.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<F extends Fruit> {
    private final List<F> fruits;
    public Box() {
        fruits = new ArrayList<F>();
    }

    public Box(F... fruits) {
        this.fruits = new ArrayList<>(Arrays.asList(fruits));
    }
    public void add(F fruit) {
        fruits.add(fruit);
    }
    public double getWeight() {
        if (fruits.isEmpty()) {
            return 0.0f;
        }
        return fruits.getFirst().getWeight() * fruits.size();
    }
    public boolean compare(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }
    public void moveTo(Box<F> box) {
        if (this == box) {
            return;
        }
        for (F fruit : fruits) {
            box.add(fruit);
        }
        fruits.clear();
    }
}
