package ru.nsu.salina.obstacles;

public class Wall implements Obstacle{
    private final int height;
    public Wall(int height) {
        this.height = height;
    }
    public int getHeight() {
        return height;
    }
}
