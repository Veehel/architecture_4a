package com.esiea.tp4A.domain;

import java.util.HashSet;
import java.util.Set;
import java.lang.Math;

import static java.lang.Math.random;
import static java.lang.Math.round;

public class Mars implements PlanetMap{

<<<<<<< HEAD
    public final int xMax;
    public final int xMin;
    public final int yMax;
    public final int yMin;
    public final int size=100;
    public final int [][] mars;
=======
    private final int xMax;
    private final int xMin;
    private final int yMax;
    private final int yMin;

>>>>>>> ac323c1... limit move and them tests
    public Mars() {
        this.xMax = 50;
        this.xMin = -49;
        this.yMax = 50;
        this.yMin = -49;
        this.mars = new int[this.size][this.size];
        int x, y;

        for (y = 0; y < this.size; y++) {
            for (x = 0; x < this.size; x++) {
                this.mars[y][x] = 0;
            }
        }
        int spawnObstacles= (int) round(0.16*this.size*this.size);
        for(int m=0;m<spawnObstacles;m++) {
            while (true) {
                x = (int) (random() * this.size);
                y = (int) (random() * this.size);

                if (this.mars[y][x] == 0) {
                    this.mars[y][x] = 1;
                    break;
                }
            }
        }
    }

    @Override
    public Set<Position> obstaclePositions() {
        Set<Position> positions= new HashSet<>();
        int x,y;
        int offset=1-this.size/2;

        for(y=0;y<this.size;y++){
            for(x=0;x<this.size;x++){
                if(mars[x][y]==1) {positions.add(Position.of(x+offset,y+offset,null));}
            }
        }
        return positions;
    }
}
