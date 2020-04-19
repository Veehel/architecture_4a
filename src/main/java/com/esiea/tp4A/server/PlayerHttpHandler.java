package com.esiea.tp4A.server;

import com.esiea.tp4A.domain.*;
import com.sun.net.httpserver.*;
import com.google.gson.*;
import java.io.IOException;
import java.net.*;

public class PlayerHttpHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        String beginArgs = path.substring("/api/player/".length());
        String args[] = beginArgs.split("/");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        switch(exchange.getRequestMethod()) {
            case "GET":handleGet(exchange, gson, args);break;
            case "POST":handlePost(exchange, gson, args);break;
            case "PATCH":handlePatch(exchange, gson, args);break;
        } }

    public void handleGet(HttpExchange exchange, Gson gson, String args[]) throws IOException {
        String playerName = args[0];
        Player p = PlayerDatabase.get().find(playerName);
        if(p == null) { jsonError(exchange, gson, 404, "Joueur inexistant");return; }
        JsonObject json = new JsonObject();
        json.add("player", gson.toJsonTree(p));
        LocalMap localMap = LocalMap.get();
        json.add("local-map", gson.toJsonTree(localMap));
        sendJson(exchange, gson, json);
    }

    public void handlePost(HttpExchange exchange, Gson gson, String args[]) throws IOException {
        String playerName = args[0];
        Player p = PlayerDatabase.get().find(playerName);
        if(p != null) { jsonError(exchange, gson, 409, "Le joueur existe déjà"); return; }
        p = PlayerDatabase.get().add(playerName);
        JsonObject json = new JsonObject();
        json.add("player", gson.toJsonTree(p));
        LocalMap localMap = LocalMap.get(); localMap.addPlayer(p);
        json.add("local-map", gson.toJsonTree(localMap));
        sendJson(exchange, gson, json); }

    public void handlePatch(HttpExchange exchange, Gson gson, String args[]) throws IOException {
        String playerName = args[0];
        Player p = PlayerDatabase.get().find(playerName);
        if(p == null) { jsonError(exchange, gson, 404, "Joueur inexistant"); return; }
        String command = args[1];
        Position newPos = p.getRover().move(command); p.setRover(p.getRover().initialize(newPos));
        JsonObject json = new JsonObject(); json.add("player", gson.toJsonTree(p));
        LocalMap localMap = LocalMap.get();
        json.add("local-map", gson.toJsonTree(localMap));
        sendJson(exchange, gson, json); }

    void sendJson(HttpExchange exchange, Gson gson, JsonObject json) throws IOException {
        exchange.sendResponseHeaders(200, 0);
        exchange.getResponseBody().write(gson.toJson(json).getBytes());
        exchange.getResponseBody().close();
    }

    public void jsonError(HttpExchange exchange, Gson gson, int errorCode, String error) throws IOException {
        JsonObject json = new JsonObject();
        json.addProperty("errorString", error);
        exchange.sendResponseHeaders(errorCode, 0);
        exchange.getResponseBody().write(gson.toJson(json).getBytes());
        exchange.getResponseBody().close();
    }
}
