package _169;

/**
 * 
 * @author fubaokui
 * @date 2017年4月10日 下午5:27:07
 */
public class Solution {

	public int majorityElement(int[] nums) {
		int count = 1;
		int target = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == target) {
				count++;
			} else {
				count--;
				if (count <= 0) {
					target = nums[i];
					count = 1;
				}
			}
		}
		return target;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 47, 47, 72, 47, 72, 47, 79, 47, 12, 92, 13, 47, 47, 83, 33, 15, 18, 47, 47, 47, 47, 64,
				47, 65, 47, 47, 47, 47, 70, 47, 47, 55, 47, 15, 60, 47, 47, 47, 47, 47, 46, 30, 58, 59, 47, 47, 47, 47,
				47, 90, 64, 37, 20, 47, 100, 84, 47, 47, 47, 47, 47, 89, 47, 36, 47, 60, 47, 18, 47, 34, 47, 47, 47, 47,
				47, 22, 47, 54, 30, 11, 47, 47, 86, 47, 55, 40, 49, 34, 19, 67, 16, 47, 36, 47, 41, 19, 80, 47, 47,
				27 };
		System.out.println(new Solution().majorityElement(nums));
	}

}
