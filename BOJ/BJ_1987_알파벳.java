import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BJ_1987_알파벳 {
//	static String str = "2 4\r\n" + "CAAB\r\n" + "ADCB";
	public static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };//상하좌우
	public static int R, C, cnt;
	public static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new StringReader(str));

		String[] s = br.readLine().split(" ");
		boolean[] alph = new boolean[26];

		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		cnt=0;
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		findMove(0, 0, alph, 0); // 1행 1열부터 시작
		
		System.out.println(cnt);
	}

	private static void findMove(int i, int j, boolean[] alph, int sum) {
		
		// 칸수 +1 후 본인의 알파벳을 사용 체크 하기
		sum++;
		alph[map[i][j] - 'A'] = true;


		// 기저 조건 : 4방향 모두 이동할 수 없는 경우
		if (!canMove(i, j,alph)) {
			cnt = Math.max(cnt,sum);
			return;
		}
		
		// 4방 탐색
		for (int k = 0; k < 4; k++) {
			int ii = i + move[k][0];
			int jj = j + move[k][1];
			
			// 다음 알파벳이 사용 가능한 것인지 확인
			if (canUsed(ii, jj,alph)) {
				findMove(ii, jj,alph, sum);
				alph[map[ii][jj] - 'A'] = false;
			}
		}
	}

	public static boolean canUsed(int i, int j,boolean[] alph) {
		// 인덱스 범위에 벗어나는 경우
		// 이미 사용한 알파벳인경우
		// 이동 불가능한 경우 false
		if (i >= 0 && i < R && j >= 0 && j < C) {
			if (alph[map[i][j] - 'A'])
				return false;
			return true;
		}
		return false;
	}

	public static boolean canMove(int i, int j,boolean[] alph) {
		// 4방 탐색이 전부 불가능하면 false
		for (int k = 0; k < 4; k++) {
			int ii = i + move[k][0];
			int jj = j + move[k][1];
			if (ii >= 0 && ii < R && jj >= 0 && jj < C) {
				if (canUsed(ii, jj,alph)) {
					return true;
				}
			}
		}
		return false;
	}

}
