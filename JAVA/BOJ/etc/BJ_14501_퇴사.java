package D0303;

import java.io.*;
import java.util.Arrays;

public class BJ_14501_퇴사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] T = new int[N+1];
		int[] P = new int[N+1];
		int[] dp = new int[N+2];
		
		for (int i = 1; i <= N; i++) {
			String[] str = br.readLine().split(" ");
			T[i] = Integer.parseInt(str[0]);
			P[i] = Integer.parseInt(str[1]);
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i], dp[i-1]);
			if(i+T[i]-1 <= N) {
				dp[i+T[i]] = Math.max(dp[i+T[i]] , dp[i]+P[i]);
				max = Math.max(dp[i+T[i]], max);
			}
		}
		System.out.println(max);
		
	}
}
