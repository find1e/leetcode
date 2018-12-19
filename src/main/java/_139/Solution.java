package _139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author fubaokui
 * @date 2018-12-18 05:12:11
 */
class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		if ("".equals(s)) {
			return true;
		}
		boolean flag = false;
		for (String word : wordDict) {
			if (s.indexOf(word) >= 0) {
				String[] subStrings = s.split(word);
				if (subStrings.length == 0) {
					return true;
				} else {
					boolean temp = true;
					for (String sub : subStrings) {
						temp &= wordBreak(sub, wordDict);
						if (temp == false) {
							break;
						}
					}
					flag = temp;
				}
			}
		}
		return flag;
	}

	public boolean wordBreakDP(String s, List<String> wordDict) {
		if (s == null) {
			return false;
		}
		if ("".equals(s)) {
			return true;
		}
		Set<String> words = new HashSet<>(wordDict.size());
		for (String word : wordDict) {
			words.add(word);
		}
		boolean[] dp = new boolean[s.length()];
		dp[0] = words.contains(s.substring(0, 1));
		for (int i = 1; i < s.length(); i++) {
			dp[i] = words.contains(s.substring(0, i + 1));
			if (dp[i] == false) {
				boolean temp = false;
				for (int j = 0; j < i; j++) {
					temp = dp[j] && words.contains(s.substring(j + 1, i + 1));
					if (temp == true) {
						dp[i] = true;
						break;
					}
				}
			}
		}
		return dp[s.length() - 1];
	}

	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cats");
		wordDict.add("dog");
		wordDict.add("sand");
		wordDict.add("and");
		wordDict.add("cat");
		System.out.println(new Solution().wordBreak("catsand", wordDict));
		System.out.println(new Solution().wordBreakDP("catsand", wordDict));
	}
}
