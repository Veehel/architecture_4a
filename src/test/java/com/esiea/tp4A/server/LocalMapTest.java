package com.esiea.tp4A.server;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocalMapTest {
    @Test
    void players() {
        Player p = new Player("test");
        LocalMap localMap = new LocalMap();
        localMap.addPlayer(p);
        Assertions.assertThat(localMap.hasPlayer(p)).isTrue();
        localMap.removePlayer(p);
        Assertions.assertThat(localMap.hasPlayer(p)).isFalse();
    }
}
