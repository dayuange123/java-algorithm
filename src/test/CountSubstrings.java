package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/23
 * Description:
 */
public class CountSubstrings {
	public int countSubstrings(String s) {


		/**
		 * dp[i][j]=dp[i+1][j-1] &&dp[i]==dp[j]
		 */
		boolean[][] dp = new boolean[s.length()][s.length()];


		int result=0;

		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); ++j) {

				if (i == j) {
					dp[i][j] = true;
				} else if (j - i == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					dp[i][j] = dp[i + 1][j - 1] && dp[i] == dp[j];
				}
				if (dp[i][j]){
					result++;
				}
			}
		}
		return result;
	}

}
