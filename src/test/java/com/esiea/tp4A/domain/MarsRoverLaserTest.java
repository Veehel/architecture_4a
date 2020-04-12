package com.esiea.tp4A.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverLaserTest {
    @ParameterizedTest(name = "{0}, {1}")
    @DisplayName("MarsRover Configure Laser Range")
    @CsvSource({"0, 0", "1, 1", "25, 25", "75, 75", "-1, 0"})
    void configLaserRange(int range,int testRange) throws NoSuchFieldException,IllegalAccessException{
        MarsRover marsRover= new MarsRoverMove();
        MarsRover nmarsRover = marsRover.configureLaserRange(range);
        Field range1=marsRover.getClass().getDeclaredField("range");
        range1.setAccessible(true);

        assertEquals(testRange,range1.get(nmarsRover));
    }
    @ParameterizedTest(name = "{0} ({1}, {2}) {3}")
    @DisplayName("MarsRover Move Obstacle with Laser")
    @CsvSource({"'f', 0, 0, NORTH", "'fflb', 1, 0, WEST", "'rflflf', 1, 1, WEST", "'rflflfrflfrb', 0, 2, NORTH",
        "'sf', 0, 1, NORTH", "'fsflb', 1, 1, WEST", "'rflflsf', 0, 1, WEST", "'bbsfff', 0, 0, NORTH", "'lsrf', 0, 0, NORTH", "'llsb', 0, 0, SOUTH", "'rslf', 0, 0, NORTH",
        "'lsffffsffff', -5, 0, WEST", "'lsffffsfffsf', -6, 0, WEST"})
    void moveObstaclewithLaser(String command, int x, int y, Direction dir) {
        MarsRover marsRover = new MarsRoverMove();
        marsRover = marsRover.initialize(Position.of(0, 0, Direction.NORTH));
        marsRover = marsRover.configureLaserRange(2);

        PlanetMap planetMap=()->{
            HashSet<Position> map= new HashSet<>();
            map.add(Position.of(0,1,null));
            map.add(Position.of(-5,0,null));
            map.add(Position.of(-6,0,null));
            return map;
        };
        marsRover= marsRover.updateMap(planetMap);

        Position position = marsRover.move(command);
        assertEquals(x, position.getX());
        assertEquals(y, position.getY());
        assertEquals(dir, position.getDirection());
    }
}
