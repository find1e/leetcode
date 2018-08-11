/**
 * 
 */
package dp;

/**
 * @author fubaokui
 * @date   2017年8月30日 下午10:14:51
 */
public class LongestCommonSubsequence {

	public int lcs(String a,String b){
		if(a == null || b == null){
			return 0;
		}
		int lenA = a.length();
		int lenB = b.length();
		int[][] tempResult = new int[lenA][lenB];
		int maxLCS = 0;
		
		for(int i =0;i<lenA;i++){
			for(int j=0;j<lenB;j++){
				if(a.charAt(i) == b.charAt(j)){
					if(i>0 && j>0){
						tempResult[i][j] =  tempResult[i-1][j-1]+1;
					}else{
						tempResult[i][j] = 1;
					}
				}else{
					if(i>0 && j>0){
						tempResult[i][j]  = Math.max(tempResult[i-1][j], tempResult[i][j-1]);
					}else if(j>0){
						tempResult[i][j] = tempResult[i][j-1];
					}else if(i>0){
						tempResult[i][j] = tempResult[i-1][j];
					}else{
						tempResult[i][j] = 0;
					}
				}
				if(tempResult[i][j] > maxLCS){
					maxLCS = tempResult[i][j];
				}
			}
		}
		return maxLCS;
	}
	
	public static void main(String[] args) {
		System.out.println(new LongestCommonSubsequence().lcs("fish", "fxxxxiosh"));
	}
	
}
