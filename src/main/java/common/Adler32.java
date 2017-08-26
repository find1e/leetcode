/**
 * 
 */
package common;

/**
 * @author fubaokui
 * @date   2017年4月10日 下午6:15:33
 */
public class Adler32 {

	private static final int MOD_ADLER = 65521;
	
	public static String cal(String source){
		int a = 1,b=0;
		for(char c : source.toCharArray()){
			a = (a + c) >Integer.MAX_VALUE ? (a + c ) % MOD_ADLER :(a + c); 				
			b = (b + c) >Integer.MAX_VALUE ? (b + c ) % MOD_ADLER :(b + c);
		}
		return (Integer.toHexString(b) + Integer.toHexString(a)).toUpperCase();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Adler32.cal("Wikipedia"));
	}

}
