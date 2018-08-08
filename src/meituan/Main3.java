package meituan;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int max = -100000000;
		int[] l = new int[k];
		int[][] cola = new int[k][2];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < 2; j++) {
				cola[i][j] = sc.nextInt();
			}
			l[i] = cola[i][0] * m + cola[i][1] * (n - m);
			max = max > l[i] ? max : l[i];
		}
		for (int i = k-1; i >=0; i--) {
			if (l[i] >= max) {
				for (int j = 0; j < k; j++) {
					if (j == k - 1) {
						if (j == i)
							System.out.print(n);
						else
							System.out.print(0);
					} else {
						if (j == i)
							System.out.print(n + " ");
						else
							System.out.print(0 + " ");
					}
				}
				break;
			}
		}
		sc.close();
	}

}
