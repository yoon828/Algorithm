import java.io.*;
import java.util.*;

public class D4_1238_Contact {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			int[][] adjMatrix = new int[101][101];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjMatrix[from][to] = 1;
			}
			
			//bfs 시작 
			Queue<Integer> queue =new LinkedList<>(); //
			boolean[] visit = new boolean[101]; //사용 여부 배열
			queue.offer(V); //시작 원소 넣기
			visit[V] = true;
			int max = 0; //같은 깊이 중에서최대값 저장
			while(!queue.isEmpty()) {
				int cnt = queue.size(); //같은 깊이에 있는 원소들의 개수 
				max = 0; 
				while(cnt-- > 0) { //1씩 감소
					int temp = queue.poll();
					max = Math.max(max, temp); //같은 깊이 중에서 최대값 비교하기 
					for (int i = 1; i <= 100 ; i++) { //인접 배열에서 인접한 원소로 깊이 탐색
						if(!visit[i] && adjMatrix[temp][i]==1) {
							queue.add(i);
							visit[i] = true;
						}
					}

				}
			}
			System.out.printf("#%d %d\n", test_case, max);
		}

	}
}
