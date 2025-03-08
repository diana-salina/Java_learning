package ru.nsu.salina.participants;

public class Human implements Participant{
    private final int runLimit = 150;
    private final int jumpLimit = 70;
    String name;
    public Human(String name) {
        this.name = name;
    }

    @Override
    public boolean run(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException();
        } else if (distance < runLimit) {
            System.out.println("Человек пробежал " + distance + "м");
            return true;
        } else {
            System.out.println("Человек не может пробежать " + distance + "м");
            return false;
        }
    }

    @Override
    public boolean jump(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException();
        } else if (distance < jumpLimit) {
            System.out.println("Человек прыгнул на " + distance + "м");
            return true;
        } else {
            System.out.println("Человек не может прыгнуть на " + distance + "м");
            return false;

        }
    }

    @Override
    public String getName() {
        return name;
    }
}
