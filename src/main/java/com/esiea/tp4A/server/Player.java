package com.esiea.tp4A.server;

import com.esiea.tp4A.domain.*;

enum PlayerStatus {
    alive,
    dead
};

public class Player {
    private String name;
    public PlayerStatus status;
    private MarsRover rover;

    Player(String inName) {
        name = inName;
        status = PlayerStatus.alive;
        rover = new MarsRoverMove(0, 0, Direction.NORTH);
    }

    PlayerStatus getStatus() { return status; }

    String getName() {
        return name;
    }

    MarsRover getRover() {
        return rover;
    }

    void setRover(MarsRover newRover) {
        rover = newRover;
    }
}
