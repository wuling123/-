package alibaba;

import java.util.*;

public class Qiudui {
	static class Info {
		private String name;
		private int scores;
		private int goals;
		private int winGoals;

		public Info(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getScores() {
			return scores;
		}

		public void setScores(int scores) {
			this.scores = scores;
		}

		public int getGoals() {
			return goals;
		}

		public void setGoals(int goals) {
			this.goals = goals;
		}

		public int getWinGoals() {
			return winGoals;
		}

		public void setWinGoals(int winGoals) {
			this.winGoals = winGoals;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int times = 0; times < 4; times++) {
			Map<String, Info> group = new HashMap<>();
			for (int i = 0; i < 7; i++) {
				if (times == 3 && i == 6)
					break;
				String str = sc.nextLine();
				if (str.matches("\\s*"))
					continue;
				String[] s = str.split(" ");
				String[] bifen = s[1].split(":");
				int a = Integer.parseInt(bifen[0]);
				int b = Integer.parseInt(bifen[1]);
				Info info;
				if (!group.containsKey(s[0])) {
					info = new Info(s[0]);
					info.setGoals(a);
					info.setScores(a > b ? 3 : (a == b ? 1 : 0));
					info.setWinGoals(a - b);
					group.put(s[0], info);
				} else {
					info = group.get(s[0]);
					info.setGoals(a + info.getGoals());
					info.setScores((a > b ? 3 : (a == b ? 1 : 0)) + info.getScores());
					info.setWinGoals(a - b + info.getWinGoals());
				}
				if (!group.containsKey(s[2])) {
					info = new Info(s[2]);
					info.setGoals(b);
					info.setScores(b > a ? 3 : (a == b ? 1 : 0));
					info.setWinGoals(b - a);
					group.put(s[2], info);
				} else {
					info = group.get(s[2]);
					info.setGoals(b + info.getGoals());
					info.setScores((b > a ? 3 : (a == b ? 1 : 0)) + info.getScores());
					info.setWinGoals(b - a + info.getWinGoals());
				}
			}
			List<Info> list = new ArrayList<>();
			for (Info info : group.values()) {
				list.add(info);
			}
			Collections.sort(list, new Comparator<Info>() {
				public int compare(Info team1, Info team2) {
					int x = team1.getScores() - team2.getScores();
					int y = team1.getWinGoals() - team2.getWinGoals();
					int z = team1.getGoals() - team2.getGoals();
					if (x != 0) {
						return x > 0 ? -1 : 1;
					}
					if (y != 0) {
						return y > 0 ? -1 : 1;
					}
					if (z != 0) {
						return z > 0 ? -1 : 1;
					}
					return team1.name.compareTo(team2.name);
				}
			});
			for (Info result : list) {
				System.out.print(result.getName() + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}