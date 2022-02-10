package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_1233_사칙연산유효성검사_김윤민 {
	public static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = 10;
		for (int test_case = 1; test_case <= tc; test_case++) {
			N = Integer.parseInt(br.readLine());
			int result = 1;
			for (int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				if(str[1].equals("+")||str[1].equals("-")||str[1].equals("*")||str[1].equals("/")) {
					if(str.length!=4) {
						result = 0; 
					}
				}else {
					if(str.length !=2) {
						result = 0; 
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, result);
		}

	}

}
