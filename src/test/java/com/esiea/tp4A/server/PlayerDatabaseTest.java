package com.esiea.tp4A.server;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerDatabaseTest {
    @Test
    void find_Players() {
        PlayerDatabase db = PlayerDatabase.get();
        Player p = db.add("testPlayer");
        Assertions.assertThat(p.getName()).isEqualTo("testPlayer");
        Assertions.assertThat(db.find("testPlayer") == p);
    }

    @Test
    void null_Players() {
        PlayerDatabase db = PlayerDatabase.get();
        Player p = db.add("testPlayer");
        Assertions.assertThat(p.getName()).isEqualTo("testPlayer");
        Assertions.assertThat(db.find("nullPlayer") == null);
    }


}
