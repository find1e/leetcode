package _3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fubaokui
 * @date 2018-12-18 04:12:30
 */
class Solution {

	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		if (s.length() <= 1) {
			return s.length();
		}
		int left = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			Character tmp = s.charAt(i);
			if (map.containsKey(tmp)) {
				left = Math.max(map.get(tmp) + 1, left);
			}
			max = Math.max(max, i - left + 1);
			map.put(tmp, i);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLongestSubstring("ggububgvfk"));
	}
}
