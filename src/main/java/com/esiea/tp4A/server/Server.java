package com.esiea.tp4A.server;

import com.sun.net.httpserver.*;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    void Start() {
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.createContext("/api/player", new PlayerHttpHandler());
        server.start();
    }
}
