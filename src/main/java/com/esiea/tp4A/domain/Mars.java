package com.esiea.tp4A.domain;

import java.util.HashSet;
import java.util.Set;
import static java.lang.Math.random;
import static java.lang.Math.round;

public class Mars implements PlanetMap{


    private final int size=100;

    public int getSize() {
        return size;
    }

    public int[][] getMars() {
        return mars;
    }

    private final int [][] mars;

    public Mars() {
        this.mars = new int[this.size][this.size];
        int x, y;
        for (y = 0; y < this.size; y++) { for (x = 0; x < this.size; x++) { this.mars[x][y] = 0; } }
        int spawnObstacles= (int) round(0.16*this.size*this.size);
        for(int m=0;m<spawnObstacles;m++) {
            while (true) {
                x = (int) (random() * this.size); y = (int) (random() * this.size);
                if (this.mars[x][y] == 0) {this.mars[x][y] = 1;break;} } } }

    @Override
    public Set<Position> obstaclePositions() {
        Set<Position> positions= new HashSet<>();
        int x,y;
        int offset=1-this.size/2;
        for(y=0;y<this.size;y++){
            for(x=0;x<this.size;x++){
                if(mars[x][y]==1) {positions.add(Position.of(x+offset,y+offset,null));} }
        }
        return positions; }
}
