package search;

/**
 * @author fubaokui
 * @date 2018-12-12 07:12:48
 */
public class BinarySearch {

	public int bs(int[] source, int target) {
		if (source == null || source.length == 0) {
			return -1;
		}
		int low = 0;
		int high = source.length - 1;
		while (low <= high) {
			int mid = (low + high) >>> 1;
			if (source[mid] == target) {
				return mid;
			} else if (source[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] source = new int[] {1, 4, 7, 9, 12, 23, 34};
		int index = new BinarySearch().bs(source, 5);
		System.out.println(index);

	}

}
