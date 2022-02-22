package com.ssafy.im;

import java.io.*;
import java.util.*;

public class BJ_2635_수이어가기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		List<Integer> copy = new ArrayList<>();

		int max = 0;
		for (int i = N; i >= 1; i--) { //N부터 1까지 하나씩 두번째 수로 선택하기
			list.add(N);
			list.add(i);
			while (true) {
				int n = list.get(list.size() - 2) - list.get(list.size() - 1); //i-1 - i-2를 구해서 음수인지 체크
				if (n < 0)
					break;
				else
					list.add(n);
			}
			if(max < list.size()) { //최대 크기 업데이트
				max = list.size();
				copy.clear();
				copy.addAll(list); //최대 크기이면 배열 복사
			}
			list.clear(); //배번 초기화 해주기
		}
		sb.append(max);
		sb.append("\n");
		for (Integer i : copy) {
			sb.append(i);
			sb.append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
