package dp;

/**
 * @author fubaokui
 * @date 2018-12-13 08:12:26
 */
public class CoinDispenser {

	public int dispenser(int[] coins, int target) {
		if (target == 0) {
			return 0;
		}
		int[] dp = new int[target + 1];
		dp[0] = 0;
		for (int i = 1; i <= target; i++) {
			dp[i] = Integer.MAX_VALUE;
			if (checkIn(coins, i)) {
				dp[i] = 1;
				continue;
			}
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
			}
		}
		return dp[target];
	}

	public int dispenser2(int[] coins, int target) {
		if (target == 0) {
			return 0;
		}
		int[] dp = new int[target + 1];
		dp[0] = 0;
		for (int i = 1; i <= target; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i > coins[j]) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[target];
	}

	private boolean checkIn(int[] coins, int i) {
		for (int j = 0; j < coins.length; j++) {
			if (coins[j] == i) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] coins = new int[] {1, 3, 5};
		for (int i = 0; i <= 20; i++) {
			System.out.println(new CoinDispenser().dispenser2(coins, i));
		}
	}

}
