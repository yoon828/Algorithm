import java.io.*;
import java.util.*;
public class SW_4013_특이한자석 {
	static int[][] magnet ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			magnet = new int[4][8];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] =  Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				rot(n-1,dir, new boolean[4]);
			}
			
			int ans =0;
			if(magnet[0][0]==1) ans+=1;
			if(magnet[1][0]==1) ans+=2;
			if(magnet[2][0]==1) ans+=4;
			if(magnet[3][0]==1) ans+=8;
			System.out.printf("#%d %d\n",tc, ans);
		}
	}
	private static void rot(int n, int dir, boolean[] visit) {
		if(visit[n]) return;
		visit[n] = true;
		int[] temp = new int[8];
		for (int i = 0; i < 8; i++) {
			temp[(i+dir+8)%8] = magnet[n][i];
		}
		if(n+1 < 4 &&magnet[n][2] != magnet[n+1][6]) rot(n+1, -dir, visit);
		if(n-1 >= 0 && magnet[n][6] != magnet[n-1][2]) rot(n-1, -dir, visit);
		for (int i = 0; i < 8; i++) {
			magnet[n][i] = temp[i];
		}
	}
}
