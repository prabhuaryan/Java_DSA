package Lec_DP;

public class Basic {
	public static void main(String[] args) {
//		System.out.println(Fibo(5));
		int n = 10000000;
//		System.out.println(FiboTD(n, new Integer[n+1]));
		System.out.println(FiboBU(n));
	}

	public static int Fibo(int n) {
		if (n <= 1) {
			return n;
		}
		int sp1 = Fibo(n - 1);
		int sp2 = Fibo(n - 2);
		return sp1 + sp2;
	}

	public static int FiboTD(int n, Integer[] dp) {
		if (n <= 1) {
			return n;
		}
		if (dp[n] != null) {
			return dp[n];
		}
		int sp1 = FiboTD(n - 1, dp);
		int sp2 = FiboTD(n - 2, dp);
//		dp[n] index par Fibo(n)!!
		dp[n] = sp1 + sp2;

		return sp1 + sp2;
	}

	// Bottums up!!
	public static int FiboBU(int num) {
		int[] dp = new int[num + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int n = 2; n <= num; n++) {
//			 dp[n] solution!!
//			 curr: dp[n]// Fibo(n)
			int sp1 = dp[n - 1];
			int sp2 = dp[n - 2];
//				dp[n] index par Fibo(n)!!
			dp[n] = sp1 + sp2;

		}
		return dp[num];
	}
}
