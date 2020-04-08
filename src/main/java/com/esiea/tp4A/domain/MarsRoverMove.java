package com.esiea.tp4A.domain;

import java.io.PipedOutputStream;
import java.util.HashSet;
import java.util.Set;

public class MarsRoverMove implements MarsRover {

    private Position position;
    private Set<Position> obstacles;
    boolean foundObstacle=false;
    private final int size=100;
    public MarsRoverMove(){
        this.position=Position.of(0,0,Direction.NORTH);
        this.obstacles=new HashSet<>();
    }
    public MarsRoverMove(Position position, Set<Position> obstacles){
        this.position= position;
        this.obstacles=obstacles;
    }
    @Override
    public MarsRover initialize(Position position){return new MarsRoverMove(position, this.obstacles);}
   @Override
    public MarsRover updateMap(PlanetMap planetMap){return new MarsRoverMove(this.position,planetMap.obstaclePositions());}
    public Position getPosition(){
        return position;
    }

    public Position move (String command) {
        Position pos=this.position;
        Position tempo;

        for (char commandLine:command.toCharArray()) {
            switch (commandLine){
            /* Ajouter le test si obstacle ici, et sa destruction ensuite */
                case 'f' :
                tempo= pos.forwardX();
                break;
                case 'b' :
                tempo = pos.backwardX();
                break;
                case 'l' :
                tempo = Position.of(pos.getX(), pos.getY(), pos.getDirection().left());// juste un changement de direction
                break;
                case 'r' :
                tempo = Position.of(pos.getX(), pos.getY(), pos.getDirection().right());
                break;
                default:
                    tempo=pos;
                    break;
            }
            tempo=getSphericalPos(tempo);
            if(isMovementPossible(tempo)){
                pos=tempo;
            }
        }
        return pos;
    }
    private boolean isMovementPossible(Position position){
        Position position1 = getSphericalPos(position);
        for (Position obs: this.obstacles ){
            Position obsPos=getSphericalPos(obs);
            if(obsPos.getX()==position1.getX() && obsPos.getY()==position1.getY()) {
            return false;
            }
        }
        return true;
    }
    private Position getSphericalPos(Position position) {
        int x = position.getX();
        int y = position.getY();

        x = Math.floorMod(x - 1 + (size / 2), size) + 1 - (size / 2);
        y = Math.floorMod(y - 1 + (size / 2), size) + 1 - (size / 2);

        return Position.of(x, y, position.getDirection());
    }

  }
