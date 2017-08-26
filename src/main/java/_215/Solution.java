/**
 * 
 */
package _215;

import java.util.Random;

/**
 * @author fubaokui
 * @date   2017年8月25日 下午7:48:01
 */
class Solution {
    public int partition(int[] array,int start,int end){
        if(start == end){
            return start;
        }
        int p = start; 
		int m = start + new Random().nextInt(end - start);
        int target = array[m];
        swap(array, start, m);
        for(int i = start +1;i<=end;i++){
            if(array[i] > target){
                p++;
                swap(array,p,i);
            }
        }
        swap(array,p,start);//
        return p;
    }
    
    public void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            int m = partition(nums,start,end);
            if(m == k-1){
                return nums[m];
            }else if(m > k - 1){
                end = m -1;
            }else{
                start = m+1;
            }
        }
        return nums[end];
    }
    public static void main(String[] args) {
    	System.out.println(new Solution().findKthLargest(new int[]{-1,2,0},2));
	}
    
}