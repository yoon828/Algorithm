package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 카드의 개수 N 개
 * String 배열을 두개 만들기
 * 1. 홀수이면 N/2+1 크기의 배열, N/2크기의 배열 // 짝수이면 N/2 크기 배열 2개 
 * 2. 각 배열에 저장하기 
 * 3. 번갈아가면서 출력하기
 * 
 * 어디에 담을건지
 * 언제 담을건지
 * 원본을 변경할건지
 * 홀수 처리를 어떻게 할건지
 */
public class D3_3499_1 {
	public static void print(String[] fir, String[] sec) {
		for (int i = 0; i < fir.length; i++) {
			System.out.print(fir[i] + " ");
			if (i < sec.length ) {
				System.out.print(sec[i] + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input_D3_3499.txt"));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= tc; test_case++) {
			// 총 카드의 개수
			int N = Integer.parseInt(br.readLine());
			
			int x = N % 2 == 0 ? N / 2 : N / 2 + 1;
			int y = N / 2;
			String[] fir = new String[x];
			String[] sec = new String[y];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				if (i<x) {
					fir[i] =st.nextToken();
				} else {
					sec[i - x] = st.nextToken();
				}
			}
			
			for (String string : fir) {
				System.out.print(string+" ");
			}
			System.out.println();
			
			System.out.printf("#%d ", test_case);
			print(fir, sec);

		}
	}
}
