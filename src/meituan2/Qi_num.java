package meituan2;

import java.util.Scanner;

public class Qi_num {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array1 = new int[n];
		int[] array2 = new int[n];
		for (int i = 0; i < n; i++) {
			array1[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			array2[i] = sc.nextInt();
			int min = Math.min(array1[i], array2[i]);
			array2[i] -= min;
			array1[i] -= min;
		}

		long sum = 0;
		int right = n - 1;
		while (right > 0) {
			array1[right - 1] += array1[right];
			sum += array1[right];
			array1[right] = 0;
			int min = Math.min(array1[right - 1], array2[right - 1]);
			array2[right - 1] -= min;
			array1[right - 1] -= min;
			right--;
		}
		int min = Math.min(array1[0], array2[0]);
		array2[0] -= min;
		array1[0] -= min;
		while (right < n - 1) {
			array1[right + 1] += array1[right];
			sum += array1[right];
			array1[right] = 0;
			int m = Math.min(array1[right + 1], array2[right + 1]);
			array2[right + 1] -= m;
			array1[right + 1] -= m;
			right++;
		}
		System.out.print(sum);
		sc.close();
	}
}
