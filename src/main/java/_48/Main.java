package _48;

/**
 * 
 * @author fubaokui
 * @date 2018/08/08
 */
public class Main {

	public void rotate(int[][] matrix) {
		if (matrix == null) {
			return;
		}
		int m = matrix[0].length;
		if (m == 1) {
			return;
		}
		int[][] news = new int[m][m];
		for (int i = 0; i < matrix.length; i++) {
			int col = m - i - 1;
			for (int j = 0; j < m; j++) {
				news[j][col] = matrix[i][j];
			}
		}
		copy(news, matrix);
	}

	public static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void copy(int[][] source, int[][] target) {
		for (int i = 0; i < source.length; i++) {
			for (int j = 0; j < source[i].length; j++) {
				target[i][j] = source[i][j];
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		print(matrix);
		new Main().rotate(matrix);
		print(matrix);
	}
}
