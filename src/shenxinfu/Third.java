package shenxinfu;

import java.util.Scanner;

public class Third {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[20];
		int M = 100;
		for (int i = 0; i < n; ++i)
			data[i] = sc.nextInt();
		int m = (1 << n);
		for (int t = 1; t < m; ++t) {
			int sum = 0;
			int ans = 0;
			for (int i = 0; i < n; ++i) {
				if ((t & (1 << i)) != 0) {
					sum += data[i];
					++ans;
				}
			}
			if (sum == M) {
				System.out.println(ans);
				for (int i = 0; i < n; ++i) {
					if ((t & (1 << i)) != 0)
						System.out.println(i + 1);
				}
				break;
			}
		}
		sc.close();
	}

}
