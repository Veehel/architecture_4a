package com.esiea.tp4A.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class PositionTest {

    @Test
    void get_X() {
        Position position = Position.of(0,0,Direction.WEST);
        int x = position.getX();
        Assertions.assertThat(x).isEqualTo(0);
    }

    @Test
    void get_Y() {
        Position position = Position.of(0,0, Direction.WEST);
        int y = position.getY();
        Assertions.assertThat(y).isEqualTo(0);
    }

    @Test
    void get_Direction() {
        Position position = Position.of(0,0, Direction.WEST);
        Direction direction= position.getDirection();
        Assertions.assertThat(direction).isEqualTo(Direction.WEST);
    }

    @Test
    void forward_NORTH(){
        Position position = Position.of(12,13, Direction.NORTH);
        Position newPosition = position.forwardX();
        Assertions.assertThat(newPosition).isEqualTo(Position.of(12, 14, Direction.NORTH));
    }

    @Test
    void backward_NORTH(){
        Position position = Position.of(12,13, Direction.NORTH);
        Position newPosition = position.backwardX();
        Assertions.assertThat(newPosition).isEqualTo(Position.of(12, 12, Direction.NORTH));
    }

    @Test
    void forward_SOUTH(){
        Position position = Position.of(12,13, Direction.SOUTH);
        Position newPosition = position.forwardX();
        Assertions.assertThat(newPosition).isEqualTo(Position.of(12, 12, Direction.SOUTH));
    }

    @Test
    void backward_SOUTH(){
        Position position = Position.of(12,13, Direction.SOUTH);
        Position newPosition = position.backwardX();
        Assertions.assertThat(newPosition).isEqualTo(Position.of(12, 14, Direction.SOUTH));
    }

    @Test
    void forward_EAST(){
        Position position = Position.of(12,13, Direction.EAST);
        Position newPosition = position.forwardX();
        Assertions.assertThat(newPosition).isEqualTo(Position.of(13, 13, Direction.EAST));
    }

    @Test
    void backward_EAST(){
        Position position = Position.of(12,13, Direction.EAST);
        Position newPosition = position.backwardX();
        Assertions.assertThat(newPosition).isEqualTo(Position.of(11, 13, Direction.EAST));
    }

    @Test
    void forward_WEST(){
        Position position = Position.of(12,13, Direction.WEST);
        Position newPosition = position.forwardX();
        Assertions.assertThat(newPosition).isEqualTo(Position.of(11, 13, Direction.WEST));
    }

    @Test
    void backward_WEST(){
        Position position = Position.of(12,13, Direction.WEST);
        Position newPosition = position.backwardX();
        Assertions.assertThat(newPosition).isEqualTo(Position.of(13, 13, Direction.WEST));
    }

    @Test
    void string(){
        Position position = Position.of(12,13, Direction.WEST);
        String stringPosition = position.toString();
        Assertions.assertThat(stringPosition).isEqualTo("FixedPosition{x=12, y=13, direction=WEST" + '}');
    }

    @Test
    void wrong_string(){
        Position position = Position.of(12,13, Direction.WEST);
        String stringPosition = position.toString();
        Assertions.assertThat(stringPosition).isNotEqualTo("FixedPosition{x=12, y=13, direction=NORTH" + '}');
    }


    @Test
    void equals(){
        Position position = Position.of(5,4, Direction.NORTH);
        Assertions.assertThat(position.equals(null)).isFalse();
        Assertions.assertThat(position.equals(Position.of(5,4, Direction.NORTH))).isTrue();//tout est juste
        Assertions.assertThat(position.equals(Position.of(5,4, Direction.SOUTH))).isFalse();//mauvaise direction
        Assertions.assertThat(position.equals(Position.of(-5,4, Direction.NORTH))).isFalse();//mauvais X
        Assertions.assertThat(position.equals(Position.of(5,-4, Direction.NORTH))).isFalse();//mauvais Y
        Assertions.assertThat(position.equals(Position.of(-5,4, Direction.SOUTH))).isFalse();
        Assertions.assertThat(position.equals(Position.of(5,-4, Direction.SOUTH))).isFalse();
        Assertions.assertThat(position.equals(Position.of(-5,-4, Direction.NORTH))).isFalse();
        Assertions.assertThat(position.equals(Position.of(-5,-4, Direction.SOUTH))).isFalse();//tout faux

    }


}
