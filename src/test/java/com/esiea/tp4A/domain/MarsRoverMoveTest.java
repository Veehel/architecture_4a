package com.esiea.tp4A.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
    void front_move_north() {
        MarsRoverMove marsRover = new MarsRoverMove(32, 14, Direction.NORTH);
        Position newPosition = marsRover.move("f");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(32, 15, Direction.NORTH));
    }

    @Test
    void front_move_south() {
        MarsRoverMove marsRover = new MarsRoverMove(32, 14, Direction.SOUTH);
        Position newPosition = marsRover.move("f");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(32, 13, Direction.SOUTH));
    }

    @Test
    void front_move_east() {
        MarsRoverMove marsRover = new MarsRoverMove(32, 14, Direction.EAST);
        Position newPosition = marsRover.move("f");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(33, 14, Direction.EAST));
    }

    @Test
    void front_move_west() {
        MarsRoverMove marsRover = new MarsRoverMove(32, 14, Direction.WEST);
        Position newPosition = marsRover.move("f");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(31, 14, Direction.WEST));
    }

    @Test
    void back_move_north() {
        MarsRoverMove marsRover = new MarsRoverMove(32, 14, Direction.NORTH);
        Position newPosition = marsRover.move("b");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(32, 13, Direction.NORTH));
    }

    @Test
    void back_move_south() {
        MarsRoverMove marsRover = new MarsRoverMove(32, 14, Direction.SOUTH);
        Position newPosition = marsRover.move("b");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(32, 15, Direction.SOUTH));
    }

    @Test
    void back_move_east() {
        MarsRoverMove marsRover = new MarsRoverMove(32, 14, Direction.EAST);
        Position newPosition = marsRover.move("b");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(31, 14, Direction.EAST));
    }

    @Test
    void back_move_west() {
        MarsRoverMove marsRover = new MarsRoverMove(32, 14, Direction.WEST);
        Position newPosition = marsRover.move("b");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(33, 14, Direction.WEST));
    }

}

