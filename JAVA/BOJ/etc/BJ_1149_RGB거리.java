import java.io.*;

public class BJ_1149_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] price = new int[N+1][3];
		for (int i = 1; i <= N; i++) {
			String[] str = br.readLine().split(" ");
			price[i][0] = Integer.parseInt(str[0]);
			price[i][1] = Integer.parseInt(str[1]);
			price[i][2] = Integer.parseInt(str[2]);
		}
		int[][] dp = new int[N+1][3]; //빨, 초, 파
		dp[1][0] = price[1][0];
		dp[1][1] = price[1][1];
		dp[1][2] = price[1][2];
		for (int i = 2; i <= N; i++) {
			dp[i][0]= Math.min(dp[i-1][1], dp[i-1][2]) + price[i][0];
			dp[i][1]= Math.min(dp[i-1][0], dp[i-1][2]) + price[i][1];
			dp[i][2]= Math.min(dp[i-1][0], dp[i-1][1]) + price[i][2];
		}
		int min = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));
		System.out.println(min);
	}
}
