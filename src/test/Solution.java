package test;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * <p>
 * 1 2 3
 * 4 5
 * <p>
 * 1 2
 * 3 4
 * 输入：n = 1
 * 输出：[[1]]
 */
class Solution {
	public static void main(String[] args) {
		int[][] ints = new Solution().generateMatrix(1);
		for (int[] anInt : ints) {
			for (int i : anInt) {
				System.out.println(i);
			}
		}
	}

	public int[][] generateMatrix(int n) {
		int x = 0;
		int y = 0;
		int[][] arr = new int[n][n];
		int val = 1;
		int current = 0;
		while (val <= n*n) {
			arr[x][y] = val++;
			if (current == 0) {
				if (y + 1 == n || arr[x][y + 1] != 0) {
					current = 1;

					x++;
				} else {
					y++;
				}
			} else if (current == 1) {
				if (x + 1 == n || arr[x + 1][y] != 0) {
					current = 2;
					y--;
				} else {
					x++;
				}
			} else if (current == 2) {
				if (y == 0 || arr[x][y - 1] != 0) {
					current = 3;
					x--;
				} else {
					y--;
				}
			} else {
				if (x == 0 || arr[x - 1][y] != 0) {
					current = 0;
					y++;
				} else {
					x--;
				}
			}
		}
		return arr;
	}
}