/**
 * 
 */
package _46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fubaokui
 * @date 2017年6月19日 下午6:06:10
 */
public class Main {

	private static List<List<Integer>> finalResult = null;
	
	public List<List<Integer>> permute(int[] nums) {
		finalResult = new ArrayList<>();
		if(nums == null || nums.length ==0){
			return finalResult;
		}
		bt(0,new LinkedList<Integer>(),nums);
		return finalResult;
	}
	
	public void bt(int index,LinkedList<Integer> result,int[] nums){
		if(index == nums.length){
			List<Integer> resultTemp = new ArrayList<Integer>();
			resultTemp.addAll(result);
 			finalResult.add(resultTemp);
		}else{
			for(int i = 0;i<nums.length;i++){
				int temp = nums[i];
				if(checkValidte(temp,result) == false){
					continue;
				}
				result.add(nums[i]);
				bt(index + 1, result,nums);
				result.removeLast();
			}
		}
	}

	private boolean checkValidte(int temp, List<Integer> result) {
		for(int i : result){
			if(temp == i){
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main().permute(new int[]{0,1});
		System.out.println(finalResult);
		new Main().permute(null);
//		System.out.println(finalResult);
		
	}
	
}
