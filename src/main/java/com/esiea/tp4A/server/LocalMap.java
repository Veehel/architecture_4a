package com.esiea.tp4A.server;

import com.esiea.tp4A.domain.*;

import java.util.HashSet;

public class LocalMap {
    private final Mars map;
    private HashSet<Player> players;

    public LocalMap() {
        map = new Mars();
        players = new HashSet<Player>();
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public Boolean hasPlayer(Player p) {
        return players.contains(p);
    }

    public void removePlayer(Player p) {
        players.remove(p);
    }

   // public Mars getMap() {return map;}
}
