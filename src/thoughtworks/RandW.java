package thoughtworks;

import java.util.Scanner;

public class RandW {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int m;
		try {
			n = sc.nextInt();
			m = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid number format.");
			sc.close();
			return;
		}
		if (n < 0 || m < 0) {
			System.out.println("Number out of range.");
			sc.close();
			return;
		}
		String[] sp;
		try {
			sc.nextLine();
			String str = sc.nextLine();
			sp = str.split(";");
		} catch (Exception e) {
			System.out.println("Incorrect command format.");
			sc.close();
			return;
		}
		int[][] flag = new int[2 * n + 1][2 * m + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				flag[2 * i + 1][2 * j + 1] = 1;
			}
		}
		int x = 0;
		int y = 0;
		int h = 0;
		int k = 0;
		for (int l = 0; l < sp.length; l++) {
			try {
				x = Integer.parseInt(sp[l].split(" ")[0].split(",")[0]);
				y = Integer.parseInt(sp[l].split(" ")[0].split(",")[1]);
				h = Integer.parseInt(sp[l].split(" ")[1].split(",")[0]);
				k = Integer.parseInt(sp[l].split(" ")[1].split(",")[1]);
			} catch (NumberFormatException e) {
				System.out.println("Invalid number format.");
				sc.close();
				return;
			} catch (Exception e) {
				System.out.println("Incorrect command format.");
				sc.close();
				return;
			}
			if (x < 0 || y < 0 || h < 0 || k < 0 || x > n - 1 || h > n - 1 || y > m - 1 || k > m - 1) {
				System.out.println("Number out of range.");
				sc.close();
				return;
			}
			if (x == h && Math.abs(y - k) == 1)
				flag[x * 2 + 1][2 * Math.min(y, k) + 2] = 1;
			else if (y == k && Math.abs(x - h) == 1)
				flag[2 * Math.min(x, h) + 2][2 * y + 1] = 1;
			else {
				System.out.println("Maze format error");
				sc.close();
				return;
			}
		}
		for (int i = 0; i < 2 * n + 1; i++) {
			for (int j = 0; j < 2 * m + 1; j++) {
				if (flag[i][j] == 0)
					System.out.print("[W] ");
				if (flag[i][j] == 1)
					System.out.print("[R] ");
			}
			System.out.println("");
		}
		sc.close();
		//System.out.println(computeArea(10, 100, 20, 60, 60, 160, 50, 200));
	}
/*static	int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
	    int X1, X2, Y1, Y2;
	    X1 = (A>E)? A : E;
	    X2 = (B<F)? B : F;
	    Y1 = (C>G)? C : G;
	    Y2 = (D<H)? D : H;
	    if(X1 < X2 && Y1 < Y2)
	    return (X2 - X1)*(Y2 - Y1);
	    else return 0;
	}*/
}





