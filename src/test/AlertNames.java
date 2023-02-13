package test;

import java.util.*;

public class AlertNames {


	public List<String> alertNames1(String[] keyName, String[] keyTime) {

		Map<String, Map<Integer, Set<Integer>>> dataMap = new HashMap<>();
		for (int i = 0; i < keyName.length; i++) {
			Map<Integer, Set<Integer>> map = dataMap.get(keyName[i]);
			if (map == null) {
				map = new HashMap<>();
			}
			dataMap.put(keyName[i], map);
			String[] split = keyTime[i].split(":");
			int hour = Integer.parseInt(split[0]);
			int minute = Integer.parseInt(split[1]);
			Set<Integer> hourList = map.get(hour);
			if (hourList == null) {
				hourList = new HashSet<>();
			}
			map.put(hour, hourList);
			hourList.add(minute);
		}

		Map<String, Map<Integer, int[]>> dataMap1 = new HashMap<>();
		for (String s : dataMap.keySet()) {
			Map<Integer, Set<Integer>> map = dataMap.get(s);
			Map<Integer, int[]> map1 = new HashMap<>();
			for (Integer hour : map.keySet()) {
				Set<Integer> minutes = map.get(hour);
				int[] array = new int[60];
				for (int i = 0; i < 60; i++) {
					array[i] = minutes.contains(i) ? 1 : 0;
					if (i != 0) {
						array[i] += array[i - 1];
					}
				}
				map1.put(hour, array);
			}
			dataMap1.put(s, map1);
		}
		List<String> result = new ArrayList<>();
		for (String s : dataMap.keySet()) {
			Map<Integer, Set<Integer>> integerSetMap = dataMap.get(s);
			Map<Integer, int[]> integerMap = dataMap1.get(s);

			for (Integer k : integerSetMap.keySet()) {
				Set<Integer> v = integerSetMap.get(k);
				int[] next = integerMap.get(k + 1);
				int[] cur = integerMap.get(k);

				for (Integer integer : v) {
					int nextVal = (next == null ? 0 : next[integer]);
					if (cur[59] - cur[integer] + 1 + nextVal >= 3) {
						result.add(s);
						break;
					}
				}
				if (result.contains(s)) {
					break;
				}
			}
		}
		result.sort(Comparator.naturalOrder());
		return result;
	}


	//滑动窗口
	public List<String> alertNames(String[] keyName, String[] keyTime) {
		Map<String, List<Integer>> dataMap = new HashMap<>();
		for (int i = 0; i < keyName.length; i++) {
			dataMap.putIfAbsent(keyName[i], new ArrayList<>());
			String[] split = keyTime[i].split(":");
			dataMap.get(keyName[i]).add(Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]));
		}
		List<String> result = new ArrayList<>();
		for (String name : dataMap.keySet()) {
			List<Integer> integers = dataMap.get(name);
			if (integers.size() < 3) {
				break;
			}
			Collections.sort(integers);
			int left = 0, rift = 2;
			while (rift < integers.size()) {
				if (integers.get(rift) - integers.get(left) > 60) {
					left++;
				} else {
					if (rift - left + 1 >= 3) {
						result.add(name);
						break;
					}
					rift++;
				}
			}
		}
		Collections.sort(result);
		return result;
	}
}
