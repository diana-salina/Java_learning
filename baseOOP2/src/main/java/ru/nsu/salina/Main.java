package ru.nsu.salina;

import ru.nsu.salina.obstacles.Obstacle;
import ru.nsu.salina.obstacles.Treadmill;
import ru.nsu.salina.obstacles.Wall;
import ru.nsu.salina.participants.Cat;
import ru.nsu.salina.participants.Human;
import ru.nsu.salina.participants.Participant;
import ru.nsu.salina.participants.Robot;

public class Main {
    public static void main(String[] args) {
        Obstacle[] obstacles = {new Wall(50),
                new Treadmill(100),
                new Wall(100)};
        Participant[] participants = {new Cat("Кот"),
                new Robot("Робот"),
                new Human("Человек")};
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.isOvercomed(participant)) {
                    System.out.println(participant.getName() + " не справился с трассой:(");
                    break;
                }
            }
        }
    }
}