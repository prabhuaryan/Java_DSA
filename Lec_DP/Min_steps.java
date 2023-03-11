package Lec_DP;

public class Min_steps {
	public static void main(String[] args) {

	}

	public static int solve(int n) {
		if (n == 1) {
			return 0;
		}
		if (n % 2 == 0) {
			int ans = solve(n / 2) + 1;
			return ans;
		} else {
			int sp1 = solve(n + 1);
			int sp2 = solve(n - 1);
			return Math.min(sp1, sp2) + 1;
		}
	}

	public static int solveTD(int n, Integer[] dp) {
		if (n == 1) {
			return 0;
		}
		if (dp[n] != null) {
			return dp[n];
		}
		if (n % 2 == 0) {
			int ans = solveTD(n / 2, dp) + 1;
			dp[n] = ans;

			return ans;
		} else {
			int sp1 = solveTD(n + 1, dp);
			int sp2 = solveTD(n - 1, dp);
			dp[n] = Math.min(sp1, sp2) + 1;
			return Math.min(sp1, sp2) + 1;
		}
	}

	public static int BU(int num) {
		int[] dp = new int[num+1];
		for (int n = 2; n <= num; n++) {
//			dp[n]
			if (n % 2 == 0) {
				int ans = dp[n / 2] + 1;
				dp[n] = ans;

			} else {
				int sp1 = dp[(n + 1) / 2] + 1;
				int sp2 = dp[n - 1];
				dp[n] = Math.min(sp1, sp2) + 1;
			}
		}
		return dp[num];
	}
}
