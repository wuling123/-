package alibaba;

import java.util.Scanner;

public class Num {
	static final long y = 1000000000 + 7l;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		// int max=a>=b?a:
		long ny = niyuan(y, (((c(a) * c(b)) % y) * ((c(c) * c(d)) % y)) % y);
		System.out.println((c(a + b + c + d) * ny) % y);
		sc.close();
	}

	public static long c(int a) {
		long sum = 1;
		for (int i = 1; i <= a; i++) {
			sum *= i;
			sum = sum % y;
		}
		return sum;
	}
/**
 * ��b��������a����
 * @param a ����
 * @param b
 * @return ��Ԫ
 */
	public static long niyuan(long a, long b) // ��550����ģ1769�ĳ˷���Ԫ
	// 550*X(mod1769)=1
	// niyuan(1769,550)
	{
		long[] m = { 1, 0, a };
		long[] n = { 0, 1, b };
		long[] temp = new long[3];
		long q = 0; // ��ʼ��
		boolean flag = true;
		while (flag) {
			q = m[2] / n[2];
			for (int i = 0; i < 3; i++) {
				temp[i] = m[i] - q * n[i];
				m[i] = n[i];
				n[i] = temp[i];
			}
			if (n[2] == 1) {
				if (n[1] < 0) {
					n[1] = n[1] + a;
				}
				return n[1];
			}
			if (n[2] == 0) {
				flag = false;
			}
		}
		return 0;
	}
}
