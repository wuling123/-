package PrimarySchool;

import java.util.Scanner;
/**
 * ���鼯�ҷ����Ż�
 * �ж���ͨ��֧�ĸ���
 * 1.��ʼ����ÿ���������һ���Ż�
 * 2.��������������ѯ��ͷ����˭����ʹ��ѹ��·���ķ���
 * 3.��Ϊ��ԭ��
 * @author Administrator
 *
 */
public class Bingchaji {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int count = 0;
		int[] a = new int[n + 1];
		//��ʼ��
		for (int i = 1; i < a.length; i++) {
			a[i] = i;
		}
		for (int i = 0; i < m; i++) {
			m(sc.nextInt(), sc.nextInt(), a);
		}
		for (int i = 1; i < a.length; i++) {
			if (a[i] == i)
				count++;
		}
		System.out.println(count);
		sc.close();
	}
		//����������
	public static int getA(int v, int[] a) {
		if (a[v] == v)
			return v;
		else {//ѹ��·��
			a[v] = getA(a[v], a);
			return a[v];
		}
	}
		//��Ϊ��
	public static void m(int x, int y, int[] a) {
		int p = getA(x, a);
		int q = getA(y, a);
		if (p != q) {
			a[q] = p;
		}
	}
}
