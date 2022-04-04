import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_최장증가부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] dp = new int[N];
			Arrays.fill(dp, 1);
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = 1;
			for (int i = 0; i < N; i++) {
				int n = i;
				while(--n >= 0) {
					if(arr[n] < arr[i]) {
						dp[i] = Math.max(dp[n]+1, dp[i]);
						max = Math.max(max, dp[i]);
					}
					
				}
			}
			System.out.printf("#%d %d\n",tc, max);
		}
	}
}
