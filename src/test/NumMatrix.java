package test;

/**
 * Author: liuzhiyuan
 * Date: 2022/3/21
 * Description:
 */
public class NumMatrix {

	private int[][] matrixSum;

	public NumMatrix(int[][] matrix) {
		matrixSum = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrixSum[i][j] = matrixSum[Math.max(i - 1, 0)][j] + matrix[i][j];
			}
		}

	}


	public int sumRegion(int row1, int col1, int row2, int col2) {

		int sum = 0;
		for (int i = col1; i <= col2; i++) {
			if (row1 == 0) {
				sum += matrixSum[row2][i];
			} else {
				sum += matrixSum[row2][i] - matrixSum[row1 - 1][i];
			}
		}
		return sum;
	}

}
