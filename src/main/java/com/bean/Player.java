package com.bean;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private long STEAM_ID;
    private Map<String, Game> games;
    
    //constructor
    public Player(String name, long STEAM_ID) {
        this.name = name;
        this.STEAM_ID = STEAM_ID;
        games = new HashMap<>();
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return STEAM_ID;
    }

    public void setId(int STEAM_ID) {
        this.STEAM_ID = STEAM_ID;
    }

    //get, add, remove, update, and find games
    public Game getGame(String name){
        if(games.containsKey(name))
            return games.get(name);
        else
            return null;
    }
    public void addGame(Game game){
        games.put(game.getName(), game);
    }

    public void removeGame(String name){
        games.remove(name);
    }

    public void updateGameHours(String name, double hours){
        Game g = findGame(name);
        g.setHours(hours);
    }

    public Game findGame(String name)
    {
        if(games.containsKey(name))
            return games.get(name);
        else 
            return null;
    }
    public void getRecentlyPlayedGames(HashMap<String,Game> games)
    {
        this.games = games;
    }
    
    public Map<String, Game> getGames() {
    	return this.games;
    }
    @Override
    public String toString(){
        String res = "Name: " + name + "\n" +
                    "Steam ID: " + STEAM_ID + "\n" + 
                    "\n" + "Recent Games" + "\n" +
                    "--------------------------------" +"\n";
        if(this.games == null)
            res = res + "No Recent Games";
         else{   
            for(HashMap.Entry e: games.entrySet()){
                res = res + e.getValue().toString()+"\n";
            }
        }

        return res;
    }
    
}
