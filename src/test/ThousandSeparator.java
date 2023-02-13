package test;

public class ThousandSeparator {

	public String thousandSeparator(int n) {
		if (n == 0) {
			return "0";
		}
		StringBuilder result = new StringBuilder();
		int i = 0;
		while (n > 0) {
			if (i != 0 && i % 3 == 0) {
				result.insert(0, ".");
			}
			i++;
			int val = n % 10;
			result.insert(0, val);

			n /= 10;
		}
		return result.toString();
	}
}
