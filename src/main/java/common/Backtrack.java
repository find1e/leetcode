/**
 * 
 */
package common;

/**
 * @author fubaokui
 * @date   2017年3月15日 下午4:17:38
 */
public class Backtrack {

	private char[] elems = new char[]{'a','b','c','d','e'};
	
	private char[] target = new char[elems.length];
	
	public void backtrac(int n){
		if(n >= elems.length){
			System.out.println(new String(target));
		}else{
			for(int i = 0;i<elems.length;i++){
				if(check(target,elems[i])){
					target[n] = elems[i];
					backtrac(n+1);
					//清理
					target[n] = ' ';
				}
			}
		}
		
	}

	private boolean check(char[] target2, char c) {
		for(int i = 0;i<target2.length;i++){
			if(c == target2[i]){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		new Backtrack().backtrac(0);
	}
}
