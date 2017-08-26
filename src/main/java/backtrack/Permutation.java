package backtrack;

import java.util.Arrays;

public class Permutation {

	private String result[];
	private String target[];
	
	public Permutation(String[] target){
		this.result = new String[target.length];
		this.target = target;
	}
	
	public void doPermutation(){
		bt(0);	
	}
	
	public void bt(int n){
		if(n >= target.length){
			System.out.println(Arrays.toString(result));
		}else{
			for(int i =0;i<target.length;i++){
				if(check(result,target[i],n)){
					result[n] = target[i];
					bt(n+1);
					result[n]=null;
				}
			}
		}
	}
	
	private boolean check(String[] result, String target,int length) {
		for(int i = 0;i<length;i++){
			if(result[i]!=null && result[i].equals(target)){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Permutation permutation = new Permutation(new String[]{"a","b","c","d"});
		permutation.doPermutation();
		
	}
	
}
