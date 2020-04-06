package com.esiea.tp4A.domain;

import java.util.Set;

public class Mars implements PlanetMap{

    private final int xMax;
    private final int xMin;
    private final int yMax;
    private final int yMin;

    public Mars() {
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
