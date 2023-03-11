package Lec_DP;

public class Climb_Stairs {
	public static void main(String[] args) {
		System.out.println(climbStairs(3));
	}

	public static int climbStairs(int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		int sp1 = climbStairs(n - 1);
		int sp2 = climbStairs(n - 2);
		return sp1 + sp2;
	}

	public static int climbStairsTD(int n, Integer[] dp) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if(dp[n]!=null) {
			return dp[n];
		}
		int sp1 = climbStairsTD(n - 1, dp);
		int sp2 = climbStairsTD(n - 2, dp);
		dp[n] = sp1 + sp2;
		return sp1 + sp2;
	}
	public int climbStairsBU(int num) {
        // Integer[] dp = new Integer[num+1];
        // return climbStairsTD(num, dp);
        int[] dp = new int[num+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int n = 2;n<=num;n++){
            // dp[n]!!
            int sp1 = dp[n - 1];
            int sp2 = dp[n - 2];
            dp[n] = sp1 + sp2;
        }
        return dp[num];

	}
}
