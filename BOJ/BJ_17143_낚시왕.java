import java.io.*;
import java.util.StringTokenizer;

public class BJ_17143_낚시왕 {
	static int[][] move = { {},{ -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }; //
	static int R, C, M;
	static Shark[][] map;

	static class Shark {
		int r, c, speed, dir, size;
		public Shark(int r, int c, int speed, int dir, int size) {
			super();
			this.r = r;
			this.c = c;
			this.speed = speed; //속도
			this.dir = dir; //방향
			this.size = size; //크기 
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R + 1][C + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(r, c, s, d, z);
		}
		// 낚시하기
		int ans = 0;
		for (int k = 1; k <= C; k++) { // 낚시왕 위치
			// 가장 가까운 상어 제거
			for (int i = 1; i <= R; i++) {
				if (map[i][k] != null) {
					ans += map[i][k].size;
					map[i][k] = null; // 상어 제거
					break;
				}
			}
			// 상어 이동
			moveShark();
		}
		System.out.println(ans);
	}

	public static void moveShark() {
		Shark[][] temp = new Shark[R+1][C+1]; //임시 배열, 이동한 후의 상어들을 저장
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] != null) {
					Shark s = map[i][j];
					int sp = s.speed;
					if(s.dir==3 ||s.dir==4) sp = sp% (2*C-2); //중복 최소화
					else  sp = sp% (2*R-2);
					int dir = s.dir;
					int r = s.r;
					int c = s.c;
					for (int k = 0; k < sp; k++) {
						if (r + move[dir][0] < 1 || r + move[dir][0] > R || c + move[dir][1] < 1
								|| c + move[dir][1] > C) { //경계에 도달하는 경우 방향 전환
							if (dir == 1 || dir == 3) 
								dir = dir + 1;
							else
								dir = dir - 1;
						}
						r = r + move[dir][0];
						c = c + move[dir][1];
					}
					s.dir = dir;
					s.r=r; s.c =c;
					if(temp[r][c]!=null) { //이미 저장된 상어가 있으면
						Shark t1 = temp[r][c]; //크기가 크면
						if(t1.size > s.size) continue; //continue
					}
					temp[r][c] = s;
				}
			}
		}
		for (int i = 1; i <= R; i++) { //임시배열을 map에 복사하기
			for (int j = 1; j <= C; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
}
