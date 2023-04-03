package D0301;

import java.io.*;

public class BJ_2193_이친수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long [][] dp = new long[N+1][2];

		dp[1][0] = 0;
		dp[1][1] = 1;

		for (int i = 1; i < N; i++) {
			
			dp[i+1][0] += dp[i][0];
			dp[i+1][1] += dp[i][0]; 
			
			dp[i+1][0] += dp[i][1];
		}
		
		long sum = 0; 
		for (int i = 0; i < 2; i++) {
			sum+=dp[N][i];
		}
		System.out.println(sum);
	}
}
