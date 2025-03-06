package ru.nsu.salina;

import ru.nsu.salina.animals.Animal;
import ru.nsu.salina.animals.Cat;
import ru.nsu.salina.animals.Dog;
import ru.nsu.salina.animals.Tiger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Animal> animals = new ArrayList<>(N);
        Random random = new Random();
        for (int i = 0; i < N; ++i) {
            animals.add(generateAnimal());
            animals.get(i).swim(random.nextInt(300));
            animals.get(i).run(random.nextInt(300));
        }
        System.out.println("Число животных:" + Animal.getAmount());
    }
    static private Animal generateAnimal() {
        Random random = new Random();
        int genId = random.nextInt(3);
        if (genId == 1) {
            return new Cat();
        } else if (genId == 2) {
            return new Dog();
        } else {
            return new Tiger();
        }
    }
}