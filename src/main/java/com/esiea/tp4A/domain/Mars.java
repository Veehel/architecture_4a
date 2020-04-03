package com.esiea.tp4A.domain;

import java.util.Set;

public class Mars implements PlanetMap{

    public final int xMax;
    public final int xMin;
    public final int yMax;
    public final int yMin;

    public Mars(int xMax, int xMin, int yMax, int yMin) {
        this.xMax = 50;
        this.xMin = -49;
        this.yMax = 50;
        this.yMin = -49;
    }

    @Override
    public Set<Position> obstaclePositions() {
        return null;
    }


}
