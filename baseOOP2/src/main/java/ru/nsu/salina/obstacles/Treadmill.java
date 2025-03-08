package ru.nsu.salina.obstacles;

public class Treadmill implements Obstacle{
    private final int lenght;
    public Treadmill(int length) {
        this.lenght = length;
    }
    public int getLenght() {
        return lenght;
    }
}
