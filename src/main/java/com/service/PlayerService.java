package com.service;

import com.api.SteamWeb;
import com.bean.Player;

public class PlayerService {
	SteamWeb st = new SteamWeb();
	
	//grabs the profile or returns -1
    public long getSteamID(String USER_NAME){
        return st.getSteamId(USER_NAME);
    }
    
    public String getProfileName(long STEAM_ID) {
    	return st.getProfileName(STEAM_ID);
    }
    
    //creates a player, populates the games, and then returns a player
    public Player createPlayer(String name, long STEAM_ID)
    {
        Player p1 = new Player(name, STEAM_ID);
        p1.getRecentlyPlayedGames(st.getRecentlyPlayedGames(STEAM_ID));
        return p1;
    }
    
    
}
