package meituan;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner  sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m = sc.nextInt();
		int[] a= new int[2*n+1];
		int[] b= new int[2*m+1];
		double min=0;
		int sum=0;
		for (int i = 1; i <= n; i++) {
			a[2*i-1]=sc.nextInt();
			a[2*i]=sc.nextInt();
			sum+=a[2*i-1];
			min+=a[2*i]==1?(0.8*a[2*i-1]):a[2*i-1];
		}
		for (int i = 1; i <= m; i++) {
			b[2*i-1]=sc.nextInt();
			b[2*i]=sc.nextInt();
			min=min<(sum-((sum/b[2*i-1])>0?1:0)*b[2*i])?min:(sum-((sum/b[2*i-1])>0?1:0)*b[2*i]);
		}
		System.out.println(String.format("%.2f", min).toString());
		sc.close();
	}

}
