package com.esiea.tp4A.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DirectionTest {

    @Test
    void direction_left() {
        Direction direction=Direction.EAST;
        Direction newDirection = direction.left();
        Assertions.assertThat(newDirection).isEqualTo(Direction.NORTH);
    }

    @Test
    void direction_right() {
        Direction direction=Direction.EAST;
        Direction newDirection = direction.right();
        Assertions.assertThat(newDirection).isEqualTo(Direction.SOUTH);
    }

    @Test
    void direction_left_max() {
        Direction direction=Direction.NORTH;
        Direction newDirection = direction.left();
        Assertions.assertThat(newDirection).isEqualTo(Direction.WEST);
    }

    @Test
    void direction_right_max() {
        Direction direction=Direction.WEST;
        Direction newDirection = direction.right();
        Assertions.assertThat(newDirection).isEqualTo(Direction.NORTH);
    }
}
