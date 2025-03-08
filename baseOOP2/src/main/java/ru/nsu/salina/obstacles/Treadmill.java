package ru.nsu.salina.obstacles;

import ru.nsu.salina.participants.Participant;

public class Treadmill implements Obstacle{
    private final int lenght;
    public Treadmill(int length) {
        this.lenght = length;
    }

    @Override
    public boolean isOvercomed(Participant participant) {
        if (participant.run(lenght)) return true;
        else return false;
    }
}
