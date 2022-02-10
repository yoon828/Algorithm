package com.ssafy.im;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * queue로 구현
 * 1. 1 ~ N 의 숫자를 queue에 넣기  
 * 2. cnt =1 부터 
 * => poll하면서 cnt++하기 , cnt가 3이면 poll한 값을 list에 넣고, cnt를 다시 1로 초기화
 * => 3이 아니라면 poll한 값을 다시 que에 넣기
 * 
 * 4. queue의 size가 0이 될때까지 2반복
 * 5. list출력
 */

public class BOJ_1158_요세푸스문제_김윤민 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> que = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		// 사람 수
		int N = sc.nextInt();
		// 몇번째인지
		int K = sc.nextInt();
		for (int i = 0; i < N; i++) {
			que.offer(i + 1);
		}

		int cnt = 1;
		sb.append("<");
		while (!que.isEmpty()) {
			int temp = que.poll();
			if (cnt == K) {
				sb.append(temp);
				sb.append(", ");
				cnt = 1;
				continue;
			}
			que.offer(temp);
			cnt++;
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);

	}
}
