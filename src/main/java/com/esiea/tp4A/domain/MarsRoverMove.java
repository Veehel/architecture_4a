package com.esiea.tp4A.domain;

public class MarsRoverMove {

    private Position position;
    public MarsRoverMove(int x, int y, Direction direction){
        position = Position.of(x,y,direction);
    }


    public Position move (String command){
        if (command.isEmpty()){
            return position;
        }
        char singleCommand = command.charAt(0);
        if ('f' == singleCommand){
            position = Position.of(position.getX(), position.getY() +1, position.getDirection());
        } else if ('b' == singleCommand){
            position = Position.of(position.getX(), position.getY() -1, position.getDirection());
        }
        else if ('l' == singleCommand){
            position = Position.of(position.getX()+1, position.getY() , position.getDirection());
        }
        else if ('r' == singleCommand){
            position = Position.of(position.getX()-1, position.getY() , position.getDirection());
        }
        return position;
    }
  }
