package alibaba;

import java.util.Scanner;

public class addString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			double double1 = sc.nextDouble();
			double double2 = sc.nextDouble();
			System.out.println(double1 + double2);
		} catch (Exception e) {
			System.out.println(false);
		} finally {
			sc.close();
		}
	}
}
