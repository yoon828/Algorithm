import java.io.*;
import java.util.*;

public class BJ_1260_DFS와BFS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		int[][] adjMatrix = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			adjMatrix[to][from] = 1; //무향 그래프이므로 양쪽에 다 넣어주기
			adjMatrix[from][to] = 1;
		}

		dfs(V, new boolean[N+1], N, adjMatrix);
		System.out.println();
		// bfs
		bfs(V,  N, adjMatrix);
		
	}

	private static void dfs(int v, boolean[] selected, int N, int[][] adjMatrix) {
		selected[v] = true;
		System.out.print(v+" ");
		
		for (int i = 1; i <= N; i++) {
			if(adjMatrix[v][i]==1 && !selected[i]) dfs(i, selected, N, adjMatrix);
		}
	}
	
	private static void bfs(int start, int N, int[][] adjMatrix) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] selected = new boolean[N+1];
		
		queue.offer(start);
		selected[start] = true;
		while(!queue.isEmpty()){
			int temp = queue.poll();
			System.out.print(temp+" ");
			
			for (int i = 1; i <=N; i++) {
				if(adjMatrix[temp][i] == 1 && !selected[i]) {
					queue.offer(i);
					selected[i] =true; 
				}
			}
			
		}	
	}
}
