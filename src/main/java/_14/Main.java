package _14;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * @author fubaokui
 * @date 2018/08/07
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
		System.out.println(main.longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
		System.out.println(main.longestCommonPrefix(new String[] {"dog"}));
	}


	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String source = strs[0];
		if (strs.length == 1) {
			return source;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < source.length(); i++) {
			char c = source.charAt(i);
			for (String str : strs) {
				if (str.length() <= i || str.charAt(i) != c) {
					return sb.toString();
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}

}
