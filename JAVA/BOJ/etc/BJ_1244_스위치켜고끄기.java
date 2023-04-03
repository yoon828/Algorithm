package com.ssafy.im;

import java.io.*;
import java.util.*;

public class BJ_1244_스위치켜고끄기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] switchs = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			switchs[i] = Integer.parseInt(st.nextToken());
		}

		int S = Integer.parseInt(br.readLine());
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (sex == 1) { // 남자인 경우
				for (int j = 1; j <= N; j++) {
					int db = j * num; // 배수 구하기
					if (db > N)
						break; // 배수가 스위치번호를 넘어가면 반복문 종료
					switchs[db] = Math.abs(switchs[db] - 1); // 토글
				}
			} else { // 여자인 경우
				switchs[num] = Math.abs(switchs[num] - 1); // 자기 번호 토글
				int r=1;
				while (true) {
					if (num - r >= 1 && num + r <= N && switchs[num - r] == switchs[num + r]) {
						switchs[num - r] = Math.abs(switchs[num - r] - 1);
						switchs[num + r] = Math.abs(switchs[num + r] - 1);
						r++;
					}else break;
				}

			}
		}
		for (int i = 1; i <=N; i++) {
			sb.append(switchs[i]);
			if(i%20==0) sb.append("\n");
			else sb.append(" ");
		}
		System.out.println(sb);
	}

}
