package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DecodeMessage {

	public String decodeMessage(String key, String message) {
		Map<Character, Character> mapping = new HashMap<>();
		char cur = 'a';
		for (char aChar : key.toCharArray()) {
			if (aChar != ' ' && !mapping.containsKey(aChar)) {
				mapping.put(aChar, cur++);
			}
		}
		StringBuilder result = new StringBuilder();
		for (char c : message.toCharArray()) {
			Character character = mapping.get(c);
			if (Objects.nonNull(character)){
				result.append(character);
			}else {
				result.append(c);
			}
		}
		return result.toString();
	}
}
