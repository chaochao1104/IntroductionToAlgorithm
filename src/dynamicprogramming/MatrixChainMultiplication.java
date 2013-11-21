package dynamicprogramming;

public class MatrixChainMultiplication {

	private static final int[] dimensions = new int[] { 30, 35, 15, 5, 10, 20, 25, 34, 2, 3, 55, 54 };

	public static void optimalParenthesize(int[] dimensions) {
		int[][] ktab = new int[dimensions.length][dimensions.length];
		int[][] ctab = new int[dimensions.length][dimensions.length];
		
		for (int d = 1; d < dimensions.length; d++) {
			for (int i = 1; i + d < dimensions.length; i++) {
				int minCost = Integer.MAX_VALUE;
				int minK = -1;
				int j = i + d;
				for (int k = i; k < i + d; k++) {
					int cost = ctab[i][k] + ctab[k + 1][j]
							+ dimensions[i - 1] * dimensions[k]	* dimensions[j];
					if (cost < minCost) {
						minCost = cost;
						minK = k;
					}
				}
				ctab[i][j] = minCost;
				ktab[i][j] = minK;
			}
		}

		for (int[] row : ctab) {
			for (int c : row) {
				System.out.print(c + "|");
			}
			System.out.println();
		}
		System.out.println("-------------------------------------");
		for (int[] row : ktab) {
			for (int k : row) {
				System.out.print(k + "|");
			}
			System.out.println();
		}
		System.out.println("-------------------------------------");
		System.out.print("Optimal Parenthesized:");
		prt(ktab, 1, dimensions.length - 1);
	}
	
	private static void prt(int[][] ktab, int i, int j) {
		if (i == j) {
			System.out.print("A" + i);
		} else {
			System.out.print('(');
			prt(ktab, i, ktab[i][j]);
			prt(ktab, ktab[i][j] + 1, j);
			System.out.print(')');
		}
	}

	/**
	 * 
	 * @param dimensions
	 * @param i
	 *            range from 1 (included) to j
	 * @param j
	 *            less than dimensions.length
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
					+ dimensions[i - 1] * dimensions[k] * dimensions[j];
			minCost = Math.min(minCost, cost);
		}
		return minCost;
	}

	public static void main(String... args) {
		int m = MatrixChainMultiplication.recurOptimalParenthesize(dimensions,
				1, dimensions.length - 1);
		System.out.println("min cost:" + m);
		
		MatrixChainMultiplication.optimalParenthesize(dimensions);
	}
}
