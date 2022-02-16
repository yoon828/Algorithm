import java.io.*;
import java.util.*;

/*
 * M :총 이동시간, A : BC의 개수, C : 충전 범위 , P : BC의 성능 
 * 0 : 이동 x , 1: 상 , 2: 우 , 3: 하, 4:좌
 */
public class SW_5644_무선충전 {
	public static int[][] list;

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("input_SW_5644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] move = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			long startT = System.nanoTime();
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			// 이동 시간과 충전기 개수 저장
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());

			int[] aMap = new int[M + 1]; // A사용자의 이동 정보
			int[] bMap = new int[M + 1]; // B사용자의 이동 정보
			// A의 이동 정보 저장
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				aMap[i] = Integer.parseInt(st.nextToken());
			}
			// B의 이동 정보 저장
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				bMap[i] = Integer.parseInt(st.nextToken());
			}

			list = new int[A][4]; // 충전기 정보를 저장할 배열 //열, 행, 범위, 충전량 순
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					list[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[] aP = { 1, 1 }; // 행, 열 순
			int[] bP = { 10, 10 };

			int sumTotal = 0;
			// 이동 횟수만큼 반복
			for (int m = 0; m <= M; m++) {
				int max = -1;
				// 충전기 횟수만큼 이중 반복. 완전 탐색
				for (int i = 0; i < A; i++) {
					for (int j = 0; j < A; j++) {
						int sum = 0;
						// 둘다 충전할 곳이 없는 경우
						if (!checkIn(aP[0], aP[1], i) && !checkIn(bP[0], bP[1], j))
							continue;
						// A만 충전할 곳이 있는 경우
						else if (checkIn(aP[0], aP[1], i) && !checkIn(bP[0], bP[1], j)) {
							sum = list[i][3];
						} // B만 충전할 곳이 있는 경우
						else if (!checkIn(aP[0], aP[1], i) && checkIn(bP[0], bP[1], j)) {
							sum = list[j][3];
						}
						// 둘다 충전할 곳이 있는 경우
						else if (checkIn(aP[0], aP[1], i) && checkIn(bP[0], bP[1], j)) {
							if (i == j) // A충전기와 B충전기가 같은 경우는 절반 나눠서 충전
								sum = list[i][3];
							else
								sum = list[i][3] + list[j][3];
						}
						max = Math.max(max, sum);
					}
				}
				sumTotal += max != -1 ? max : 0;
				// 위치 이동 해주기
				for (int i = 0; i < 2; i++) {
					aP[i] = aP[i] + move[aMap[m]][i];
					bP[i] = bP[i] + move[bMap[m]][i];
				}

			}
			System.out.printf("#%d %d\n", test_case, sumTotal);
			long endT = System.nanoTime();
//			System.out.println((endT - startT) / 1000000000.0);
		}
		br.close();
	}

	public static boolean checkIn(int x, int y, int i) {
		return Math.abs(x - list[i][1]) + Math.abs(y - list[i][0]) <= list[i][2];
	}

}
