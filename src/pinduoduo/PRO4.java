package pinduoduo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//查询最大不重复子串的长度
public class PRO4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int max = 0;
		List<String> s = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			String st = String.valueOf(str.charAt(i));
			if (!s.contains(st)) {
				s.add(st);
			} else {
				max = Math.max(max, s.size());
				int index = s.lastIndexOf(st);
				for (int j = 0; j <= index; j++) {
					s.remove(0);
				}
				s.add(st);
			}
		}
		max = Math.max(max, s.size());
		System.out.println(max);
		sc.close();
		// Thread.holdsLock(sc); //判断是否拥有锁
	}
}
