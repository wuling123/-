package vivo;

import java.util.Scanner;

public class vivo1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] array = str.toCharArray();
		int low = 0;
		int high = 0;
		int j = 0;
		int m = 0;
		int k = 0;
		int[] max = new int[3];
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1)
				break;
			if (array[i] == array[i + 1]) {
				m = i;
				while (m < array.length) {
					if (m == array.length - 1 || array[m] != array[m + 1])
						break;
					else
						m++;
				}
				if ((m - i + 1) / 2 > max[0]) {
					max[1] = i;
					max[2] = i + (m - i + 1) / 2;
					max[0] = (m - i + 1) / 2;
				}
				continue;
			}
			j = i + 1;
			while (j < array.length) {
				while (j < array.length) {
					if (array[i] == array[j]) {
						high = j;
						k = j;
						break;
					}
					j++;
				}
				if (j == array.length)
					continue;
				for (low = i + 1; low <= high - 1;) {
					if (j == array.length - 1)
						break;
					if (array[low] == array[j + 1]) {
						low++;
						j++;
					} else
						break;
				}
				if (low == high) {
					if (high - i > max[0]) {
						max[1] = i;
						max[2] = high;
						max[0] = high - i;
					}
				}
				j = k + 1;
			}
		}
		if (max[0] == 0)
			System.out.println("--");
		else {
			// for (int i = max[1]; i < max[2]; i++) {
			System.out.print(2 * max[0]);
			// }
		}
		sc.close();
	}

}
