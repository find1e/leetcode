/**
 * 
 */
package topk;

import java.util.Arrays;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author fubaokui
 * @date   2017年8月24日 上午7:56:37
 */
public class SelectKth {

	public int partition(int[]array,int start,int end){
		if(start == end){
			return start;
		}
		int guard = RandomUtils.nextInt(start, end);
		if(guard != start){
			swap(array,guard,start);
		}
		guard = start;
		for(int i = start+1;i<=end;i++){
			if(array[i] < array[start]){
				guard++;
				swap(array,guard,i);
			}
		}
		swap(array,guard,start);
		return guard;
	}

	private void swap(int[] array, int guard, int start) {
		int temp = array[guard];
		array[guard] = array[start];
		array[start] = temp;
	}
	
	public int selectTopKth(int[] array,int k){
		int start = 0;
		int end = array.length-1;
		while(start < end){
			int m = partition(array, start, end);
			System.out.println(Arrays.toString(array));
			System.out.println(m);
			if(m == k-1){
				return array[m];
			}else if(m < k){
				start = m+1;
			}else{
				end = m-1;
			}
		}
		return start;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{23,18,45,79,8,40,71,55,92,85};
		System.out.println(new SelectKth().selectTopKth(array, 8));
	}
	
}
