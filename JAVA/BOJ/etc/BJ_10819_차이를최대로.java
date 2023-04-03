package D0315;

import java.io.*;
import java.util.*;

public class BJ_10819_차이를최대로 {
	public static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] inputs = new int[N]; // 입력값을 저장할 배열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		
		 max = Integer.MIN_VALUE;
		//순열 만들기
		perm(0, N, inputs, new int[N], new boolean[N]);
	
		System.out.println(max); //최대값 출력
	}

	private static void perm(int cnt, int n, int[] inputs, int[] results, boolean[] visited) {
		if(cnt == n) { //기저조건
			//차이 구하기
			int sum =0;
			for (int i = 0; i < n-1; i++) {
				sum+= Math.abs(results[i]-results[i+1]); //차이의 절대값을 sum변수에 더하기 
			}
			max = Math.max(sum, max);
			return; 
		}
		//순열 구하는 부분
		for (int i = 0; i <n; i++) {
			if(visited[i]) continue;
			results[cnt] = inputs[i];
			visited[i] = true;
			perm(cnt+1, n, inputs, results, visited);
			visited[i] = false;
		}
	}
}
