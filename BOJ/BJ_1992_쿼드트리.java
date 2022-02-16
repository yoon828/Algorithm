import java.io.*;

public class BJ_1992_쿼드트리 {
	public static StringBuilder sb = new StringBuilder();
	public static int[][] video;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input_BJ_1992.txt"));

		int N = Integer.parseInt(br.readLine());
		video = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				video[i][j] = str.charAt(j) - '0';
			}
		}

		zip(N, 0, 0);
		System.out.println(sb);

	}

	private static void zip(int n, int startX, int startY) {
		int value = video[startX][startY];
		if (n == 1) {
			sb.append(value);
			return;
		}
		boolean ch = true;// true면 모든 수가 같음. 4분할 할 필요 없음
		for (int i = startX; i < startX + n; i++) {
			for (int j = startY; j < startY + n; j++) {
				if (ch && video[i][j] != value) {
					ch = false;
					break;
				}
			}
		}
		if (ch) {
			sb.append(value);
			return;
		} else {
			sb.append("(");
			zip(n / 2, startX, startY); // 좌상 분면
			zip(n / 2, startX, startY + n / 2); // 우상분면
			zip(n / 2, startX + n / 2, startY); // 좌하분면
			zip(n / 2, startX + n / 2, startY + n / 2); // 우하분면
			sb.append(")");
		}

	}
}
