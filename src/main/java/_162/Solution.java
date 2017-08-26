/**
 * 
 */
package _162;

/**
 * @author fubaokui
 * @date   2017年8月17日 上午9:14:36
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        if(nums.length == 2){
            return nums[1] > nums[0] ? 1 : 0;
        }
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            while(i<j && nums[i]<=nums[j]){
                i++;
            }
            while(i<j && nums[j]<=nums[i]){
                j--;
            }
        }
        return i;
    }
    
    public static void main(String[] args) {
    	int[] array = new int[]{1,7,4,9,1,23,7,8,19};
		int index = new Solution().findPeakElement(array);
		System.out.println(array[index]);
	}
}