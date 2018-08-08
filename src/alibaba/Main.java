package alibaba;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String[][] str = { { "._.", "|.|", "|_|" }, { "...", "..|", "..|" }, { "._.", "._|", "|_." },
				{ "._.", "._|", "._|" }, { "...", "|_|", "..|" }, { "._.", "|_.", "._|" }, { "._.", "|_.", "|_|" },
				{ "._.", "..|", "..|" }, { "._.", "|_|", "|_|" }, { "._.", "|_|", "..|" } };
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		for (int j = 0; j < 3; j++) {
			String st = "";
			for (int i = 0; i < s.length(); i++) {
				int k = Integer.parseInt(s.substring(i, i+1));
				st += str[k][j] + " ";
			}
			st = st.trim();
			System.out.println(st);
		}
		sc.close();
	}

}
