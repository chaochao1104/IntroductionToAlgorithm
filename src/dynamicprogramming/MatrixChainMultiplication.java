package dynamicprogramming;

public class MatrixChainMultiplication {

	private static final int[] dimensions = new int[] { 30, 35, 15, 5, 10, 20, 25 };

	public static void optimalParenthesize(int[] dimensions) {

	}

	/**
	 * 
	 * @param dimensions
	 * @param i range from 1 (included) to j
	 * @param j less than dimensions.length
	 * @return min cost
	 */
	public static int recurOptimalParenthesize(int[] dimensions, int i, int j) {
		if (i == j) {
			return 0;
		}

		int minCost = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int cost = recurOptimalParenthesize(dimensions, i, k)
					+ recurOptimalParenthesize(dimensions, k + 1, j)
					+ dimensions[i-1] * dimensions[k] * dimensions[j];
			minCost = Math.min(minCost, cost);
		}
		return minCost;
	}

	public static void main(String... args) {
		//MatrixChainMultiplication.optimalParenthesize(dimensions);
		int m = MatrixChainMultiplication.recurOptimalParenthesize(dimensions, 1, 6);
		System.out.println("min cost:" + m);
	}
}
