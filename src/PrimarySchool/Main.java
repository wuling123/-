package PrimarySchool;

import java.util.Scanner;
/**
 * 
 * @author Administrator
 *DFS		��������㷨�������·��
 *����ͼ��ĳ��������Աp����Ҫ�� a��b��c��d. 4����ݵ����Ͱ�������������Ա��Ҫѡ��ʲô����·�ߣ�����������·�̵����͡�
 *������ͼ����Ա���������(0,0)������·��ֻ������ͼ�еķ������ʻ��ÿ��С���������Σ��ұ߳�Ϊ1����p��d�ľ������4��
 *�������n�����͵����꣬������������·��ֵ������㿪ʼ���n�������Ͳ��ص���ʼ��ľ��룩�� 
 */
public class Main {

	static class Point {
		int x;
		int y;
		boolean flag;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getDistance(Point point) {
			return Math.abs(x - point.x) + Math.abs(y - point.y);
		}
	}

	public static int num = 0;
	public static int min = Integer.MAX_VALUE;
	public static final Point START = new Point(0, 0);
/**
 * 
 * @param start ���
 * @param points Ҫ�����ĵ㼯
 * @param sum   ·���ĳ��Ⱥ�
 * @param count  �Ѿ������ĵ�������
 * @return ���·������
 */
	public static int calMin(Point start, Point[] points, int sum, int count) {
		if (count == num) {
			min = Math.min(min, sum + start.getDistance(START));
			return min;
		}
		for (int i = 0; i < points.length; i++) {
			if (points[i].flag == false) {
				sum += start.getDistance(points[i]);
				if (sum < min) {
					points[i].flag = true;
					calMin(points[i], points, sum, count + 1);
				}
				sum -= start.getDistance(points[i]);
				points[i].flag = false;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		sc.nextLine();
		Point[] points = new Point[num];
		String str;
		for (int i = 0; i < num; i++) {
			str = sc.nextLine().trim();
			System.out.println(str);
			points[i] = new Point(Integer.parseInt(str.split(",")[0]), Integer.parseInt(str.split(",")[1]));
		}
		System.out.println(calMin(START, points, 0, 0));
		sc.close();
	}

	/*static class Point {
		int x, y;
		boolean flag;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
			this.flag = false;
		}

		public int getLength(Point point) {
			return Math.abs(this.x - point.x) + Math.abs(this.y - point.y);
		}
	}

	static int mp = Integer.MAX_VALUE;

	final static Point sp = new Point(0, 0);

	public static void caculate(Point start, Point[] points, int sum, int count) {

		for (int i = 0; i < points.length; i++) {
			if (points[i].flag == false) {
				points[i].flag = true;
				count++;
				sum += start.getLength(points[i]);
				if (count == points.length) {
					sum += points[i].getLength(sp);
					if (sum < mp) {
						mp = sum;
					}
				}
				caculate(points[i], points, sum, count);
				points[i].flag = false;
				count--;
				sum -= start.getLength(points[i]);
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine().trim());
		Point[] points = new Point[num];
		for (int i = 0; i < num; i++) {
			String[] locations = sc.nextLine().trim().split(",");
			points[i] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
		}
		caculate(new Point(0, 0), points, 0, 0);
		System.out.println(mp);
		sc.close();
	}*/

}
