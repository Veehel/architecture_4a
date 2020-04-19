package com.esiea.tp4A.server;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocalMapTest {
    @Test
    void getLocalMap() {
        Assertions.assertThat(LocalMap.get()).isNotNull();
    }

    @Test
    void players() {
        Player p = new Player("test");
        LocalMap.get().addPlayer(p);
        Assertions.assertThat(LocalMap.get().hasPlayer(p)).isTrue();
    }
}
