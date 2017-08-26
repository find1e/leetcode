/**
 * 
 */
package _540;

/**
 * @author fubaokui
 * @date   2017年4月15日 下午10:21:45
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int target = nums[0];
        for(int i = 1;i<nums.length;i++){
            target^=nums[i];
        }
        return target;
    }
    
    public static void main(String[] args) {
		
    		System.out.println(new Solution().singleNonDuplicate(new int[]{0,1,1}));
    	
	}
}