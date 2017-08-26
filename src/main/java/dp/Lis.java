/**
 * 
 */
package dp;

import java.util.Arrays;

/**
 * 
 * 最长递增子数列 问题
 * @author fubaokui
 * @date   2017年5月16日 下午9:17:21
 */
public class Lis {

	public int calLis(int[] source){
		int[] f = new int[source.length];
		int max = f[0];
		for(int i=0;i<source.length;i++){
			int temp = 1;
			for(int j=0;j<i;j++){
				if(source[i] > source[j]){
					if(temp < f[j] + 1){
						temp = f[j] +1;
						if(temp > max ){
							max = temp;
						}
					}
				}
			}
			f[i] = temp;
		}
		System.out.println(Arrays.toString(f));
		return max;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Lis().calLis(new int[]{1,7,2,8,3,4}));
		
	}

}
