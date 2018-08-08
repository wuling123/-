package alibaba;

import java.util.Arrays;
import java.util.Scanner;



public class Min {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[] a=new int[n+m+1];
		long sum=0;
		int[] b = Arrays.copyOf(a,n+m+1);
		for (int i = 1; i < n+1; i++) {
			a[i]=-sc.nextInt();
			b[i]=-a[i];
		}for (int i = n+1; i < n+m+1; i++) {
			a[i]=sc.nextInt();
			b[i]=a[i];
		}
		Arrays.sort(a);
		int x=a[(n+m+1)/2];
		for (int i = 1; i < n+1; i++) {
			sum+=Math.abs(-b[i]-x);
		}for (int i = n+1; i < n+m+1; i++) {
			sum+=Math.abs(b[i]-x);
		}
		sum+=Math.abs(x);
		System.out.println(sum);
		sc.close();
	}
}
