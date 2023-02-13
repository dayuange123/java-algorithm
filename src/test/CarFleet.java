package test;

import java.util.Arrays;
import java.util.Comparator;

public class CarFleet {

	public static class Car {
		private int pos;
		private double t;

		public Car(int pos, double t) {
			this.pos = pos;
			this.t = t;
		}
	}

	public int carFleet(int target, int[] position, int[] speed) {
		int result = 1;
		int last = position.length - 1;
		Car[] cars = new Car[position.length];
		for (int i = 0; i < position.length; i++) {
			cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
		}
		Arrays.sort(cars, Comparator.comparingInt(a -> a.pos));
		for (int i = position.length - 1; i >= 0; i--) {
			//判断是否能追上前面的车 如果不可以result+1
			if (cars[i].t <= cars[last].t) {
				continue;
			}
			last = i;
			result++;
		}
		return result;
	}
}
