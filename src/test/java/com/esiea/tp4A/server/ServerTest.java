package com.esiea.tp4A.server;

import org.junit.jupiter.api.Test;

public class ServerTest {

    @Test
    void main() throws InterruptedException {
        Runnable main = () -> {
            Server srv = new Server();
            srv.Start();
        };
    }
}
