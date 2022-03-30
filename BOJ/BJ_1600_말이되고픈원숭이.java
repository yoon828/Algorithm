import java.io.*;
import java.util.*;


public class BJ_1600_말이되고픈원숭이 {
	static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[][] horse = {{-1,2},{-2,1},{-1,-2},{-2,-1},{1,-2},{2,-1},{1,2},{2,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken()); //가로
		int H = Integer.parseInt(st.nextToken()); //세로
		int[][] map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		boolean[][][] visit = new boolean[H][W][K+1];
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {0,0,0,0}); //현재 위치, 이동수, 말이동 횟수
		visit[0][0][0] = true;
		//bfs시작
		int min = Integer.MAX_VALUE;
		while(!que.isEmpty()) {
			int[] t = que.poll();
			if(min < t[2]) continue;
			if(t[0]==H-1 && t[1]==W-1) {
				min = Math.min(min, t[2]);
				break;
			}
			if(t[3] < K) { //말이동 횟수가 남아있으면
				for (int k = 0; k < horse.length; k++) {
					int i = t[0]+horse[k][0];
					int j = t[1]+horse[k][1];
					if(i>=0 && i<H && j>=0 && j<W && map[i][j]!= 1 && !visit[i][j][t[3]+1]) {
						visit[i][j][t[3]+1] = true;
						que.add(new int[] {i,j,t[2]+1, t[3]+1}); 
					}
				}
			}
			for (int k = 0; k < move.length; k++) {
				int i = t[0]+move[k][0];
				int j = t[1]+move[k][1];
				if(i>=0 && i<H && j>=0 && j<W && map[i][j]!= 1 && !visit[i][j][t[3]]) {
					visit[i][j][t[3]] = true;
					que.add(new int[] {i,j,t[2]+1, t[3]}); 
				}
			}
		}
		if(min==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
}
