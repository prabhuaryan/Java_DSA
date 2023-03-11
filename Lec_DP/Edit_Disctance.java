package Lec_DP;

public class Edit_Disctance {
	public static void main(String[] args) {

	}

	public static int Min(int idx1, int idx2, String word1, String word2) {
//		Min(0,0)
		if (idx1 == word1.length()) {
			return word2.length() - idx2;
		}
		if (idx2 == word2.length()) {
			return word1.length() - idx1;
		}

		if (word1.charAt(idx1) == word2.charAt(idx2)) {
			return Min(idx1 + 1, idx2 + 1, word1, word2);
		} else {
			int R = Min(idx1 + 1, idx2 + 1, word1, word2);
			int D = Min(idx1 + 1, idx2, word1, word2);
			int I = Min(idx1, idx2 + 1, word1, word2);

			return Math.min(R, Math.min(D, I)) + 1;
		}
	}

	public static int MinTD(int idx1, int idx2, String word1, String word2, Integer[][] dp) {
//		Min(0,0)
		if (idx1 == word1.length()) {
			return word2.length() - idx2;
		}
		if (idx2 == word2.length()) {
			return word1.length() - idx1;
		}
		if (dp[idx1][idx2] != null) {
			return dp[idx1][idx2];
		}
		if (word1.charAt(idx1) == word2.charAt(idx2)) {
			dp[idx1][idx2] = MinTD(idx1 + 1, idx2 + 1, word1, word2, dp);
			return dp[idx1][idx2];
		} else {
			int R = MinTD(idx1 + 1, idx2 + 1, word1, word2, dp);
			int D = MinTD(idx1 + 1, idx2, word1, word2, dp);
			int I = MinTD(idx1, idx2 + 1, word1, word2, dp);
			dp[idx1][idx2] = Math.min(R, Math.min(D, I)) + 1;
			return Math.min(R, Math.min(D, I)) + 1;
		}
	}

	public static int BU(String word1, String word2) {
		int[][] dp = new int[word1.length()][word2.length()];

		for (int idx1 = word1.length(); idx1 >= 0; idx1--) {
			for (int idx2 = word2.length(); idx2 >= 0; idx2--) {
				if (idx1 == word1.length()) {
					dp[idx1][idx2] = word2.length() - idx2;
					continue;
				}
				if (idx2 == word2.length()) {
					dp[idx1][idx2] = word1.length() - idx1;
					continue;
				}
				
				if (word1.charAt(idx1) == word2.charAt(idx2)) {
					dp[idx1][idx2] = dp[idx1 + 1][idx2 + 1];
				} else {
					int R = dp[idx1 + 1][idx2 + 1];
					int D = dp[idx1 + 1][idx2];
					int I = dp[idx1][idx2 + 1];
					dp[idx1][idx2] = Math.min(R, Math.min(D, I)) + 1;
				}
			}
		}
		return dp[0][0];
	}
	 public int minDistance(String word1, String word2) {
	        int[][] dp = new int[word1.length()+1][word2.length()+1];

			for (int idx1 = word1.length(); idx1 >= 0; idx1--) {
				for (int idx2 = word2.length(); idx2 >= 0; idx2--) {
					if (idx1 == word1.length()) {
						dp[idx1][idx2] = word2.length() - idx2;
						continue;
					}
					if (idx2 == word2.length()) {
						dp[idx1][idx2] = word1.length() - idx1;
						continue;
					}
					
					if (word1.charAt(idx1) == word2.charAt(idx2)) {
						dp[idx1][idx2] = dp[idx1 + 1][idx2 + 1];
					} else {
						int R = dp[idx1 + 1][idx2 + 1];
						int D = dp[idx1 + 1][idx2];
						int I = dp[idx1][idx2 + 1];
						dp[idx1][idx2] = Math.min(R, Math.min(D, I)) + 1;
					}
				}
			}
			return dp[0][0];
		}

}
