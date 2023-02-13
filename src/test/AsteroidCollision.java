package test;

import java.util.LinkedList;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/29
 * Description:
 */
public class AsteroidCollision {

	public static void main(String[] args) {
		new AsteroidCollision().asteroidCollision(new int[]{5, 10, -5});
	}

	public int[] asteroidCollision(int[] asteroids) {


		LinkedList<Integer> linkedList = new LinkedList<>();


		for (int i = 0; i < asteroids.length; i++) {
			if (asteroids[i] > 0) {
				linkedList.add(asteroids[i]);
				continue;
			}
			if (linkedList.isEmpty() || linkedList.peekLast() < 0) {
				linkedList.add(asteroids[i]);
				continue;
			}
			while (!linkedList.isEmpty()) {
				Integer integer = linkedList.peekLast();
				if (integer < 0) {
					linkedList.add(asteroids[i]);
					break;
				}
				if (integer > -asteroids[i]) {
					break;
				} else if (integer == -asteroids[i]) {
					linkedList.pollLast();
					break;
				} else {
					linkedList.pollLast();
					if (linkedList.isEmpty()) {
						linkedList.add(asteroids[i]);
						break;
					}
				}
			}
		}
		int[] res = new int[linkedList.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = linkedList.pollFirst();
		}
		return res;
	}
}
