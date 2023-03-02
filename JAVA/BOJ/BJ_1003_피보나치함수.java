package D0301;
import java.io.*;
import java.util.*;

public class BJ_1003_피보나치함수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[41][2];
		dp[0][0] = 1;
		dp[1][1] = 1;
		for (int i = 2; i <= 40; i++) {
			dp[i][0] =dp[i-1][0]+ dp[i-2][0];
			dp[i][1] =dp[i-1][1]+ dp[i-2][1];
		}
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int n =  Integer.parseInt(br.readLine());
			System.out.println(dp[n][0] +" "+dp[n][1]);
		}

	}
}
