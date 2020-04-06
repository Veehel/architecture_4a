package com.esiea.tp4A.domain;


import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MarsRoverMoveTest {
    @Test
    void initial_position_at_0() {
        MarsRoverMove marsRover = new MarsRoverMove(0, 0, Direction.NORTH);
        Position newPosition = marsRover.move("");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(0, 0, Direction.NORTH));
    }

    @Test
    void initial_position_elsewhere() {
        MarsRoverMove marsRover = new MarsRoverMove(32, 14, Direction.SOUTH);
        Position newPosition = marsRover.move("");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(32, 14, Direction.SOUTH));
    }

    @Test
    void front_move() {
        MarsRoverMove marsRover = new MarsRoverMove(32, 14, Direction.SOUTH);
        Position newPosition = marsRover.move("f");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(32, 15, Direction.SOUTH));
    }

    @Test
    void back_move() {
        MarsRoverMove marsRover = new MarsRoverMove(32, 14, Direction.SOUTH);
        Position newPosition = marsRover.move("b");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(32, 13, Direction.SOUTH));
    }

    @Test
    void right_move() {
        MarsRoverMove marsRover = new MarsRoverMove(32, 14, Direction.SOUTH);
        Position newPosition = marsRover.move("r");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(31, 14, Direction.SOUTH));
    }

    @Test
    void left_move() {
        MarsRoverMove marsRover = new MarsRoverMove(32, 14, Direction.SOUTH);
        Position newPosition = marsRover.move("l");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(33, 14, Direction.SOUTH));
    }
}
