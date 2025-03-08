package ru.nsu.salina.participants;

public class Cat implements Participant{
    private final int runLimit = 200;
    private final int jumpLimit = 170;
    String name;
    public Cat(String name) {
        this.name = name;
    }

    @Override
    public boolean run(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException();
        } else if (distance < runLimit) {
            System.out.println("Кот пробежал " + distance + "м");
            return true;
        } else {
            System.out.println("Кот не может пробежать " + distance + " м");
            return false;
        }
    }

    @Override
    public boolean jump(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException();
        } else if (distance < jumpLimit) {
            System.out.println("Кот прыгнул на " + distance + "м");
            return true;
        } else {
            System.out.println("Кот не может прыгнуть на " + distance + "м");
            return false;

        }
    }

    @Override
    public String getName() {
        return name;
    }
}
