/**
 * 
 */
package _120;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Triangle
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * 
 * @author fubaokui
 * @date   2017年5月18日 下午5:59:01
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int treeHight = triangle.size();
        int[][] dp = new int[treeHight][];
        int i = 0;
        dp[treeHight-1] = new int[triangle.get(treeHight-1).size()];
        for(Integer integer : triangle.get(treeHight-1)){
            dp[treeHight-1][i++] = integer; 
        }
        for(i = treeHight-2;i>=0;i--){
            List<Integer> arr = triangle.get(i);
            dp[i] = new int[arr.size()];
            for(int j= 0;j<arr.size();j++){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + arr.get(j);
            }
        }
        return dp[0][0];
    }
    
    public static void main(String[] args) {
		
    		List<List<Integer>> source = new ArrayList<List<Integer>>();
    		
    		List<Integer> n0 = new ArrayList<Integer>();
    		n0.add(2);
    		
    		List<Integer> n1 = new ArrayList<Integer>();
    		n1.add(3);
    		n1.add(4);
    		
    		List<Integer> n2 = new ArrayList<Integer>();
    		n2.add(6);
    		n2.add(5);
    		n2.add(7);
    		
    		List<Integer> n3 = new ArrayList<Integer>();
    		n3.add(4);
    		n3.add(1);
    		n3.add(7);
    		n3.add(8);
    		
    		source.add(n0);
    		source.add(n1);
    		source.add(n2);
    		source.add(n3);
    	
    		System.out.println(new Solution().minimumTotal(source));
    		
	}
    
}