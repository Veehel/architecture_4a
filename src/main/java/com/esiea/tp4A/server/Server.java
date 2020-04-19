package com.esiea.tp4A.server;

import com.sun.net.httpserver.*;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    void Start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);

        server.createContext("/api/player", new PlayerHttpHandler(new PlayerDatabase(), new LocalMap()));
        server.start();
    }
}
