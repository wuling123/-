package PrimarySchool;

import java.util.Scanner;

public class ArrayPrint {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = (int) Math.ceil(Math.sqrt(n));
		int[][] a = new int[k][k];
		int i, j, flag, num;
		flag = 1;
		if (k % 2 == 1)
			i = j = (k - 1) / 2;
		else
			i = j = k / 2 - 1;
		for (num = 1; num <= n; num++) {
			a[i][j] = num;
			if(n==1)break;
			if (flag == 1) {
				if (a[i][j + 1] == 0) {
					j++;
					flag = 2;
				} else {
					i--;
				}
			} else if (flag == 2) {
				if (a[i + 1][j] == 0) {
					i++;
					flag = 3;
				} else {
					j++;
				}
			} else if (flag == 3) {
				if (a[i][j - 1] == 0) {
					j--;
					flag = 4;
				} else {
					i++;
				}
			} else {
				if (a[i - 1][j] == 0) {
					i--;
					flag = 1;
				} else {
					j--;
				}
			}
		}
		for (int l = 0; l < a.length; l++) {
			for (int l2 = 0; l2 < a.length; l2++) {
				if (a[l][l2] == 0)
					System.out.print("    ");
				else
					System.out.printf("%-4d", a[l][l2]);
			}
			System.out.println("");
		}
		sc.close();
	}

	/*
	 * Scanner sc = new Scanner(System.in); int n = sc.nextInt(); int k = (int)
	 * Math.ceil((double) Math.sqrt((double) n));
	 * 
	 * int[][] a = new int[k][k]; for (int x = 0; x < k; ++x) { for (int y = 0; y <
	 * k; ++y) { a[x][y] = -1; } } int num = 1;
	 * 
	 * int flag = 4;
	 * 
	 * int i; int j;
	 * 
	 * if ((k & 1) != 0) { i = k / 2; j = k / 2; } else { i = k / 2 - 1; j = k / 2 -
	 * 1; }
	 * 
	 * while (true) { if (num > n) break; if (a[i][j] == -1) a[i][j] = num++;
	 * 
	 * if (flag == 1) { if (a[i + 1][j] == -1) { i++; flag = 2; } else j++; }
	 * 
	 * else if (flag == 2) { if (a[i][j - 1] == -1) { j--; flag = 3; } else i++; }
	 * else if (flag == 3) { if (a[i - 1][j] == -1) { i--; flag = 4; } else j--; }
	 * else // flag == 4 { if (a[i][j + 1] == -1) { j++; flag = 1; } else i--; } }
	 * for (int i1 = 0; i1 < k; i1++) { for (int j1 = 0; j1 < k; j1++) { //
	 * System.out.print(" ");
	 * 
	 * if (a[i1][j1] != -1) System.out.printf("%-4d", a[i1][j1]); else
	 * System.out.print(" "); } System.out.println(""); } }
	 */
	/*
	 * public int[][] getArr(int[][] arr,int direction,int n){ int count=1; int x=0;
	 * int y=0; final int UP=0,RIGHT=1,DOWN=2,LEFT=3; //获得x,y的初始值 switch
	 * (direction){ case UP: { x=n/2; y=(n-1)/2; break; } case RIGHT: { x=(n-1)/2;
	 * y=(n-1)/2; break; } case DOWN: { x=(n-1)/2; y=n/2; break; } case LEFT: {
	 * x=n/2; y=n/2; break; } } for(int i=1;i<=n;i++){ for (int j=1;j<=2*i &&
	 * count<=n*n;j++){ arr[x][y]=count++; direction=direction%4; if (direction==UP)
	 * {x--;} else if (direction==RIGHT) {y++;} else if (direction==DOWN) {x++;}
	 * else if (direction==LEFT) {y--;} if (j%i==0) direction=direction+1; } }
	 * return arr; } public void printSpiralPhalanx(int[][] arr,int n){ for(int
	 * i=0;i<n;i++){ for(int j=0;j<n;j++){ System.out.print("\t"+arr[i][j]); }
	 * System.out.println(); } } public static void main(String[] args) throws
	 * Exception{ Scanner sc=new Scanner(System.in);
	 * System.out.print("请输入螺旋方阵的行数：  "); int n=sc.nextInt();
	 * System.out.print("请输入螺旋方阵起始方向（UP=0,RIGHT=1,DOWN=2,LEFT=3）：  "); int
	 * direction=sc.nextInt(); int[][] arr=new int[n][n]; ArrayPrint sprial=new
	 * ArrayPrint(); sprial.getArr(arr, direction, n);
	 * sprial.printSpiralPhalanx(arr, n); }
	 */
}
