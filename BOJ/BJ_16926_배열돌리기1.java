package com.ssafy;

import java.util.Scanner;

public class BJ_16926_배열돌리기1 {
	public static int N;
	public static int M;
	public static int R;
	public static int[][] temp;

	public static void print(int[][] arr) {
		for (int[] is : arr) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
//		double time = System.nanoTime() / 1000000000.0 
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

		rotate(arr, 0);
	}

	public static void rotate(int[][] arr, int cnt) {
		if(cnt==R) {
			print(arr);
			return;
		}
		
		temp = new int[N][M];
		int lines = Math.min(M, N) / 2;
		int m = M; // M의 범위를 위한 변수 인덱스가 0부터 시작하므로 -1 해주기
		int n = N; // N의 범위를 위한 변수

		// 회전하는 줄의 개수 만큼 반복
		for (int i = 0; i < lines; i++) {
			// 행, 열 범위 ==> i~n, i~m
			m = m - 1;
			n = n - 1;
//			System.out.printf("i:j : %d, %d // m:n : %d, %d\n", start_i,start_j, n,m);
			for (int j = i; j < n; j++) {
				temp[j + 1][i] = arr[j][i];
			}
			for (int j = i; j < m; j++) {
				temp[n][j + 1] = arr[n][j];
			}
			for (int j = n; j > i; j--) {
				temp[j - 1][m] = arr[j][m];
			}
			for (int j = m; j > i; j--) {
				temp[i][j - 1] = arr[i][j];
			}
		}
		
		rotate(temp, cnt+1);
		
	}
}
