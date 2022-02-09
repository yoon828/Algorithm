package com.ssafy.im;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/*
 * 중위 표기식을 후위 표기식으로 변경하기
 */

public class D4_1224 {
	static Map<String, Integer> hm;

	public static StringBuilder postChange(String str) {
		Stack<String> stack = new Stack<String>();
		StringBuilder sb = new StringBuilder();
		String st = "";
		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			st = Character.toString(str.charAt(i));
			// 연산자이면 스택 검사하기
			// 여는 괄호이면
			if (st.equals("(")) {
				cnt++;
				String temp = "";
				// 닫는 괄호를 만날때까지
				while (true) {
					// 열린 괄호와 닫는 괄호의 수가 맞으면 while문 빠져나가기
					st = Character.toString(str.charAt(++i));
					if (st.equals("("))
						cnt++;
					else if (st.equals(")"))
						cnt--;
					if (cnt == 0)
						break;
					temp = temp + st;
				}
//				System.out.println(temp);
				sb.append(postChange(temp));

			} else if (st.equals("*") || st.equals("+")) {
				while (!stack.isEmpty()) {
					// 같을때
					if (hm.get(stack.peek()) == hm.get(st)) {
						sb.append(stack.pop());
						break;
					}
					// top이 더 클때
					else if (hm.get(stack.peek()) > hm.get(st)) {
						sb.append(stack.pop());
					} else {
						break;
					}
				}
				stack.push(st);

			} else { // 아니면 (숫자이면 ) sb에 추가
				sb.append(st);
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input_D4_1224.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		hm = new HashMap<String, Integer>();
		hm.put("+", 1);
		hm.put("*", 2);

		int tc = 10;

		for (int test_case = 1; test_case <= tc; test_case++) {
			sb = new StringBuilder();
			Stack<Integer> nums = new Stack<Integer>();
			int n = sc.nextInt();
			String str = sc.next();
			String st = null;
			// 후위표기법으로 변환
			sb = postChange(str);
//			System.out.println(sb);

			for (int i = 0; i < sb.length(); i++) {
				String ele = Character.toString(sb.charAt(i));
				// 연산자면
				if (ele.equals("+") || ele.equals("*")) {
					int num2 = nums.pop();
					int num1 = nums.pop();
					switch (ele) {
					case "+":
						nums.push(num1 + num2);
						break;
					case "*":
						nums.push(num1 * num2);
						break;
					}
				} else { // 숫자면 스택에 넣기
					nums.push(Integer.parseInt(ele));
				}
			}
			System.out.printf("#%d %d\n", test_case, nums.pop());
		}

	}

}
