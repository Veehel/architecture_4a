package com.esiea.tp4A.server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Server srv = new Server();
        try {
            srv.Start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
