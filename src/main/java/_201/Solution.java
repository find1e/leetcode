/**
 * 
 */
package _201;

/**
 * @author fubaokui
 * @date 2017年3月28日 上午9:52:17
 * 
 *       Given a range [m, n] where 0 <= m <= n <= 2147483647, return the
 *       bitwise AND of all numbers in this range, inclusive.
 * 
 */
public class Solution {

	public int rangeBitwiseAnd(int m, int n) {
		if (m == n) {
			return m;
		}
		String start = Integer.toBinaryString(m);
		String end = Integer.toBinaryString(n);
		int length = end.length();
		int sum = 0;
		if (start.length() == length) {
			int i = 0;
			for (; i < length; i++) {
				if (start.charAt(i) == end.charAt(i)) {
					if (end.charAt(i) == '1') {
						sum += 1 << (length - i - 1);
					}
				} else {
					break;
				}
			}
		}
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().rangeBitwiseAnd(5, 7));
		System.out.println(new Solution().rangeBitwiseAnd(10, 11));
	}

}
