package com.esiea.tp4A.server;

import com.esiea.tp4A.domain.*;

import java.util.HashSet;

public class LocalMap {
    static LocalMap localMap = new LocalMap();
    private Mars map;
    private HashSet<Player> players;

    private LocalMap() {
        map = new Mars();
        players = new HashSet<Player>();
    }

    public static LocalMap get() {
        return localMap;
    }

    void addPlayer(Player p) {
        players.add(p);
    }

    Boolean hasPlayer(Player p) {
        return players.contains(p);
    }

   /* void removePlayer(Player p) {
        players.remove(p);
    }

    Mars getMap() {
        return map;
    }
    */
}
