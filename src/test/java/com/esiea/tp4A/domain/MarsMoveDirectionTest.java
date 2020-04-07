package com.esiea.tp4A.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MarsMoveDirectionTest {

    @Test
    void right_move() {
        MarsRoverMove marsRover = new MarsRoverMove(-23, 18, Direction.NORTH);
        Position newPosition = marsRover.move("r");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(-23, 18, Direction.EAST));
    }


    @Test
    void left_move() {
        MarsRoverMove marsRover = new MarsRoverMove(-23, 18, Direction.NORTH);
        Position newPosition = marsRover.move("l");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(-23, 18, Direction.WEST));
    }
}
