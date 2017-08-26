/**
 * 
 */
package _26;

import sun.security.util.Length;

/**
 * @author fubaokui
 * @date   2017年4月17日 上午9:32:34
 */
public class Solution {

	public int removeDuplicates(int[] nums) {
        if(nums[0] != nums[1]){
            return nums[0];
        }
        for(int i =0,j=1;j<nums.length;){
            if(nums[i] == nums[j]){
                j++;
            }else{
                if(j - i ==2){
                    return nums[j-1];
                }
                i = j-1;
                j++;
            }
        }
        return nums[0];
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().removeDuplicates(new int[]{1,1,2,3,3}));
	}

}
