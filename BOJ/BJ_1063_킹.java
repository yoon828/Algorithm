package D0227;

import java.io.*;
import java.util.*;

public class BJ_1063_킹 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int[] king = new int[] { str[0].charAt(1), str[0].charAt(0) }; //행 열 
		int[] stone = new int[] { str[1].charAt(1), str[1].charAt(0) };
		int N = Integer.parseInt(str[2]);
		
		for (int i = 0; i < N; i++) {
			String ch = br.readLine();
			int[] move = new int[2];  //입력에 따라서 이동할 move배열 설정
			if(ch.equals("R")) move = new int[]{0,1};
			else if(ch.equals("L")) move = new int[]{0,-1};
			else if(ch.equals("B")) move = new int[]{-1,0};
			else if(ch.equals("T")) move = new int[]{1,0};
			else if(ch.equals("RT")) move = new int[]{1,1};
			else if(ch.equals("LT")) move = new int[]{1,-1};
			else if(ch.equals("RB")) move = new int[]{-1,1};
			else if(ch.equals("LB")) move = new int[]{-1,-1};
			
			int nrking = king[0]+ move[0];
			int ncking = king[1]+ move[1];
			int nrstone = stone[0];
			int ncstone = stone[1];
			if(nrking== stone[0] && ncking == stone[1]) { //king이 이동하는 곳에 돌이 있다면 돌도 이동
				nrstone = stone[0]+ move[0];
				ncstone = stone[1]+ move[1];
			}
			//범위 확인
			if(nrking >='1' && nrking<= '8' && ncking>='A' &&ncking<='H' &&nrstone >='1' && nrstone<= '8' && ncstone>='A' &&ncstone<='H') {
				king[0] = nrking;
				king[1] = ncking;
				stone[0] = nrstone;
				stone[1] = ncstone;
			}
		}
		System.out.println((char)king[1]+""+(char)king[0]);
		System.out.println((char)stone[1]+""+(char)stone[0]);
	}
}
