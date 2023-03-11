package Lec_DP;

import java.util.ArrayList;

public class LCS {
	
//		https://leetcode.com/problems/house-robber/
//		https://leetcode.com/problems/house-robber-ii/
//		https://leetcode.com/problems/minimum-path-sum
//		https://leetcode.com/problems/target-sum/
//		https://leetcode.com/problems/target-sum/
//
//		https://leetcode.com/problems/distinct-subsequences/
//		https://leetcode.com/problems/longest-common-subsequence/
//		https://leetcode.com/problems/uncrossed-lines/
//		https://leetcode.com/problems/max-dot-product-of-two-subsequences/
//		https://www.spoj.com/problems/TRT/
//		https://www.spoj.com/problems/MIXTURES/
//		https://www.spoj.com/problems/EDIST/ 
	
	public static void main(String[] args) {

	}

	public int solve(int idx, int prev_idx, int[] arr) {

		if (idx == arr.length) {
			return 0;
		}
		int sp1 = 0;
		if (prev_idx == -1 || arr[idx] > arr[prev_idx]) {
			sp1 = 1 + solve(idx + 1, idx, arr);
		}
		int sp2 = solve(idx + 1, prev_idx, arr);
		return Math.max(sp1, sp2);
	}

	public int lengthOfLIS(int[] nums) {
		ArrayList<Integer> AL = new ArrayList<>();
		for (int ali : nums) {
			if (AL.isEmpty() || ali > AL.get(AL.size() - 1)) {
				AL.add(ali);
			} else {
				// AL = {2,5, 6,8,10} ali = 6;
				// T,T, F,F,F
				int s = 0;
				int e = AL.size() - 1;
				int ans = e;
				while (s <= e) {
					int mid = (s + e) / 2;
					if (ali <= AL.get(mid)) {
						ans = mid;
						e = mid - 1;
					} else {
						s = mid + 1;
					}
				}
				AL.set(ans, ali);
			}
		}
		return AL.size();
	}
}
