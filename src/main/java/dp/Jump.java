/**
 * 
 */
package dp;

/**
 * @author fubaokui
 * @date   2017年5月17日 下午5:16:01
 */
public class Jump {

	public int jumpTo(int n){
		int[] p = new int[n+1];
		p[1] = 1;
		p[2] = 2;
		for(int i = 3;i<=n;i++){
			p[i] = p[i-1] + p[i-2];
		}
		return p[n];
	}
	
	public static void main(String[] args) {
		System.out.println(new Jump().jumpTo(10));
	}
	
}
