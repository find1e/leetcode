package dp;

/**
 * @author fubaokui
 * @date 2018-12-12 02:12:15
 */
public class Fibonacci {

	public static int f1(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return f1(n - 1) + f1(n - 2);
	}

	public static int f2(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int a = 0;
		int b = 1;
		for (int i = 2; i <= n; i++) {
			int temp = a + b;
			a = b;
			b = temp;
		}
		return b;
	}

	public static int f3(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		return dp[n];
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(f1(30));
		long end1 = System.currentTimeMillis();
		System.out.println(f2(30));
		System.out.println(f3(30));
		long end2 = System.currentTimeMillis();
		System.out.println(end1 - start);
		System.out.println(end2 - end1);
	}

}
