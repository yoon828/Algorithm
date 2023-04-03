package study_mar;

import java.io.*;

public class BJ_2675_문자열반복 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String[] str = br.readLine().split(" ");
			int R = Integer.parseInt(str[0]);
			String S = str[1];
			for (int i = 0; i < S.length(); i++) {
				char ch = S.charAt(i);
				for (int j = 0; j < R; j++) {
					System.out.print(ch);
				}
			}
			System.out.println();
		}
		
	}
}
