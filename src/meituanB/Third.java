package meituanB;

import java.util.Scanner;

public class Third {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		char[] cs = line.toCharArray();
		if (cs.length == 1) {
			System.out.print(1);
			return;
		}
		int sum = 1;
		int index =0;
		boolean flag=true;
		for (int i = 1; i <cs.length; i++) {
			if (cs[i] == '1') {
				if(flag==true) {
					index=i;
					flag=false;
				}
				sum++;
			}
		}
		if(line.matches("[1]{1}[0]*[1]*"))sum = sum - 1 + (cs.length - 1 + 1) * (cs.length - 1) / 2;
		else
		sum = 1 +cs.length-1-index-1 + (cs.length - 1 + 1) * (cs.length - 1) / 2;
		System.out.println(sum);
		//System.out.println(index);
		sc.close();
	}
}
