package pinduoduo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PRO3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
//		while (sc.hasNextInt()) {
//			list.add(sc.nextInt());
//		}

		String[] str=sc.nextLine().split("\\s+");
		for (int i = 0; i < str.length; i++) {
			list.add(Integer.parseInt(str[i]));
		}
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		for(Integer t:list) {System.out.println(t);}
		int len = list.size();
		int[] flag = new int[len];
		int ans = 0;
		//System.out.println(list.get(2));
		for (int i = 0; i < len; ++i) {
			if (flag[i] == 1)
				continue;
			if (list.get(i) == 100) {
				ans += (len - i) / 3 + 1;
				break;
			}
			if (list.get(i) + list.get(len - 1) > 300) {
				++ans;
				flag[i] = 1;
				continue;
			}
			for (int j = i + 1; j < len; ++j) {
				if (list.get(i) + list.get(j) <= 300 && flag[j] == 0) {
					flag[j] = 1;
					flag[i] = 1;
					++ans;
					break;
				}
			}
			if (flag[i] == 0) {
				++ans;
				flag[i] = 1;
			}
		}
		System.out.println(ans);
		sc.close();
}

}
