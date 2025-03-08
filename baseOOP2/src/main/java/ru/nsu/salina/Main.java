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
        for (int i = 0; i < participants.length; ++i) {
            Participant currentParticipant = participants[i];
            for (int j = 0; j < obstacles.length; ++j) {
                Obstacle currentObstacle = obstacles[j];
                if (!currentObstacle.isOvercomed(currentParticipant)) {
                    System.out.println(currentParticipant.getName() + " не справился с трассой:(");
                    break;
                }
            }
        }
    }
}