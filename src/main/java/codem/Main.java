package codem;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
		int[] d1 = new int[n1];
        int i = 0;
        while(i<n1){
            d1[i++] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] d2 = new int[n2];
		i = 0;
		while(i<n2){
            d2[i++] = sc.nextInt();
        }
		int minDeff = Integer.MAX_VALUE;
		for(i=0;i<=n2-n1;i++){
			int dif = calDifference(d1,d2,i);
			if(dif < minDeff){
				minDeff = dif;
			}
		}
		System.out.println(minDeff);
	}

	private static int calDifference(int[] d1, int[] d2, int start) {
		int sum = 0;
		for(int i =0;i<d1.length;i++){
			sum += (d1[i]-d2[i+start])*(d1[i]-d2[i+start]);
		}
		return sum;
	}
}