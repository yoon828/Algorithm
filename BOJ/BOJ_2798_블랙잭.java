package may;

import java.io.*;
import java.util.*;

public class BOJ_2798_블랙잭 {
	static int[] nums;
	static int N, M, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		max = 0;
		combi(0, 0, 0);
		System.out.println(max);
	}

	private static void combi(int cnt, int start, int sum) {
		if (cnt == 3) {
			if (sum <= M && max < sum) {
				max = sum;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			sum += nums[i];
			combi(cnt + 1, i + 1, sum);
			sum -= nums[i];
		}
	}
}
