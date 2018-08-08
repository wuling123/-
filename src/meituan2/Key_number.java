package meituan2;

import java.util.Scanner;

public class Key_number {
	public static String[][] s=new String[3][3];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s[0][0] = "@!:";
		s[0][1] = "ABC";
		s[0][2] = "DEF";
		s[1][0] = "GHI";
		s[1][1] = "JKL";
		s[1][2] = "MNO";
		s[2][0] = "PQRS";
		s[2][1] = "TUV";
		s[2][2] = "WXYZ";
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.println(num(sc.next()));
		}
		sc.close();
	}

	public static int num(String str) {
		int sum = 0;
		int arr[] = new int[2];
		int arr2[] = new int[2];
		sum = Math.abs(loc(str.charAt(0))[0]) + Math.abs(loc(str.charAt(0))[1]);
		for (int i = 1; i < str.length(); i++) {
			arr = loc(str.charAt(i));
			arr2 = loc(str.charAt(i - 1));
			sum += Math.abs(arr[0] - arr2[0]) + Math.abs(arr[1] - arr2[1]);
		}
		return sum;
	}

	public static int[] loc(char c) {
		/*
		 * if(s[0][0].contains(String.valueOf(c))) return new int[]{0,0};
		 * if(s[0][1].contains(String.valueOf(c))) return new int[]{0,1};
		 * if(s[0][2].contains(String.valueOf(c))) return new int[]{0,2};
		 * if(s[1][0].contains(String.valueOf(c))) return new int[]{1,0};
		 * if(s[1][1].contains(String.valueOf(c))) return new int[]{1,1};
		 * if(s[1][2].contains(String.valueOf(c))) return new int[]{1,2};
		 * if(s[2][0].contains(String.valueOf(c))) return new int[]{2,0};
		 * if(s[2][1].contains(String.valueOf(c))) return new int[]{2,1};
		 * if(s[2][2].contains(String.valueOf(c))) return new int[]{2,2};
		 */
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (s[i][j].contains(String.valueOf(c)))
					return new int[] { i, j };
			}
		}
		return new int[] { -100, -100 };
	}

}
