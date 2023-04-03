import java.io.*;

public class BJ_3109_빵집 {
//	static String str = "5 5\r\n" + ".xx..\r\n" + "..x..\r\n" + ".....\r\n" + "...x.\r\n" + "...x.";

	static int r, c, start, cnt = 0;
	static char[][] map;
	static boolean[] isUsed;
	static int[][] move = { { -1, 1 }, { 0, 1 }, { 1, 1 } }; // 우상, 우, 우하

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new StringReader(str));

		String[] rc = br.readLine().split(" ");
		r = Integer.parseInt(rc[0]);
		c = Integer.parseInt(rc[1]);

		map = new char[r][c];
		isUsed = new boolean[r];

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < r; i++) {
			start = i;
			map[i][0] = '-';
			setPipe(i, 0);
		}
		System.out.println(cnt);

	}

	private static void setPipe(int i, int j) { // 현재 위치
		// 기저 조건, 파이프가 완성 된 경우
		if (j == c - 1) {
			cnt++;
			isUsed[start] = true;
			return;
		}

		for (int k = 0; k < 3; k++) {
			int ni = (i + move[k][0]);
			int nj = (j + move[k][1]);
			if (canUsed(ni, nj)) {
				map[ni][nj] = '-';
				setPipe(ni, nj);
			}
		}

	}

	public static boolean canUsed(int i, int j) {
		if (i >= 0 && i < r && j >= 0 && j < c) { // 인덱스 범위 안에 있는지
			if (map[i][j] == '-' || map[i][j] == 'x' || isUsed[start]) { // 이미 파이프가 있는지 / 건물이 있는지 / 이미 시작 열에서 파이프가
				return false;
			} else {
				return true;

			}
		} else {
			return false;
		}
	}

}
