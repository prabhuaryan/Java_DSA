package Lec_DP;

public class Coin_Change {
	public static void main(String[] args) {
		int[] coins = { 2 };
		int A = 2;
		System.out.println(solve(0, A, coins));
	}

	public static int solve(int idx, int A, int[] coins) {
		if (A < 0) {
			return 0;
		}
		if (A == 0) {
			return 1;
		}
//		BP : solve(idx to coins.lenhth) kitne tariko se you can create amount A
		int sp1 = solve(idx, A - coins[A], coins); // include
		int sp2 = solve(idx + 1, A, coins); // exclude

		return sp1 + sp2;
	}

	public static int solve_2D(int idx, int A, int[] coins, Integer[][] dp) {
		if (A < 0 || idx == coins.length) {
			return 0;
		}
		if (A == 0) {
			return 1;
		}
		if (dp[idx][A] != null) {
			return dp[idx][A];
		}

//		BP : solve(idx to coins.lenhth) kitne tariko se you can create amount A
		int sp1 = solve_2D(idx, A - coins[idx], coins, dp); // include
		int sp2 = solve_2D(idx + 1, A, coins, dp); // exclude

		dp[idx][A] = sp1 + sp2;

		return sp1 + sp2;
	}

	public static int solve_BU(int Amount, int[] coins) {
		int[][] dp = new int[coins.length+1][Amount+1];
		for (int idx = coins.length - 1; idx >= 0; idx--) {
			for (int A = 0; A <= Amount; A++) {
//				dp[idx][A] !! curr!!
				if (A == 0) {
					dp[idx][A] = 1;
					continue;
				}
				int sp1 = 0;
				if (A - coins[idx] >= 0) {
					sp1 = dp[idx][A - coins[idx]]; // include
				}
				
				int sp2 = dp[idx + 1][A]; // exclude
				dp[idx][A] = sp1 + sp2;
			}
		}
		return dp[0][Amount];
	}
}
