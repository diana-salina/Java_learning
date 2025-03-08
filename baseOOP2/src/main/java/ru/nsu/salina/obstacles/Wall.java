package ru.nsu.salina.obstacles;

import ru.nsu.salina.participants.Participant;

public class Wall implements Obstacle{
    private final int height;
    public Wall(int height) {
        this.height = height;
    }
    @Override
    public boolean isOvercomed(Participant participant) {
        if (participant.jump(height)) return true;
        else return false;
    }
}
