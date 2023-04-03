package com.ssafy.im;

import java.util.Scanner;

/*
 * 1. 입력값을 배열에 저장
 * 2. 원소 하나씩 탐색 시작
 * => 인덱스를 하나씩 줄여가면서 자신보다 더 값이 크거나 (같은) 경우 찾아서 저장 
 * ==> 시간 초과
 */
public class BOJ_2493_3 {
	static int[] tops;
	static int[] rec;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		tops = new int[N];
		rec = new int[N];

		for (int i = 0; i < N; i++) {
			tops[i] = sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i-1 ; j >=0; j--) {
				if(tops[j] > tops[i]) {
					rec[i] = j+1; 
					break;
				}
			}
			
		}

		for (int i = 0; i < N; i++) {
			System.out.print(rec[i]+" ");
			 
		}
	}

}
