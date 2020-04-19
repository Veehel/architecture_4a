package com.esiea.tp4A.server;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerDatabaseTest {
    @Test
    void addingPlayers() {
        PlayerDatabase db = new PlayerDatabase();
        Player p = db.add("testPlayer");
        Assertions.assertThat(p.getName()).isEqualTo("testPlayer");
        Assertions.assertThat(db.find("testPlayer") == p);
    }

    @Test
    void removingPlayers() {
        PlayerDatabase db = new PlayerDatabase();
        Player p1 = db.add("testPlayer1");
        Player p2 = db.add("testPlayer2");
        db.remove("testPlayer1");
        db.remove(p2);

        Assertions.assertThat(db.find("testPlayer1")).isNull();
        Assertions.assertThat(db.find("testPlayer2")).isNull();
    }
}
