package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/* 
 * stack 사용
 * 1. 입력값을 하나씩 검사하기
 * 2. 
 * 3. 
 * 4. 
 * 
 */
public class BOJ_2493 {
	static String str = "5\n" + "6 9 5 7 4";

	public static void main(String[] args) {
		Stack<int[]> topStack = new Stack<int[]>();
		Scanner sc = new Scanner(str);
		int N = sc.nextInt();
        		int num=0; 


		for (int i = 0; i < N; i++) {
			num = sc.nextInt();
			
			while (!topStack.isEmpty()) {
				// top 보다 현재의 높이가 더 크다면 pop후 스택에 추가
				if (topStack.peek()[1] <= num) {
					topStack.pop();
				} else { // top보다 현재 높이가 더 작다면 top출력 후 스택에 추가
					System.out.print(topStack.peek()[0] + " ");
					break;
				}
				
			}
			
			if(topStack.isEmpty()) {
				System.out.print("0 ");
			}
			topStack.push(new int[]{i+1, num});
		}

	}


}
