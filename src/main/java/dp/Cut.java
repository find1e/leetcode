/**
 * 
 */
package dp;

/**
 * @author fubaokui
 * @date 2017年5月15日 下午7:38:01
 */
public class Cut {

	private static final int[] price = new int[] {1, 2, 5, 8, 9, 10, 17};

	public int cut(int[] prices, int n) {
		if (n <= 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, price[i] + cut(prices, n - i));
		}
		return max;
	}


	private int maxArray[] = new int[price.length];

	public int cutDP(int[] prices, int n) {
		for (int i = 1; i <= n; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 1; j <= i; j++) {
				max = Math.max(max, price[j] + maxArray[i - j]);
			}
			maxArray[i] = max;
		}
		return maxArray[n];
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(new Cut().cut(price, 20));
		long end1 = System.currentTimeMillis();
		System.out.println(new Cut().cutDP(price, 20));
		long end2 = System.currentTimeMillis();
		System.out.println("Recursive elapse(ms) : " + (end1 - start));
		System.out.println("DP elapse(ms) : " + (end2 - end1));
	}

}
