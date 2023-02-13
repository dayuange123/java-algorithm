package test;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
	Map<String, Integer> currentMap = new HashMap<>();
	int timeToLive;

	public AuthenticationManager(int timeToLive) {

		this.timeToLive = timeToLive;
	}

	public void generate(String tokenId, int currentTime) {

		currentMap.put(tokenId, timeToLive + currentTime);
	}

	public void renew(String tokenId, int currentTime) {
		Integer integer = currentMap.get(tokenId);
		if (integer == null) {
			return;
		}
		if (integer <= currentTime) {
			currentMap.remove(tokenId);
			return;
		}
		currentMap.put(tokenId, timeToLive + currentTime);

	}

	public int countUnexpiredTokens(int currentTime) {
		currentMap.values().removeIf(rec -> rec <= currentTime);
		return currentMap.size();
	}
}
