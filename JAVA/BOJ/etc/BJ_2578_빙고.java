import java.io.*;
import java.util.*;

public class BJ_2578_빙고 {
	public static int N, cnt;
	public static int[][] map;
	public static int[][] posit;
	public static boolean[] row;
	public static boolean[] colm;
	public static boolean ld;
	public static boolean rd;

//	public static void print(int[][] arr) {
//		for (int[] is : arr) {
//			for (int i : is) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//		}
//	}
//
//	public static void print(boolean[] arr) {
//		for (boolean i : arr) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//	}

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("input_BJ_2578.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = 5;
		map = new int[N][N];
		row = new boolean[N];
		colm = new boolean[N];
		posit = new int[26][2]; // i, j

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int idx = Integer.parseInt(st.nextToken());
				map[i][j] = idx;
				posit[idx][0] = i;
				posit[idx][1] = j;
			}
		}
//		print(map);
//		print(posit);
		cnt = 0;
		int callCnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (cnt >= 3) {
					System.out.println(callCnt);
					return;
				}
				int num = Integer.parseInt(st.nextToken());
				callCnt++;
				checkBingo(num);// 부른 숫자를 빙고체크하러 가기
//				print(map);
//				System.out.println("cnt : " + cnt);
//				System.out.println();
			}
		}

	}

	private static void checkBingo(int num) {
//		System.out.println("-----");
		// 숫자의 위치 찾기
		int i = posit[num][0];
		int j = posit[num][1];
//		System.out.println("num : " + num + " // i,j : " + i + ", " + j);

		map[i][j] = 0; // 부른 곳은 0으로 변경

		// 가로 줄이 이미 빙고인지 확인후, 아니면 빙고 인지 확인
		int line = 0;
		if (!row[i]) {
			for (int k = 0; k < 5; k++) {
				if (map[i][k] == 0) {
					line++;
				} else
					break;
			}
			if (line == 5) {
				row[i] = true;
				cnt++;
			}
			line = 0;
		}

		if (!colm[i]) {
			for (int k = 0; k < 5; k++) {
				if (map[k][j] == 0) {

					line++;
				} else
					break;
			}
			if (line == 5) {
				colm[i] = true;
				cnt++;

			}
			line = 0;

		}

		if (i == j && !ld) {
			for (int k = 0; k < 5; k++) {
				if (map[k][k] == 0) {
					line++;
				} else
					break;
			}
			if (line == 5) {
				ld = true;
				cnt++;
			}
			line = 0;
		}
		if (i + j == 4 && !rd) {
			for (int k = 0; k < 5; k++) {
				if (map[k][4 - k] == 0) {
					line++;
				} else
					break;
			}
			if (line == 5) {
				rd = true;
				cnt++;

			}
			line = 0;
		}

	}

}
