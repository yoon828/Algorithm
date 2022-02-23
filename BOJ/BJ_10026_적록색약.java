import java.io.*;

public class BJ_10026_적록색약 {
	static int[][] move= {{-1,0},{1,0},{0,-1},{0,1}};
	static char[][] map ;
	static boolean[][] visitedN;
	static boolean[][] visitedG;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		 map =new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int cntN = 0, cntG = 0;
		visitedN = new boolean[N][N];
		visitedG = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visitedN[i][j]) {
					cntN++;
					notBfs(map[i][j], i,j); //적록색약이 아닌 사람이 봤을때의 구역찾기
				}
				if(!visitedG[i][j]) {
					cntG++;
					greenBfs(map[i][j], i,j); //적록색약인 사람이 봤을때의 구역찾기
				}
				
			}
		}
		System.out.print(cntN+" "+cntG);
	}
	
	private static void notBfs(char ch, int i, int j) {
		
		visitedN[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int nr = i+move[k][0];
			int nc = j+move[k][1];
			if(nr >=0 && nr <N && nc>=0 && nc<N) { 
				if(!visitedN[nr][nc] && map[nr][nc] ==ch) { //현재 char과 동일하면 탐색
					notBfs(ch, nr, nc);
				}
			}
		}
		
	}
	
	private static void greenBfs(char ch, int i, int j) {	
		visitedG[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int nr = i+move[k][0];
			int nc = j+move[k][1];
			if(nr >=0 && nr <N && nc>=0 && nc<N) {
				if(!visitedG[nr][nc]) {
					if(ch =='R' || ch =='G') { //현재 char이 R ,G 이면 R,G 인경우에 탐색
						if(map[nr][nc] == 'R' || map[nr][nc]=='G') {
							greenBfs(ch, nr, nc);
						}
					}else {
						if( map[nr][nc] ==ch ) {
							greenBfs(ch, nr, nc);
						}
					}
				}
			}
		}
		
	}

}
