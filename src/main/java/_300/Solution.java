/**
 * 
 */
package _300;

import java.util.Arrays;

/**
 * @author fubaokui
 * @date 2017年8月26日 下午5:04:12
 */
class Solution {
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 1 || nums.length == 0) {
			return nums.length;
		}
		int[] lis = new int[nums.length];
		lis[0] = 1;
		int result = 1;
		for (int i = 1; i < nums.length; i++) {
			int max = 1;
			for (int j = 0; j < i; j++) {
				int temp = 1;
				if (nums[i] > nums[j]) {
					temp = lis[j] + 1;
				}
				if (temp > max) {
					max = temp;
				}
			}
			lis[i] = max;
			if (max > result) {
				result = max;
			}
		}
		System.out.println(Arrays.toString(lis));
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new Solution().lengthOfLIS(new int[]{4,10,4,3,8,9}));
		
	}
}