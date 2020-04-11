package com.esiea.tp4A.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MarsMoveDirectionTest {

    @Test
    void right_move() {
        MarsRover nmarsRover=new MarsRoverMove();
        MarsRover marsRover = nmarsRover.initialize(Position.of(-23, 18, Direction.NORTH));
        Position newPosition = marsRover.move("r");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(-23, 18, Direction.EAST));
    }


    @Test
    void left_move() {
        MarsRover nmarsRover=new MarsRoverMove();
        MarsRover marsRover = nmarsRover.initialize(Position.of(-23, 18, Direction.NORTH));
        Position newPosition = marsRover.move("l");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(-23, 18, Direction.WEST));
    }

    @Test
    void complex_moves_from_different_origin() {
        MarsRover nmarsRover=new MarsRoverMove();
        MarsRover marsRover = nmarsRover.initialize(Position.of(0, 0, Direction.NORTH));
        Position newPosition = marsRover.move("ff");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(0, 2, Direction.NORTH));
    }

    @Test
    void complex_moves_from_different_origin2() {
        MarsRover nmarsRover=new MarsRoverMove();
        MarsRover marsRover = nmarsRover.initialize(Position.of(0, 0, Direction.NORTH));
        Position newPosition = marsRover.move("lbblffr");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(2, -2, Direction.WEST));
    }

    @Test
    void unknown_command_should_be_ignored() {
        MarsRover nmarsRover=new MarsRoverMove();
        MarsRover marsRover = nmarsRover.initialize(Position.of(0, 0, Direction.NORTH));
        Position newPosition = marsRover.move("aff");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(0, 2, Direction.NORTH));
    }

    @Test
    void unknown_command_should_be_ignored2() {
        MarsRover nmarsRover=new MarsRoverMove();
        MarsRover marsRover = nmarsRover.initialize(Position.of(0, 0, Direction.NORTH));
        Position newPosition = marsRover.move("f f");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(0, 2, Direction.NORTH));
    }

    @Test
    void unknown_command_should_be_ignored3() {
        MarsRover nmarsRover=new MarsRoverMove();
        MarsRover marsRover = nmarsRover.initialize(Position.of(0, 0, Direction.NORTH));
        Position newPosition = marsRover.move("f,f");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(0, 2, Direction.NORTH));
    }

    @Test
    void unknown_command_should_be_ignored4() {
        MarsRover nmarsRover=new MarsRoverMove();
        MarsRover marsRover = nmarsRover.initialize(Position.of(0, 0, Direction.NORTH));
        Position newPosition = marsRover.move("ff;");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(0, 2, Direction.NORTH));
    }

}
