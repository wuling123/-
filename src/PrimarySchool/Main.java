package PrimarySchool;

import java.util.Scanner;
/**
 * 
 * @author Administrator
 *DFS		深度优先算法计算最短路径
 *如下图，某物流派送员p，需要给 a、b、c、d. 4个快递点派送包裹，请问派送员需要选择什么样的路线，才能完成最短路程的派送。
 *假设如图派送员的起点坐标(0,0)，派送路线只能沿着图中的方格边行驶，每个小格都是正方形，且边长为1，如p到d的距离就是4。
 *随机输入n个派送点坐标，求输出最短派送路线值（从起点开始完成n个点派送并回到起始点的距离）。 
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
 * @param start 起点
 * @param points 要遍历的点集
 * @param sum   路径的长度和
 * @param count  已经遍历的点数个数
 * @return 最短路径长度
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
