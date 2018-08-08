package pinduoduo;

import java.util.Scanner;

public class PROB1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt() + 3;
		int t = (int) Math.pow(2, 30);
		int m = 0;
		while ((num & t) == 0) {
			t >>= 1;
			m++;
		}
		m = 30 - m;
		if (num >= (int) Math.pow(2, m) && num <= (int) Math.pow(2, m) * 1.25 - 1) {
			System.out.print("Alice");
		} else if (num >= (int) Math.pow(2, m) * 1.25 && num <= (int) Math.pow(2, m) * 1.5 - 1) {
			System.out.print("Bob");
		} else if (num >= (int) Math.pow(2, m) * 1.5 && num <= (int) Math.pow(2, m) * 1.75 - 1) {
			System.out.print("Cathy");
		} else // if(num>=(int)Math.pow(2,m)*1.75&&num<=(int)Math.pow(2, m)*2-1) {
			System.out.print("Dave");
		sc.close();
	}
}
