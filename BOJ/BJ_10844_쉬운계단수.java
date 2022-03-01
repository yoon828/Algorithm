package D0301;

import java.io.*;
import java.util.*;

public class BJ_10844_쉬운계단수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long [][] dp = new long[N+1][10];
		//한자리 수 인 경우
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <10; j++) {
				if(dp[i][j] >0) { //수가 존재하면
					if(j-1>=0 ) dp[i+1][j-1]=(dp[i+1][j-1] +dp[i][j]) %1000000000;
					if(j+1<=9) dp[i+1][j+1] =(dp[i+1][j+1] +dp[i][j])%1000000000;
				}
			}
		}
		
		long sum =0; 
		for (int i = 0; i < 10; i++) {
			sum+= (dp[N][i] % 1000000000);
		}
		System.out.println(sum % 1000000000);
	}
}
