package ru.nsu.salina.participants;

public interface Participant {
    boolean run(int distance);
    boolean jump(int distance);

    String getName();
}
