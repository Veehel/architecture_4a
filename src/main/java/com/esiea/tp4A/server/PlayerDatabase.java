package com.esiea.tp4A.server;


import com.esiea.tp4A.server.Player;

import java.util.HashMap;
import java.util.LinkedList;

public class PlayerDatabase {
    // base de données accessible partout
    private HashMap<String, Player> playerMap;

    public PlayerDatabase() {
        playerMap = new HashMap<String, Player>();
    }

    /**
     * Get the database singleton
     * @return PlayerDatabase
     */
    //public static PlayerDatabase get() { return database;}

    /**
     * Add a player to the database if it doesn't exist
     * @param name : name of player
     * @return Player object
     */
    public Player add(String name) {
        Player p = find(name);
        if(p == null) {
            p = new Player(name);
            // Add the player
            playerMap.put(name, p);
        }

        return p;
    }

    /**
     * Remove a player from the database with his name
     * @param name : name of the player
     */
    public void remove(String name) {
        Player p = playerMap.remove(name);
    }

    /**
     * Remove a player from the database
     * @param p : player object
     */
    public void remove(Player p) {
        playerMap.remove(p.getName());
    }

    /**
     * Finds a player in the database
     * @param name : naoe of the player
     * @return Player object
     */
    public Player find(String name) {
        return playerMap.get(name);
    }
}
