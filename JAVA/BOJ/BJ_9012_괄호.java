package D0310;

import java.io.*;
import java.util.*;

public class BJ_9012_괄호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			boolean check = false;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == '(') //여는 괄호면 stack에 추가
					stack.add(ch);
				else { // 닫는 괄호면
					if (stack.size() > 0) //스택의 크기가 0이 아닌경우 pop하기
						stack.pop();
					else { //스택의 크기가 0이면 여는 괄호가 없는 상태에서 닫는 괄호가 나온 것이므로 vps가 아님
						check = true;
						break;
					}
				}
			}
			if (check || stack.size()>0) //check가 true이거나 스택에 아직 여는 괄호가 남아있는 경우 NO
				sb.append("NO\n");
			else
				sb.append("YES\n");
		}
		System.out.println(sb);
	}

}
