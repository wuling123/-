package alibaba;

import java.util.Scanner;

public class BaiCiZhan2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int temp = 0;
		int low = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		while (temp < n) {
			while (temp < n && arr[temp] + 1 == arr[temp + 1]) {
				temp++;
				if (temp == n - 1)
					break;
			}
			if (temp - low >= 2) {
				if (temp == n - 1)
					System.out.print(arr[low] + "-" + arr[temp]);
				else
					System.out.print(arr[low] + "-" + arr[temp] + ",");
			} else {
				for (int i = low; i <= temp; i++) {
					if (i == n - 1)
						System.out.print(arr[i]);
					else
						System.out.print(arr[i] + ",");
				}
			}
			low = temp + 1;
			temp++;
			if (temp == n - 1) {
				System.out.print(arr[temp]);
				break;
			}
		}
		sc.close();
	}
}
