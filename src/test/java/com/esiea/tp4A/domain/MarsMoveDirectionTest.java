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

    @Test
    void complex_moves_from_different_origin() {
        MarsRoverMove marsRover = new MarsRoverMove(5, -3, Direction.WEST);
        Position newPosition = marsRover.move("ff");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(3, -3, Direction.WEST));
    }

    @Test
    void complex_moves_from_different_origin2() {
        MarsRoverMove marsRover = new MarsRoverMove(0, 0, Direction.NORTH);
        Position newPosition = marsRover.move("lbblffr");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(2, -2, Direction.WEST));
    }

    @Test
    void unknown_command_should_be_ignored() {
        MarsRoverMove marsRover = new MarsRoverMove(0, 0, Direction.NORTH);
        Position newPosition = marsRover.move("aff");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(0, 2, Direction.NORTH));
    }

    @Test
    void unknown_command_should_be_ignored2() {
        MarsRoverMove marsRover = new MarsRoverMove(0, 0, Direction.NORTH);
        Position newPosition = marsRover.move("f f");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(0, 2, Direction.NORTH));
    }

    @Test
    void unknown_command_should_be_ignored3() {
        MarsRoverMove marsRover = new MarsRoverMove(0, 0, Direction.NORTH);
        Position newPosition = marsRover.move("f,f");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(0, 2, Direction.NORTH));
    }

    @Test
    void unknown_command_should_be_ignored4() {
        MarsRoverMove marsRover = new MarsRoverMove(0, 0, Direction.NORTH);
        Position newPosition = marsRover.move("ff;");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(0, 2, Direction.NORTH));
    }

}

