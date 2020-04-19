package com.esiea.tp4A.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ServerTest {
    @Test
    void testServer() {
        Server server = new Server();
        try {
            server.Start();
        } catch (IOException e) {
            Assertions.assertTrue(false);
        }
    }
}
