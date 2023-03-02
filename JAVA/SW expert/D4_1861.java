package com.ssafy.im;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * 2차원 배열
 * 각 칸에는 n제곱 이하의 수가 적혀있음
 * 상하좌우로 이동이 가능한데, 이동하면 1. 방이 존재 2. 현재 방+1 이여야한다.
 * 어떤 수가 있는 방에서 시작을 해야지 가장 많이 이동할 수 있는지 구하기
 * 
 * 1. 완전 탐색 
 * 2. 0,0부터 탐색 시작
 * 3 .
 *  => 상하좌우 탐색하면서 (본인+1)이 있는지 확인
 * 4. 있으면 cnt+1 후 이동 , 3번 반복   
 * 5. 없으면 cnt변수와 max값이랑 비교 후 종료
 */
public class D4_1861 {
	public static int max;
	public static int val;
	public static int cnt;
	public static int N;
	public static int[][] map;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void move(int x, int y) {
		for (int i = 0; i < dr.length; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				// 현재보다 1이 더 큰 칸을 찾으면
				if (map[nx][ny] == map[x][y] + 1) {
					cnt++;
					move(nx, ny);
					return;
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input_D4_1861.txt"));
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int test_case = 1; test_case <=tc; test_case++) {
			N = sc.nextInt();
			map = new int[N][N];
			max = -1;
			val = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 1;
					// 재귀함수 호출
					move(i, j);
					if (cnt > max) {
						max = cnt;
						val = map[i][j];
					} else if (cnt == max && val > map[i][j]) {
						val = map[i][j];
					}
				}
			}

			System.out.printf("#%d %d %d\n", test_case, val, max);
		}

	}
}
