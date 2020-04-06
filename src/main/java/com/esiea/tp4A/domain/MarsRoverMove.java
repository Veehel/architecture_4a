package com.esiea.tp4A.domain;

public class MarsRoverMove {

    private Position position;

    public MarsRoverMove(int x, int y, Direction direction){
        position = Position.of(x,y,direction);
    }


    public Position move (String command){
        if (command.isEmpty()){ return position;}
        char singleCommand = command.charAt(0);
        if ('f' == singleCommand){position = front();}
        else if ('b' == singleCommand){position = back();}
        else if ('l' == singleCommand){position = left();}
        else if ('r' == singleCommand){position = right();}
        return position;
    }

    public Position front(){
        if(position.getY() +1>50){position = Position.of(position.getX(),-49,position.getDirection());        }
        else {position = Position.of(position.getX(),position.getY() +1,position.getDirection());}
        return position;
    }

    public Position back(){
        if(position.getY() -1<-49){position = Position.of(position.getX(),50,position.getDirection());}
        else {position = Position.of(position.getX(),position.getY() -1,position.getDirection());}
        return position;
    }

    public Position left(){
        if(position.getX() +1>50){position = Position.of(-49, position.getY() , position.getDirection());}
        else {position = Position.of(position.getX()+1, position.getY() , position.getDirection());}
        return position;
    }

    public Position right(){
        if(position.getX() -1<-49){position = Position.of(50,position.getY(),position.getDirection());}
        else {position = Position.of(position.getX()-1,position.getY(),position.getDirection());}
        return position;
    }

}
