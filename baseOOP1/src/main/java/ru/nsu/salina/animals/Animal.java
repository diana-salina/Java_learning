package ru.nsu.salina.animals;

public class Animal {
    protected int runLimit;
    protected int swimLimit;
    protected String message;
    static int animalsAmount = 0;
    public Animal() {
        runLimit = -1;
        swimLimit = -1;
        message = "";
        ++animalsAmount;
    }

    public static int getAmount() {
        return animalsAmount;
    }

    public void run(int distance) {
        if (runLimit == -1 || distance < runLimit) {
            if (message.isEmpty()) {
                System.out.printf("Животное пробежало %d м%n", distance);
            } else {
                System.out.println(message);
            }
        }
    }
    public void swim(int distance) {
        if (swimLimit == -1 || distance < runLimit) {
            if (message.isEmpty()) {
                System.out.printf("Животное проплыло %d м%n", distance);
            } else {
                System.out.println(message);
            }
        }
    }
}
