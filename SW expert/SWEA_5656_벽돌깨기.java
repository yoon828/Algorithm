import java.io.*;
import java.util.*;

public class SWEA_5656_벽돌깨기 {
	static int[][] move= {{1,0},{-1,0},{0,1},{0,-1}};
	static Stack<Integer> stack;
	static int N, W, H, min;
	static int[][] map;
	static int[][] mapCopy;
	static int[] cnts; //각 열의 개수를 저장
	static int[] cntsCopy; //각 열의 개수를 저장
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			map = new int[H][W];
			mapCopy = new int[H][W];
			cnts = new int[W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int j = 0; j < W; j++) {
			for (int i = 0; i < H; i++) {
					if(map[i][j] != 0) cnts[j]++;
				}
			}
			//N개를 뽑는 중복 순열
			perm(0, new int[N]);
			if(min == Integer.MAX_VALUE) min =0;
			System.out.printf("#%d %d\n", tc, min);
		}
	}
	private static void perm(int cnt, int[] result) {
		if(cnt==N) { //순열 뽑기 완료
			//벽돌 깨기
			for (int i = 0; i < H; i++) {
				mapCopy[i] = map[i].clone();
			}
			cntsCopy = cnts.clone();
			for (int k = 0; k < N; k++) {
				int j = result[k];
				int i = H-cntsCopy[j];
				if(i==H) return; //제거할 벽돌이 없는 경우 return
				shoot(i,j);//제거할 벽돌을 모두 -1로 만들기
				//-1로 된 벽돌 제거 후 새로운 map으로 변경, cnts배열 업데이트
				for (int q = 0; q < W; q++) {
					int sum =0;
					stack = new Stack<>();
					for (int p = 0; p < H; p++) {
						if(mapCopy[p][q] != 0 && mapCopy[p][q] != -1) {
							sum++;
							stack.add(mapCopy[p][q]); //0과 -1이 아닌 경우들만 넣기
						}
					}
					cntsCopy[q] = sum;
					for (int l = H-1; l >=0 ; l--) {
						if(!stack.isEmpty()) { //스택에 값이 있으면 스택의 top값 
							mapCopy[l][q] = stack.pop(); 
						}else { //아니면 0으로
							mapCopy[l][q] = 0; 
						}
					}
				}
			}
			int s = 0;
			for (int l = 0; l < W; l++) {
				s += cntsCopy[l];
			}
			min =Math.min(min, s);
			return;
		}
		for (int i = 0; i < W; i++) {
			result[cnt] = i;
			perm(cnt+1, result);
		}
	}
	private static void shoot(int i, int j) { //선택한 열 맨 위 벽돌 제거 후, 영향범위 안에 있는 다른 벽돌들도 제거
		int scope = mapCopy[i][j]; //벽돌안에 있는 숫자
		if(scope==0) return;
		mapCopy[i][j] = -1;
		for (int k = 0; k < 4; k++) {
			for (int z = 0; z < scope; z++) {
				int ni = i + move[k][0] * z;
				int nj = j + move[k][1] * z;
				if(ni>=0 && ni<H && nj>=0 && nj<W && mapCopy[ni][nj]!=0 && mapCopy[ni][nj]!=-1){
					shoot(ni,nj);
				}
			}
		}
	}
}
