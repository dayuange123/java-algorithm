package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/16
 * Description:
 */
public class AddBinary {
	public static void main(String[] args) {
		System.out.println(new AddBinary().addBinary("1010", "1011"));
	}

	public String addBinary(String a, String b) {
		boolean carry = false;
		int length = Math.max(a.length(), b.length());

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < length; i++) {
			int a1 = 0;
			int b1 = 0;
			if (i < a.length()) {
				a1 = Integer.parseInt(a.charAt(a.length() - i - 1) + "");
			}
			if (i < b.length()) {
				b1 = Integer.parseInt(b.charAt(b.length() - i - 1) + "");
			}
			int sum = (carry ? 1 : 0) + a1 + b1;
			result.append( sum % 2);
			carry = sum >= 2;
		}
		if (carry) {
			result.append( 1);
		}
		return result.reverse().toString();
	}
}
