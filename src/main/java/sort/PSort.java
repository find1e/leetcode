package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 
 * @author fubaokui
 * @date 2018-12-12 07:12:57
 */
public class PSort {

	public void sort(int[] source) {
		if (source == null || source.length < 2) {
			return;
		}
		for (int i = 0; i < source.length; i++) {
			for (int j = i + 1; j < source.length; j++) {
				if (source[i] > source[j]) {
					int temp = source[j];
					source[j] = source[i];
					source[i] = temp;
				}
			}
		}
	}

	public void sort2(int[] source) {
		if (source == null || source.length < 2) {
			return;
		}
		for (int i = 0; i < source.length; i++) {
			int min = i;
			for (int j = i + 1; j < source.length; j++) {
				if (source[i] > source[j]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = source[min];
				source[min] = source[i];
				source[i] = temp;
			}
		}
	}

	public static void main(String[] args) {

		int[] source = new int[] {1, 8, 3, 6, 0, 12, 21};
		new PSort().sort2(source);
		System.out.println(Arrays.toString(source));

	}

}
