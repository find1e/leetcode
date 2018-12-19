package _712;

import java.util.Arrays;

/**
 * @author fubaokui
 * @date 2018-12-13 08:12:07
 */
class Solution {
	public int minCostClimbingStairs(int[] cost) {
		if (cost == null || cost.length == 0) {
			return 0;

		}
		if (cost.length == 1) {
			return cost[0];
		}
		if (cost.length == 2) {
			return min(cost[0], cost[1]);
		}
		int[] dp = new int[cost.length];
		dp[cost.length - 1] = cost[cost.length - 1];
		dp[cost.length - 2] = cost[cost.length - 2];
		for (int i = cost.length - 3; i >= 0; i--) {
			dp[i] = cost[i] + min(dp[i + 1], dp[i + 2]);
		}
		System.out.println(Arrays.toString(dp));
		return min(dp[0], dp[1]);
	}

	public int min(int a, int b) {
		return a < b ? a : b;
	}

	public static void main(String[] args) {

		System.out.println(new Solution().minCostClimbingStairs(new int[] {0, 1, 1, 0}));

	}

	public static boolean check(String s, int start, int end) {
		for (int i = start, j = end - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

}
