package D0308;

import java.io.*;

public class BJ_1343_폴리오미노 {
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String boad= br.readLine();
		String A = "AAAA";
		String B = "BB";
		int[][] map = new int[51][2]; // 0 : A의 개수 , 1: B의 개수
		
		for (int i = 1; i <= 50; i++) {
			int n = i; 
			map[i][0]= n/4; //A 개수 먼저 넣기 
			n =n%4;
			map[i][1]=n/2; //B 개수 구하기
			n %= 2;
			if (n > 0) {
				map[i][0]=-1;
				map[i][1]=-1;
			}
		}
		int temp = 0;
		for (int i = 0; i < boad.length(); i++) {
			char ch = boad.charAt(i);
			if(ch=='.' ) {
				int[] result = map[temp];
				if(result[0] == -1) {
					System.out.println(-1);
					return;
				}
				for (int j = 0; j < result[0]; j++) {
					sb.append(A);
				}
				for (int j = 0; j < result[1]; j++) {
					sb.append(B);
				}
				sb.append(".");
				temp=0;
				
			}else temp++;
			if(i==boad.length()-1) {
				int[] result = map[temp];
				if(result[0] == -1) {
					System.out.println(-1);
					return;
				}
				for (int j = 0; j < result[0]; j++) {
					sb.append(A);
				}
				for (int j = 0; j < result[1]; j++) {
					sb.append(B);
				}
			}
		}
		
		
		System.out.println(sb);
	}
}
