package D0316;

import java.io.*;
import java.util.*;

public class BJ_9613_GCD합 {
	static int n;
	static long sum;	
	static int [] input;
	static int [] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			sum=0;
			input = new int[n];
			result = new int[2];
			for (int i = 0; i < n; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			//조합 시작
			combi(0,0);
			System.out.println(sum);
		}
	}

	private static void combi(int cnt, int start) {
		if(cnt==2) {
			//조합완성
			sum+=gcd(result[0], result[1]);
			return;
		}
		for (int i = start; i < n; i++) {
			result[cnt] = input[i];
			combi(cnt+1, i+1);
		}
	}

	private static int gcd(int a, int b) {
		while(b!=0) {
			int t = a % b;
			a = b;
			b = t;
		}
		return a;
	}

}
