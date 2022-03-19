package D0319;

import java.io.*;
import java.util.*;

public class BJ_11052_카드구매하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1]; 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dp = new int[N+1]; 
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], arr[j]+dp[i-j]);
			}
		}
		System.out.println(dp[N]);
	}
}
