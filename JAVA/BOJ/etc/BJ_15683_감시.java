import java.io.*;
import java.util.*;

/*
 * 0 : 빈칸, 6: 벽 , 1~5: cctv 
 */
public class BJ_15683_감시 {
	public static String str = "4 6\r\n" + "0 0 0 0 0 0\r\n" + "0 0 0 0 0 0\r\n" + "0 0 1 0 6 0\r\n" + "0 0 0 0 0 0";

	public static int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	public static int N, M, min,  K; //K: cctv 개수
	public static List<CCTV> list; // cctv들의 정보 저장

	static class CCTV {
		int i, j; //cctv위치
		char type; //cctv타입
		List<int[]> dirs = new ArrayList<>(); // 방향에 맞게 탐색해야하는 방향들의 인덱스들을 저장

		public CCTV(char type, int i, int j) {
			this.type = type;
			this.i = i;
			this.j = j;
			setDir(type);
		}

		private void setDir(char type) { //cctv 타입에 맞춰서 탐색 방향의 인덱스를 넣어주기
			if (type == '1') {
				this.dirs.add(new int[] { 0 });
				this.dirs.add(new int[] { 1 });
				this.dirs.add(new int[] { 2 });
				this.dirs.add(new int[] { 3 });
			} else if (type == '2') {
				this.dirs.add(new int[] { 0, 1 });
				this.dirs.add(new int[] { 2, 3 });
			} else if (type == '3') {
				this.dirs.add(new int[] { 1, 2 });
				this.dirs.add(new int[] { 2, 0 });
				this.dirs.add(new int[] { 0, 3 });
				this.dirs.add(new int[] { 3, 1 });
			} else if (type == '4') {
				this.dirs.add(new int[] { 1, 2, 0 });
				this.dirs.add(new int[] { 2, 0, 3 });
				this.dirs.add(new int[] { 0, 3, 1 });
				this.dirs.add(new int[] { 3, 1, 2 });

			} else if (type == '5') {
				this.dirs.add(new int[] { 0, 1, 2, 3 });
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new StringReader(str));
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<CCTV>();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				char ch = st.nextToken().charAt(0);
				map[i][j] = ch;
				if ('1' <= ch && '5' >= ch) { //cctv라면 list에 cctv정보 추가
					list.add(new CCTV(ch, i, j));
				}
			}
		}
		K = list.size(); //cctv개수
		min = N*M; //사각지대 개수 
		
		dfs(0, map);
		
		System.out.println(min);

	}

	private static void dfs(int cnt, char[][] map) { // 현재 몇번째 cctv인지

		// 기저 조건 cctv개수 만큼 다 탐색 하면 종료
		if (cnt == K) {
			// 탐색 완료 사각지대 개수 세기
			int count = 0; 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]=='0') count++;
				}
			}
			min = Math.min(count, min);
			return;
		}

		// 방향 바꿔가면서 dfs 호출
		CCTV c = list.get(cnt); //cnt번째 cctv가져오기
		for (int i = 0; i < c.dirs.size(); i++) { //cctv의 방향이 가질 수 있는 개수 만큼 반복
			///이중배열 복사 
			char[][] nMap = new char[N][M];
			for (int j = 0; j < N; j++) {
				System.arraycopy(map[j], 0, nMap[j], 0, M);
			}

			searching(c.dirs.get(i), c.i, c.j, nMap); // cctv의 번호에 따른 방향들과 위치로 탐색 시작
			dfs(cnt + 1, nMap);
		}

	}

	private static void searching(int[] is, int i, int j, char[][] arr) {
		// is는 cctv의 방향'들' 1번이면 상 만 /2번이라면 상하 같이
		for (int z = 0; z < is.length; z++) { // 탐색해야하는 방향만큼 반복
			int p = i; 
			int q = j; 
			while (true) { 
				p= p + move[is[z]][0];
				q = q + move[is[z]][1];
				if (p >= 0 && p < N && q >= 0 && q < M) { //범위안
					if (arr[p][q] == '6') //벽이 있으면 brek;
						break;
					if (arr[p][q] == '0') //아무거도 없는 경우에만  #으로 변경
						arr[p][q] = '#';
				}else break; //범위 밖으로 나가면 break; 
				
			}
		}
	}
}
