package D0302;
import java.io.*;
import java.util.*;
public class BJ_9461_파도반수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			long[] dp = new long[N+1];
			dp[1] = 1;
			if(N>1)dp[2] = 1;
			for (int j = 3; j <= N; j++) { 
				dp[j] = dp[j-2]+ dp[j-3]; //나보다 2칸앞, 3칸앞에 있는 값을 더해준다.
			}
			System.out.println(dp[N]);
		}
		
	}
}
