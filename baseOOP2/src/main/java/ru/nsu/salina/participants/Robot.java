package ru.nsu.salina.participants;

public class Robot implements Participant{
    private final int runLimit = 50;
    private final int jumpLimit = 200;
    String name;
    public Robot(String name) {
        this.name = name;
    }

    @Override
    public boolean run(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException();
        } else if (distance < runLimit) {
            System.out.println("Робот пробежал " + distance + "м");
            return true;
        } else {
            System.out.println("Робот не может пробежать " + distance + "м");
            return false;
        }
    }

    @Override
    public boolean jump(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException();
        } else if (distance < jumpLimit) {
            System.out.println("Робот прыгнул на " + distance + "м");
            return true;
        } else {
            System.out.println("Робот не может прыгнуть на " + distance + "м");
            return false;

        }
    }

    @Override
    public String getName() {
        return name;
    }
}
