import java.io.*;
import java.util.*;

public class JO_1681_해밀턴순환회로 {
	static int min, N;
	static boolean[] visited;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		dfs(0, 0, 0, new boolean[N]); // 0번부터 시작, 비용의 합, 들린장소의 수 , 방문체크 배열
		System.out.println(min);
	}

	private static void dfs(int i, int sum, int cnt, boolean[] visited) {
		if (sum > min) //중간에 sum이 현재의 최소값을 넘으면 중단
			return;

		visited[i] = true; // 방문 체크

		if (cnt == N - 1) {
			if(map[i][0]==0) return; //마지막에 선택된 장소가 회사로 갈 수 있는 길이 없으면 중단
			sum += map[i][0];
			min = Math.min(min, sum);
			return;
		}

		for (int j = 1; j < N; j++) {
			if (!visited[j] && map[i][j] != 0) {
				boolean[] nvisited = Arrays.copyOf(visited, N);
				dfs(j, sum + map[i][j], cnt + 1, nvisited); //재귀 호출
			}
		}

	}
}
