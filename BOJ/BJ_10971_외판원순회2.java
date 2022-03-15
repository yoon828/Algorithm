package D0315;

import java.io.*;
import java.util.*;

/*
 1. 순열 구하기
 2. 거리 비용 구하기 , 마지막 도시에서 처음 도시로 가는 비용 더해주기
 3. 거리가 0이면 갈 수 없으므로 return
 */
public class BJ_10971_외판원순회2 {
	static int min;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		min = Integer.MAX_VALUE;
		int N = Integer.parseInt(st.nextToken());
		// 거리 배열
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 순열 시작
		perm(0, N, new int[N], new boolean[N]);
		System.out.println(min);
	}

	private static void perm(int cnt, int n, int[] results, boolean[] visited) {
		if (cnt == n) {
			// 여행 경로 구하기
			int sum=0;
			for (int i = 0; i < n-1; i++) {
				int from = results[i];
				int to = results[i + 1];
				if(dist[from][to] == 0) return;
				sum += dist[from][to];
			}
			if(dist[results[n-1]][results[0]] == 0) return;
			sum += dist[results[n-1]][results[0]];
			min = Math.min(sum, min);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])	continue;
			results[cnt] = i;
			visited[i] = true;
			perm(cnt + 1, n, results, visited);
			visited[i] = false;
		}
	}
}
