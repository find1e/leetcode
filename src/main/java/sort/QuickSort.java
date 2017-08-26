/**
 * 
 */
package sort;

import java.util.Arrays;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author fubaokui
 * @date   2017年8月16日 下午10:28:39
 */
public class QuickSort{

	public void quickSort(int[] array,int start,int end) {
		if(start < end){
			int  base = partition2(array,start,end);
			quickSort(array,start,base-1);
			quickSort(array,base+1,end);
		}
	}

	public int partition2(int[]array,int start,int end){
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
	
	public int  partition(int[] array,int low,int high){
		int key = array[low];
		while(low < high){
			while(low < high  && array[high] >= key){
				high--;
			}
			array[low] = array[high];
			while(low < high  && array[low] <= key){
				low++;
			}
			array[high] = array[low];
		}
		array[low] = key;
		return low;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1,91,8,12,3,10,5,6,7,8,9};
		QuickSort quickSort = new QuickSort();
		quickSort.quickSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
		
	}

}
