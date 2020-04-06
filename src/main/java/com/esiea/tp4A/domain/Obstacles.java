package com.esiea.tp4A.domain;

public class Obstacles {

    private int x;
    private int getX(){
        return  x;
    }

    public void setX(int x) {
        this.x = x;
    }
    private int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Obstacles (final int xValues, final int yValues){
        setX(xValues);
        setY(yValues);
    }
}
