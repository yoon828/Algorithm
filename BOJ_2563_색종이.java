package com.ssafy.im;

import java.util.Scanner;

public class BOJ_2563_색종이_김윤민 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [][] arr= new int[100][100];
		int n = sc.nextInt();
		
		for (int i = 0; i <n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					arr[j][k]=1;
				}
			}
		}
		int cnt=0;
		for (int[] is : arr) {
			for (int z : is) {
				if(z ==1) cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
