package com.api;

import java.util.HashMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bean.Game;

public class JParser {

	public HashMap<String, Game> getRecentlyPlayedGames(String json) {
		HashMap<String, Game> map = new HashMap<>();
		final ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode;
		try {
			// TODO: add a check to see empty response for recently played games
			rootNode = objectMapper.readValue(json, JsonNode.class);
			if (rootNode.get("response").isEmpty())
				return null;
			int count = rootNode.get("response").get("total_count").asInt();
			for (int i = 0; i < count; i++) {
				String name = rootNode.get("response").get("games").get(i).get("name").asText();
				double hours = rootNode.get("response").get("games").get(i).get("playtime_forever").asDouble() / 60f;
				map.put(name, new Game(name, hours));
			}
			return map;
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return null;
	}

	public long getSteamID(String json) {
		final ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode;
		try {
			rootNode = objectMapper.readValue(json, JsonNode.class);
			if (rootNode.get("response").toString().contains("No match"))
				return -1;
			long STEAM_ID = rootNode.get("response").get("steamid").asLong();
			return STEAM_ID;
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public String getProfileName(String json) {
		final ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode;
		try {
			rootNode = objectMapper.readValue(json, JsonNode.class);
			if (rootNode.get("response").isEmpty())
				return null;
			String name = rootNode.get("response").get("players").get(0).get("personaname").toString().replaceAll("\"", "");
			return name;

		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
