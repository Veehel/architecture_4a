package com.esiea.tp4A.server;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.MarsRover;
import com.esiea.tp4A.domain.MarsRoverMove;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    void getName() {
        Player p = new Player("test");
        Assertions.assertThat(p.getName()).isEqualTo("test");
    }

    @Test
    void getRover() {
        MarsRoverMove marsRover = new MarsRoverMove(0, 0, Direction.NORTH);
        Player p = new Player("test");
        p.setRover(marsRover);
        Assertions.assertThat(p.getRover() == marsRover);
    }
    
    @Test
    void new_player_status(){
        Player player = new Player("name");
        Assertions.assertThat(player.status).isEqualTo(PlayerStatus.alive);
    }

}
