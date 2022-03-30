import java.io.*;
import java.util.*;

public class BJ_2636_치즈 {
	static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int cnt =0; //치즈 개수
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) cnt++;
			}
		}
		int cheese=cnt;
		int t = 0; //시간
		boolean[][] air = new boolean[N][M]; //공기여부 
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {0, 0});
		while(cnt!=0) {
			cheese = cnt;
			t++;
			while(!que.isEmpty()) {
				int temp[] = que.poll();
				if(!air[temp[0]][temp[1]])
					bfs(temp[0],temp[1], air, map);
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						for (int k = 0; k < 4; k++) {
							int ni = i + move[k][0]; 
							int nj = j + move[k][1]; 
							if(air[ni][nj]) {
								cnt--;
								map[i][j] = 0;
								que.add(new int[] {i,j});
								break;
							}
						}
					}
				}
			}
		}
		System.out.println(t);
		System.out.println(cheese);
	}
	public static void bfs(int ii, int jj, boolean[][] air, int[][] map) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {ii,jj});
		air[ii][jj] = true;
		while(!que.isEmpty()) {//공기 찾기 bfs
			int[] temp = que.poll();
			int i = temp[0];
			int j = temp[1];
			for (int k = 0; k < 4; k++) {
				int ni = i + move[k][0]; 
				int nj = j + move[k][1]; 
				if(ni>=0 && ni<N && nj>=0 && nj<M && !air[ni][nj] && map[ni][nj]==0) {
					air[ni][nj] = true;
					que.add(new int[] {ni,nj});
				}
			}
		}
	}
}
