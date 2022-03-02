package D0302;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for (int i = 0; i < N-1; i++) {
			int cnt = 1 ;
			int  current = arr[i];
			for (int j = i+1; j <N; j++) { //내 다음 부터 N까지 나보다 더 큰수가 있으면 current변경, dp값을 더 큰수로 변경해준다
				if(current < arr[j]) {
					dp[j] = Math.max(++cnt, dp[j]);
					max = Math.max(max, dp[j]);
					current=arr[j];
				}
			}
		}
		
		System.out.println(max);
		
	}
}
