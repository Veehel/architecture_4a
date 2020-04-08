package com.esiea.tp4A.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxPositionTest {
    @Test
    void front_move_north_max() {
        MarsRover nmarsRover=new MarsRoverMove();
        MarsRover marsRover = nmarsRover.initialize(Position.of(32, 50, Direction.NORTH));
        Position newPosition = marsRover.move("f");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(32, -49, Direction.NORTH));
    }

    @Test
    void front_move_south_max() {
        MarsRover nmarsRover=new MarsRoverMove();
        MarsRover marsRover = nmarsRover.initialize(Position.of(32, -49, Direction.SOUTH));
        Position newPosition = marsRover.move("f");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(32, 50, Direction.SOUTH));
    }

    @Test
    void front_move_east_max() {
        MarsRover nmarsRover=new MarsRoverMove();
        MarsRover marsRover = nmarsRover.initialize(Position.of(50, 14, Direction.EAST));
        Position newPosition = marsRover.move("f");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(-49, 14, Direction.EAST));
    }

    @Test
    void front_move_west_max() {
        MarsRover nmarsRover=new MarsRoverMove();
        MarsRover marsRover = nmarsRover.initialize(Position.of(-49, 14, Direction.WEST));
        Position newPosition = marsRover.move("f");
        Assertions.assertThat(newPosition).isEqualTo(Position.of(50, 14, Direction.WEST));
    }

}
