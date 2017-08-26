package _53;

public class Solution {
	public int maxSubArray(int[] nums) {
		int dp[] = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
			max = max < dp[i] ? dp[i] : max; 
		}
		return max;
	}

	public int maxSubArray2(int[] nums) {
		int max = nums[0];
		int temp = nums[0];
		for (int i = 1; i < nums.length; i++) {
			temp = nums[i] + (temp > 0 ? temp : 0);
			max = max < temp ? temp : max; 
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().maxSubArray(new int[] {-2,1,-3,4}));
		System.out.println(new Solution().maxSubArray2(new int[] {-2,1,-3,4}));
	}
}