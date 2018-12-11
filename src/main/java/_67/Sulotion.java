package _67;

/**
 * @author fubaokui
 * @date 2018-12-10 04:12:01
 */
class Solution {
	public String addBinary(String a, String b) {
		int i = a.length() - 1;
		int j = b.length() - 1;
		int k = 0;
		int max = a.length() > b.length() ? a.length() : b.length();
		char[] result = new char[max + 1];
		int p = max;
		while (i >= 0 || j >= 0) {
			int x = 0;
			if (i >= 0) {
				x = a.charAt(i) - 48;
			}
			int y = 0;
			if (j >= 0) {
				y = b.charAt(j) - 48;
			}
			int z = x + y + k;
			if (z == 2) {
				k = 1;
				result[p] = '0';
			} else if (z == 3) {
				k = 1;
				result[p] = '1';
			} else {
				k = 0;
				result[p] = z == 0 ? '0' : '1';
			}
			i--;
			j--;
			p--;
		}
		if (k == 1) {
			result[p] = '1';
		}
		return result[0] == '1' ? new String(result, 0, max + 1) : new String(result, 1, max);
	}
}
