package shenxinfu;

import java.util.ArrayList;
import java.util.Scanner;

public class Second {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> IDNAME = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			if (!IDNAME.contains(a)) {
				IDNAME.add(a);
			}

		}
		if (IDNAME.size() <= 10) {
			System.out.println(IDNAME.size());
		} else {
			System.out.println(10);
		}
		for (int i = 0; i < IDNAME.size(); i++) {
			System.out.println(IDNAME.get(i));
			if (i >= 9) {
				break;
			}
		}
		sc.close();
	}
}
