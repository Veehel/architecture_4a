package com.esiea.tp4A.domain;

public class MarsRoverMove {

    private Position position;
    public MarsRoverMove(int x, int y, Direction direction){
        position = Position.of(x,y,direction); // initialize
    }

    public Position getPosition(){
        return position;
    }

    public Position move (String command) {
        // if (command.isEmpty()) { return position; } plus besoin
        for (int i = 0; i < command.length(); i++) {
            char singleCommand = command.charAt(i);
            /* Ajouter le test si obstacle ici, et sa destruction ensuite */
            if ('f' == singleCommand) {
                position = position.forwardX();
            } else if ('b' == singleCommand) {
                position = position.backwardX();
            } else if ('l' == singleCommand) {
                position = Position.of(position.getX(), position.getY(), position.getDirection().left());
            } // juste un changement de direction
            else if ('r' == singleCommand) {
                position = Position.of(position.getX(), position.getY(), position.getDirection().right());
            }
        }
        return position;
    }


  }
