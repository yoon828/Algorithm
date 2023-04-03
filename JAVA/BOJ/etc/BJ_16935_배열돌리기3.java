package com.ssafy;

import java.util.Scanner;

/*
 *  1번 연산 :  상하 반전
 *  2번 연산 :  좌우 반전
 *  3번 연산 :  오른쪽 90도 회전
 *  4번 연산 :  오른쪽 90도 회전
 *  5번 연산 :  구역 나눠서 구역별 오른쪽 회전
 *  6번 연산 :  구역 나눠서 구역별 왼쪽 회전
 *  
 */

public class BJ_16935_배열돌리기3 {
	public static int N;
	public static int M;
	public static int R;
	public static int[][] temp;
	static int[] dr;
	static int[] dc;

	public static void print(int[][] arr) {
		for (int[] is : arr) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < R; i++) {
			int mode = sc.nextInt();
			arr = rotate(arr, mode);
		}
		print(arr);
	}

	public static int[][] rotate(int[][] arr, int mode) {
		//90도 회전시 N,M이 바뀔수도 있으니 항상 확인하기
		N = arr.length;
		M = arr[0].length;
		//새로운 배열을 저장할 배열
		temp = new int[N][M];
		//실제 범위를 위한 변수
		int n = N - 1;
		int m = M - 1;
		//크기의 절반
		int midN = N / 2;
		int midM = M / 2;
		//그룹 배열시 시작 위치 저장 
		int starts[][] = { { 0, 0 }, { 0, midM }, { midN, 0 }, { midN, midM } };

		if (mode == 1 || mode == 2) {
			for (int j = 0; j < M; j++) {
				for (int i = 0; i < N; i++) {
					//mode에 따라서 다르게 실행
					if (mode == 1)
						temp[n - i][j] = arr[i][j];
					if (mode == 2)
						temp[i][m - j] = arr[i][j];
				}
			}
		} else if (mode == 3 || mode == 4) {
			temp = new int[M][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					//mode에 따라서 다르게 실행
					if (mode == 3)
						temp[j][n - i] = arr[i][j];
					if (mode == 4)
						temp[m - j][i] = arr[i][j];
				}
			}
		} else if (mode == 5 || mode == 6) {
			//그룹은 1, 2, 3, 4 순으로 이동을 하기 때문에 그에 맞는 방향을 다르게 해줘야함
			if (mode == 5) {
				dr = new int[] { 0, 1, -1, 0 };
				dc = new int[] { 1, 0, 0, -1 };
			} else if (mode == 6) {
				dr = new int[] { 1, 0, 0, -1 };
				dc = new int[] { 0, -1, 1, 0 };
			}
			for (int groups = 0; groups < 4; groups++) {
				int x = 0;
				int y = 0;
				// 그룹마다 시작 위치를 다르게 설정
				//시작 위치부터 반목분 시작
				for (int i = starts[groups][0]; i < starts[groups][0] + midN; i++) {
					for (int j = starts[groups][1]; j < starts[groups][1] + midM; j++) {
						//방향에 맞춰서 temp의 자리를 지정
						x = i + midN * dr[groups];
						y = j + midM * dc[groups];
						temp[x][y] = arr[i][j];
					}
				}

			}
		}
		return temp;
	}

}
