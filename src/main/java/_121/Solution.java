/**
 * 
 */
package _121;

/**
 * 
 * Best Time to Buy and Sell Stock
 * 
 * @author fubaokui
 * @date   2017年5月18日 上午7:49:34
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int buy = prices[0];
        int profit = 0;
        for(int i = 1;i< prices.length;i++){
        		if(prices[i] > buy){
        			profit = prices[i] - buy > profit ? prices[i] - buy : profit;
        		}else{
        			buy = prices[i];
        		}
        }
        return profit;
    }
    
    public static void main(String[] args) {
			System.out.println(new Solution().maxProfit(new int[]{7, 1}));
	}
}
