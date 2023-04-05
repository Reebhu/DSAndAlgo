package com.company;

import java.util.HashMap;
import java.util.Map;

/*
* Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order
		Input: words = ["bella","label","roller"]
		Output: ["e","l","l"]*/
public class MapIntersection {

	public static void main(String[] args) {
		String[] words = {"bdbbbbbbbbbbbbbbella", "labbbel", "rolbler"};
		solve(words);
	}

	public static void solve(String[] words) {
		Map<Character, Integer> valueCount = new HashMap<>();

		for (Character cj : words[0].toCharArray()) {
			valueCount.put(cj, valueCount.getOrDefault(cj, 0) + 1);
		}
		for (String word : words) {
			Map<Character, Integer> valueCount2 = new HashMap<>();
			for (Character cj : word.toCharArray()) {
				if (valueCount.containsKey(cj) && (valueCount2.getOrDefault(cj, 0) + 1) <= valueCount.get(cj)) {
					valueCount2.put(cj, valueCount2.getOrDefault(cj, 0) + 1);
				}
			}
			valueCount = valueCount2;
		}
		for (Map.Entry entry : valueCount.entrySet()) {
			for (int i = 0; i < (int) entry.getValue(); i++) {
				System.out.print(entry.getKey() + " ");
			}

		}
	}
}
