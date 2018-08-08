package meituan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();
		int x = 0;
		int y = 0;
		double sum = 0.0;
		double[] w = new double[m];
		double[][] s = new double[n][m];
		double[] max = new double[m];
		double[] scores = new double[n];
		// double[] scores2 = new double[n];
		int[] flag = new int[n];
		for (int i = 0; i < w.length; i++) {
			w[i] = sc.nextInt();
			sum += w[i];
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				s[i][j] = sc.nextInt();
				if (s[i][j] == -1) {
					x = i;
					y = j;
				}
				max[j] = max[j] > s[i][j] ? max[j] : s[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (j == y)
					continue;
				scores[i] += (w[j] / sum) * (max[j] == 0 ? 0 : (s[i][j] / max[j]));
			}
		}
		double mx = max[y];
		for (int j = 0; j < c + 1; j++) {
			s[x][y] = j;
			max[y] = mx > j ? mx : j;
			Map<Integer, Double> map = new TreeMap<Integer, Double>();
			for (int i = 0; i < n; i++) {
				map.put(i, scores[i] + (w[y] / sum) * (max[y] == 0 ? 0 : (s[i][y] / max[y])));
			}
			List<Map.Entry<Integer, Double>> list = new ArrayList<Map.Entry<Integer, Double>>(map.entrySet());
			// 然后通过比较器来实现排序
			Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
				// 降序排序
				public int compare(Entry<Integer, Double> o1, Entry<Integer, Double> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}

			});
			if (k == n) {
				for (int i = 0; i < n; i++) {
					System.out.println(1);
				}
				return;
			}
			for (int i = 0; i < k; i++) {
				if (list.get(i).getValue().equals(list.get(k).getValue()))
					flag[list.get(i).getKey()] = 3;
				else
					flag[list.get(i).getKey()] = flag[list.get(i).getKey()] == 0 ? 1
							: (flag[list.get(i).getKey()] == 1 ? 1 : 3);
			}
			for (int i = k; i < n; i++) {
				if (list.get(i).getValue().equals(list.get(k - 1).getValue()))
					flag[list.get(i).getKey()] = 3;
				else
					flag[list.get(i).getKey()] = flag[list.get(i).getKey()] == 0 ? 2
							: (flag[list.get(i).getKey()] == 2 ? 2 : 3);
			}

		}
		for (int i = 0; i < n; i++) {
			System.out.println(flag[i]);
		}
		sc.close();
	}
}
