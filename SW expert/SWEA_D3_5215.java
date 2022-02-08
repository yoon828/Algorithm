package com.ssafy.im;

import java.io.FileInputStream;
import java.util.Scanner;

/* (미완)
 * 1. 맛점수와 칼로리를 
 * 
 * 
 */

public class D3_5215 {
	static int[] score;
	static int[] calo;
	static int max_score; // 점수의 최대값 저장할 변수
	static int N;
	static int L;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_D3_5215.txt"));
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			N = sc.nextInt(); // 재료 수
			L = sc.nextInt(); // 제한 칼로리
			score = new int[N];
			calo = new int[N];
			max_score = -1;

			// 맛 칼로리 저장
			for (int i = 0; i < calo.length; i++) {
				score[i] = sc.nextInt();
				calo[i] = sc.nextInt();
			}

			max_score(0, 0, 0); // 점수 합,

			System.out.printf("#%d %d", test_case, max_score);
		}

	}

	public static void max_score(int cnt, int sum_calo, int sum_score) {
		// 부분 조합 재귀함수
		// 기저
		if (sum_calo > L) {
			return;
		}


		if(sum_score >max_score) {
			max_score = sum_score;
		}
		
		if (cnt == N) {
			return;
		}

		// 유도
		max_score(cnt + 1, sum_calo + calo[cnt], sum_score + score[cnt]);
		max_score(cnt + 1, sum_calo, sum_score);

	}

}
