package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2669_직사각형네개의합집합의면적구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] arr = new int[101][101];
		for (int i = 0; i < 4; i++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int p = Integer.parseInt(str[2]);
			int q = Integer.parseInt(str[3]);

			for (int j = y; j < q; j++) {
				for (int k = x; k < p; k++) {
					arr[j][k] = 1; //직사각형 범위 안에 있으면 1로 
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (arr[i][j] == 1) //1의 개수 세기
					cnt++;
			}
		}
		System.out.println(cnt);
	}

}
