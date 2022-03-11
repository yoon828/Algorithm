package D0310;

import java.io.*;
import java.util.*;
public class BJ_10799_쇠막대기 {
	public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String str = br.readLine();
	Stack<Character> stack = new Stack<>();
	
	//
	int sum =0; 
	for (int i = 0; i < str.length(); i++) {
		char ch = str.charAt(i);
		if(ch=='(') {
			stack.add(ch);
		}
		else { //바로 직전이 (라면 레이저
			if(str.charAt(i-1)=='(') {
				stack.pop();
				sum+=stack.size();
			}
			else { //아니면 막대기의 끝
				stack.pop(); //막대기가 끝났으므로 stack에서 하나 제거
				sum++; //끝난 조각 하나가 생성되기때문에 1추가
			}
		}
	}
	System.out.println(sum);
	
	}
}
