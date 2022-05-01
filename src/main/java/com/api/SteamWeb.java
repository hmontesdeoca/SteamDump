package com.api;

import java.util.HashMap;

import com.HTTP.Requester;
import com.bean.Game;

public class SteamWeb{
  //JSON parser
  JParser jp = new JParser();
  //requester for http requests
  Requester req = new Requester();
  //API key to access steam
  final String STEAM_API_KEY = System.getenv("STEAM_API_KEY");
  //finds user based on name
  public long getSteamId(String USER_NAME) {
    String URL="http://api.steampowered.com/ISteamUser/ResolveVanityURL/v0001/?key="+
                STEAM_API_KEY+"&vanityurl="+USER_NAME;
    String json = req.getSync(URL);            
    return jp.getSteamID(json);
  }
  //gets steam profile
  //TODO: convert for additional features (see get profile method in JSON PARSER)
  public String getProfileName(long STEAM_ID){
    String URL="http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key="+
                STEAM_API_KEY+"&steamids="+STEAM_ID;
    String json = req.getSync(URL);
    return jp.getProfileName(json);
  }

  public HashMap<String, Game> getRecentlyPlayedGames(long STEAM_ID){
    String URL="http://api.steampowered.com/IPlayerService/GetRecentlyPlayedGames/v0001/?key="+
                STEAM_API_KEY+"&steamid="+STEAM_ID+"&format=json";
    String json = req.getSync(URL);
    return jp.getRecentlyPlayedGames(json);
  }
}
