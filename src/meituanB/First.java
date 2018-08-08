package meituanB;

import java.util.Scanner;

public class First {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] cs = sc.nextLine().toCharArray();
		if(cs.length==1) {System.out.print(1);return;}
		int sum = 0;
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == '1') {
				sum++;
			}
		}
		sum = sum - 1 + (cs.length - 1 + 1) * (cs.length - 1) / 2;
		System.out.print(sum);
		sc.close();
	}
}
