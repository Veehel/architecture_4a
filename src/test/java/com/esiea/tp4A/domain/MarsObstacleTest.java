package com.esiea.tp4A.domain;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MarsObstacleTest {
    @ParameterizedTest(name = "({0}, {1}) {2}")
    @CsvSource({"0, 0, NORTH", "5, 35, SOUTH", "8, 2, EAST", "-5, -15, WEST", "-9,-9, NORTH"})
    void initialize(int x, int y, Direction direction) throws NoSuchFieldException,IllegalAccessException{
        MarsRover marsRover= new MarsRoverMove();
        MarsRover nmarsRover = marsRover.initialize(Position.of(x,y,direction));
        Field pos=marsRover.getClass().getDeclaredField("position");
        pos.setAccessible(true);
        Position position= (Position) pos.get(nmarsRover);
        assertEquals(x,position.getX());
        assertEquals(y,position.getY());
        assertEquals(direction,position.getDirection());
    }
    @Test
    void moveObstacles(){
        MarsRover nmarsRover=new MarsRoverMove();
        MarsRover marsRover = nmarsRover.initialize(Position.of(0, 0, Direction.NORTH));
       // marsRover.configureLaserRange(0);
        PlanetMap planetMap=()->{
            HashSet<Position> map= new HashSet<>();
            map.add(Position.of(0,1,null));
            map.add(Position.of(-5,0,null));
            map.add(Position.of(-6,0,null));
            return map;
        };
        marsRover= marsRover.updateMap(planetMap);
        Position nposition = marsRover.move("fflb");
        Assertions.assertThat(nposition).isEqualTo(Position.of(1, 0, Direction.WEST));
    }

    @Test
    void updateMap() throws NoSuchFieldException,IllegalAccessException{
        MarsRover marsRover = new MarsRoverMove();
        PlanetMap planetMap = new Mars();
        MarsRover nMarsRover = marsRover.updateMap(planetMap);
        Set<Position> obstacles= planetMap.obstaclePositions();

        final Field fObstacle=marsRover.getClass().getDeclaredField("obstacles");
        fObstacle.setAccessible(true);
        Set<Position> positionSet= (Set<Position>) fObstacle.get(nMarsRover);
        assertEquals(obstacles.size(),positionSet.size());
        for (Position obst: obstacles){
            Iterator<Position> iterator=positionSet.iterator();
            while (iterator.hasNext()){
                Position pos=iterator.next();
                if(obst.getX()==pos.getX() && obst.getY()==pos.getY() && obst.getDirection()==pos.getDirection()) {
                    iterator.remove();
                    break;
                }
            }
        }
        assertEquals(0,positionSet.size());
    }
}
