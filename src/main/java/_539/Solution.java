package _539;

import java.util.Stack;

/**
 * @author fubaokui
 * @date 2018-12-13 09:12:55
 */
class Solution {
	public String reverseWords(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		char[] buffer = s.toCharArray();
		int start = 0;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				stack.push(s.charAt(i));
			} else {
				while (stack.isEmpty() == false) {
					buffer[start++] = stack.pop();
				}
				buffer[start++] = ' ';
			}
		}
		while (stack.isEmpty() == false) {
			buffer[start++] = stack.pop();
		}
		return new String(buffer);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));

	}

}
