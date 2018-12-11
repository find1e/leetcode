package sort;

import java.util.Arrays;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author fubaokui
 * @date 2018/08/13
 */
public class HeapSort {


	public static void main(String[] args) {
		int arrayLength = 10;
		int max = 100;
		int[] arr = new int[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			arr[i] = RandomUtils.nextInt(0, max);
		}
		System.out.println(Arrays.toString(arr));
		new HeapSort().heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public void heapSort(int[] arrays) {
		if (arrays == null || arrays.length == 1) {
			return;
		}
		// 1.初始化heap
		initHeap(arrays);
		// 2.循环首尾swap & 重建 head
		for (int i = 0; i < arrays.length; i++) {
			swap(arrays, 0, arrays.length - i - 1);
			adjustHeap(arrays, 0, arrays.length - i - 2);
		}
	}

	private void adjustHeap(int[] arrays, int i, int j) {
		int parentNode = 0;
		while (parentNode < arrays.length - 1) {
			int leftSon = (parentNode << 1) + 1;
			int rightSon = (parentNode << 1) + 2;

			if (rightSon < arrays.length - 1) {
				if (arrays[parentNode] < arrays[rightSon]) {
					swap(arrays, parentNode, rightSon);
				}
			}

		}
	}

	private void initHeap(int[] arrays) {
		int lastParentNode = (arrays.length - 1 >> 1) - 1;
		if (lastParentNode < 0) {
			return;
		}
		while (lastParentNode >= 0) {
			adjustNode(arrays, lastParentNode);
			lastParentNode--;
		}
	}

	private void swap(int[] arrays, int i, int j) {
		int temp = arrays[i];
		arrays[i] = arrays[j];
		arrays[j] = temp;
	}


	private void adjustNode(int[] arrays, int parentNode) {
		int leftSon = (parentNode << 1) + 1;
		if (leftSon < arrays.length - 1) {
			if (arrays[parentNode] < arrays[leftSon]) {
				swap(arrays, parentNode, leftSon);
			}
		}
		int rightSon = (parentNode << 1) + 2;
		if (rightSon < arrays.length - 1) {
			if (arrays[parentNode] < arrays[rightSon]) {
				swap(arrays, parentNode, rightSon);
			}
		}
	}

}
