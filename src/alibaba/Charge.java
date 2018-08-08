package alibaba;

import java.util.Date;
import java.util.Scanner;

public class Charge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] array = new int[m];
		for (int i = 0; i < m; i++) {
			array[i] = sc.nextInt();
		}
		int[] money = new int[n+1];
		money[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = array[i]; j < n+1; j++) {
				money[j] = money[j] + money[j - array[i]];
			}
		}
		System.out.println(money[n]);
		//System.out.println(new Date());
	}

}
