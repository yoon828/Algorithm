import java.io.*;

public class BJ_2239_스도쿠 {
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j]= s.charAt(j)-'0';
			}
		}
		
		find(0,0);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void find(int p, int q) {//0이면 dfs 돌리기
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(map[i][j]==0) { //0이면 대입 가능한 모든 숫자 다 넣기
					for (int k = 1; k <= 9; k++) { //1~9까지 대입
						if(check(i,j, k)) { //스도쿠 규칙을 만족하는지 확인
							map[i][j] = k; 
							find(i,j); //dfs
						}
					}
					//다 대입했는데 스도쿠판이 채워지지 않은 경우라면 
					//가능성이 없는 판이기 때문에 0으로 초기화해주고 return
						if(!isFull()) {
						map[i][j] = 0;
						return; 
					}
				}
			}
		}
	}
	
	private static boolean check(int i, int j, int k) { //스도쿠 규칙 체크 함수
		//같은 행에 같은 숫자 있는지 확인 
		for (int q = 0; q < 9; q++) {
			if(map[i][q]==k) return false;
		}
		//같은 열에 같은 숫자 있는지 확인
		for (int p = 0; p < 9; p++) {
			if(map[p][j]==k) return false;
		}
		//3*3 안에 같은 숫자 있는지 확인
		i = i/3 * 3; 
		j = j/3 * 3; 
		for (int p =i ; p < i+3; p++) {
			for (int q = j; q < j+3; q++) {
				if(map[p][q]==k) return false;
			}
		}
		return true;
	}
	private static boolean isFull() { //스도쿠판이 채워졌는지 확인하는 함수 
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(map[i][j]==0) return false;
			}
		}
		return true;
	}
}
