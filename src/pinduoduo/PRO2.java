package pinduoduo;

import java.util.Scanner;

public class PRO2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] d = new int[55][55];
		int[][] compare = new int[55][55];

		for (int i = 0; i < m; ++i) {
			String str = sc.next();
			for (int j = 0; j < n; ++j) {
				d[i][j] = (int) str.charAt(j);
			}
		}
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				int t = 0;
				for (int k = 0; k < m; ++k) {
					if (d[k][i] < d[k][j])
						++t;
					if (d[k][i] > d[k][j])
						--t;
				}
				compare[i][j] = t;
				compare[j][i] = -t;
			}
			compare[i][i] = 1;
		}
		int ans = -1;
		for (int i = 0; i < n; ++i) {
			int sum = 0;
			for (int j = 0; j < n; ++j) {
				if (compare[i][j] > 0)
					++sum;
				else
					break;
			}
			if (sum == n) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
		sc.close();
	}

}
