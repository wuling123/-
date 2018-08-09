package PrimarySchool;

import java.util.Scanner;
/**
 * 并查集找犯罪团伙
 * 判断连通分支的个数
 * 1.初始化：每个点各自是一个团伙
 * 2.擒贼先擒王，查询其头领是谁，并使用压缩路径的方法
 * 3.左为王原则
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
		//初始化
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
		//擒贼先擒王
	public static int getA(int v, int[] a) {
		if (a[v] == v)
			return v;
		else {//压缩路径
			a[v] = getA(a[v], a);
			return a[v];
		}
	}
		//左为王
	public static void m(int x, int y, int[] a) {
		int p = getA(x, a);
		int q = getA(y, a);
		if (p != q) {
			a[q] = p;
		}
	}
}
