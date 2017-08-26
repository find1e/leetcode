/**
 * 
 */
package _279;

/**
 * 
 * 586 / 586 test cases passed. Accepted	   53 ms
 * @author fubaokui
 * @date   2017年5月15日 下午5:30:25
 */
public class Solution {

	public boolean isPerfectSquares(int n){
		double result = Math.sqrt(n);
		int resultInt = (int)result;
		return resultInt == result ? true : false;
	}
	
	public int numSquares(int n) {
		if(n <=0 ){
			return 0;
		}
		if(n==1 || isPerfectSquares(n)){
			return 1;
		}
		int loop = (int)Math.sqrt(n);
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=loop;i++){
			min = Math.min(min, 1 + numSquares(n -i*i));
		}
		return min;
	}
	
	public int numSquaresDP(int n) {
		int[] p = new int[n+1];
		for(int i=1;i<=n;i++){
			if(isPerfectSquares(i)){
				p[i] =  1;
				continue;
			}
			int min = Integer.MAX_VALUE;
			int loop2 = (int)Math.sqrt(i);
			for(int j=1;j<=loop2;j++){
				min = Math.min(min, 1 + p[i-j*j]);
			}	
			p[i] = min;
		}
		return p[n];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numSquares(1000));
	}

}
