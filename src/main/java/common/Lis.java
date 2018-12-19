/**
 * 
 */
package common;

/**
 * 
 * Longest Increasing Subsequence
 * 
 * @author fubaokui
 * @date 2017年4月17日 上午8:51:55
 */
public class Lis {

	public static int lisDp(int[] source) {
		if (source == null || source.length == 0) {
			return 0;
		}
		int[] d = new int[source.length];
		int max = 1;
		for (int i = 0; i < source.length; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (source[j] <= source[i] && d[j] + 1 > d[i]) {
					d[i] = d[j] + 1;
					if (max < d[i]) {
						max = d[i];
					}
				}
			}
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(lisDp(new int[] {2, 1, 5, 3, 6, 4, 7, 9, 7}));
	}

}
