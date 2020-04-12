package com.esiea.tp4A.domain;

import java.util.List;
import java.util.Objects;

public interface Position {

    int getX();
    int getY();
    Direction getDirection();

    static Position of(int x, int y, Direction direction) {
        return new FixedPosition(x, y, direction);
    }

    Position forwardX();
    Position backwardX();

    final class FixedPosition implements Position {
        private final int x;
        private final int y;
        private final Direction direction;
        public FixedPosition(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        @Override
        public int getX() {
            return x;
        }

        @Override
        public int getY() {
            return y;
        }

        @Override
        public Direction getDirection() {
            return direction;
        }

        public Position forwardX() {
            if (this.x == 50 && this.direction == Direction.EAST) return Position.of(-49, this.getY(), this.getDirection());
            else if (this.x == -49 && this.direction == Direction.WEST) return Position.of(50, this.getY(), this.getDirection());
            else if (this.getDirection() == Direction.EAST) return Position.of(this.getX() +1, this.getY(), this.getDirection());
            else if (this.getDirection() == Direction.WEST) return Position.of(this.getX() -1, this.getY(), this.getDirection());
            return forwardY();
        }

        public Position forwardY() {
            if (this.y == 50 && this.direction == Direction.NORTH) return Position.of(this.getX(), -49, this.getDirection());
            else if (this.y == -49 && this.direction == Direction.SOUTH) return Position.of(this.getX(), 50, this.getDirection());
            else if (this.getDirection() == Direction.NORTH) return Position.of(this.getX(), this.getY() +1, this.getDirection());
            else if (this.getDirection() == Direction.SOUTH); return Position.of(this.getX(), this.getY() -1, this.getDirection());

           // return Position.of(this.getX(), this.getY(), this.getDirection());
        }

        public Position backwardX() {
            if (this.x == -49 && this.direction == Direction.EAST) return Position.of(50, this.getY(), this.getDirection());
            else if (this.x == 50 && this.direction == Direction.WEST) return Position.of(-49, this.getY(), this.getDirection());
            else if (this.getDirection() == Direction.EAST) return Position.of(this.getX() -1, this.getY(), this.getDirection());
            else if (this.getDirection() == Direction.WEST) return Position.of(this.getX() +1, this.getY(), this.getDirection());
            return backwardY();
        }

        public Position backwardY() {
            if (this.y == -49 && this.direction == Direction.NORTH) return Position.of(this.getX(), 50, this.getDirection());
            else if (this.y == 50 && this.direction == Direction.SOUTH) return Position.of(this.getX(), -49, this.getDirection());
            else if (this.getDirection() == Direction.NORTH) return Position.of(this.getX(), this.getY() -1, this.getDirection());
            else if (this.getDirection() == Direction.SOUTH); return Position.of(this.getX(), this.getY() +1, this.getDirection());
            //return Position.of(this.getX(), this.getY(), this.getDirection());
        }

        @Override
        public String toString() {
            return "FixedPosition{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FixedPosition that = (FixedPosition) o;
            return x == that.x &&
                y == that.y &&
                direction == that.direction;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, direction);
        }
    }
}
