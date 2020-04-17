package com.esiea.tp4A.domain;

import java.util.HashSet;
import java.util.Set;

public class MarsRoverMove implements MarsRover {

    private final Position position;
    private final Set<Position> obstacles;
    private final int size=100;
    private int range;
    public MarsRoverMove(int x, int y, Direction direction){
        this.position=Position.of(x,y,direction);
        this.obstacles=new HashSet<>();
        this.range=0;

    }
    public MarsRoverMove(Position position, Set<Position> obstacles,int range){
        this.position= position;
        this.obstacles=obstacles;
        this.range=range;
    }

    @Override
    public MarsRover initialize(Position position){return new MarsRoverMove(position, this.obstacles,this.range);}
    @Override
    public MarsRover updateMap(PlanetMap planetMap){return new MarsRoverMove(this.position,planetMap.obstaclePositions(),this.range);}
    @Override
    public MarsRover configureLaserRange(int range) { return new MarsRoverMove(this.position,this.obstacles,Math.max(range,0)); }
    public Position getPosition(){ return position; }

    public Position move (String command) {
        Position pos=this.position; Position tempo ; boolean shot = false;
        for (char commandLine:command.toCharArray()) { switch (commandLine){
            case 'f' : tempo= getSphericalPos(pos.forwardX());if(isMovementPossible(tempo)){pos=tempo;} break;
            case 'b' : tempo = getSphericalPos(pos.backwardX());if(isMovementPossible(tempo)){pos=tempo;} break;
            case 'l' : pos = Position.of(pos.getX(), pos.getY(), pos.getDirection().left());break;
            case 'r' : pos = Position.of(pos.getX(), pos.getY(), pos.getDirection().right());break;
            case 's' : laserShot(pos); break;
            default: break; }
        }
        return pos;}

    private boolean isMovementPossible(Position position){
        Position position1 = getSphericalPos(position);
        for (Position obs: this.obstacles ){
            Position obsPos=getSphericalPos(obs);
            if(obsPos.getX()==position1.getX() && obsPos.getY()==position1.getY()) {
                return false;
            }
        }return true;
    }

    private Position getSphericalPos(Position position) {
        int x = Math.floorMod(position.getX() - 1 + (size / 2), size) + 1 - (size / 2);
        int y = Math.floorMod(position.getY() - 1 + (size / 2), size) + 1 - (size / 2);
        return Position.of(x, y, position.getDirection());
    }
    private void laserShot(Position position){
        position=getSphericalPos(position); int x=position.getX(); int y=position.getY();
        Direction direction=position.getDirection();
        int xOffSet=direction==Direction.EAST ? 1 : (direction==Direction.WEST ? -1:0);
        int yOffSet=direction==Direction.NORTH ? 1 : (direction==Direction.SOUTH ? -1:0);
        for(int lRange=0;lRange<this.range;lRange++){
            x+= xOffSet; y+=yOffSet;
            Position position1=getSphericalPos(Position.of(x,y,direction));
            if(this.obstacles.removeIf(tmpObst->position1.getY()==getSphericalPos(tmpObst).getY()&&position1.getX()==getSphericalPos(tmpObst).getX())) return;
        }    }


}
