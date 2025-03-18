package ru.nsu.salina;

import ru.nsu.salina.fruits.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitBox<F extends Fruit> {
    private final List<F> fruits;
    public FruitBox() {
        fruits = new ArrayList<F>();
    }

    @SafeVarargs
    public FruitBox(F... fruits) {
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
    public boolean compare(FruitBox<?> box) {
        return this.getWeight() == box.getWeight();
    }
    public void moveTo(FruitBox<F> box) {
        if (this == box) {
            return;
        }
        for (F fruit : fruits) {
            box.add(fruit);
        }
        fruits.clear();
    }
}
