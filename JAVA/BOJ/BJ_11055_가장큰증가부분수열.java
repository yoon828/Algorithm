package D0302;
import java.io.*;
import java.util.StringTokenizer;
public class BJ_11055_가장큰증가부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		 st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=  Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		
		int max = dp[0];
		for (int i = 1; i <N; i++) {
			for (int j = i-1; j >=0; j--) { // 나의 바로 앞 부터 0까지 내려가면서 
				if(arr[j] < arr[i]) { //작으면
					dp[i] = Math.max(dp[j]+arr[i], dp[i]); //현재 dp[i]과 dp[j]+현재값 중에 더 큰걸로 변경
					max =Math.max(dp[i], max);
				}
			}
		}
		System.out.println(max);
	}
}
