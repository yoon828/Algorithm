package com.ssafy.im;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
/*
 * 중위 표기식을 후위 표기식으로 변경하기
 */

public class D4_1223 {

	public static void main(String[] args) throws FileNotFoundException {
		Map<String, Integer> hm = new HashMap<String, Integer>();
		System.setIn(new FileInputStream("input_D4_1223.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		hm.put("+", 1);
		hm.put("*", 2);

		int tc = 10;

		for (int test_case = 1; test_case <= tc; test_case++) {
			sb = new StringBuilder();
			Stack<String> stack = new Stack<String>();
			int n = sc.nextInt();
			String str = sc.next();
			String st = null;
			// 후위표기법으로 변환
			for (int i = 0; i < n; i++) {
				st = Character.toString(str.charAt(i));
				// 연산자이면 스택 검사하기
				if (st.equals("*") || st.equals("+")) {
					while (!stack.isEmpty()) {
						// 같을때는 pop
						if (hm.get(stack.peek()) == hm.get(st)) {
							sb.append(stack.pop());
							break;
						}
						// top이 더 클때는 스택에 남아있는 연산자를 모두 pop
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
			//후위표기법 변환 후 계산
			Stack<Integer> nums = new Stack<Integer>();

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
