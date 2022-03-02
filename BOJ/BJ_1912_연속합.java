package D0302;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1912_연속합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			dp[i]=Integer.parseInt(st.nextToken());
		}
		int max =dp[0];  //최대값 초기화
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i], dp[i-1]+dp[i]); //내 이전까지의 dp값 + 현재 값 과 현재값 둘중에 더 큰 값으로 업데이트
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
		
	}
}
