package D0225;

import java.io.*;
import java.util.*;

public class BJ_2116_주사위쌓기 {
	static int N, Max;
	static int[][] dice;
	static int[] op = { 5, 3, 4, 1, 2, 0 }; //각 마주보는 면의 인덱스를 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 주사위 개수

		dice = new int[N][6];
		
		for (int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			 for (int j = 0; j < 6; j++) {
				 dice[i][j] = Integer.parseInt(st.nextToken());
			 }
		}
		Max = -1;
		//윗 면 정하기 
		for (int i = 0; i < 6; i++) {
			int max = 0;
			for (int j = 0; j <6; j++) { //옆면 중에서 가장 큰 값 
				if( j ==i || j == op[i]) continue;
				max = Math.max(max,  dice[0][j]);
			}
			up(dice[0][i] , max, 1); //윗면의 "값"과 옆면중에서 가장 큰 값
		}
		System.out.println(Max);
	}

	private static void up(int top, int sum, int cnt) { //cnt: 현재까지 올린 주사위 개수
		if(cnt == N) {
			Max = Math.max(sum, Max);
			return ;
		}
		//현재 주사위에서 top에  해당하는 인덱스를 찾아야함
		int idx=0;
		for (int i = 0; i <6; i++) { //이전 주사위의 탑에 해당하는 값을 현재 주사위에서 찾기
			if(dice[cnt][i] == top) {
				idx =i; 
				break;
			}
		}
		int nextTop = op[idx]; //현재 주사위의 윗면의 인덱스 결정
		int m = 0;
		for (int j = 0; j <6; j++) { //옆면중에서 가장 큰 값 
			if( j ==nextTop || j == idx) continue;
			m = Math.max(m,  dice[cnt][j]);
		}
		up(dice[cnt][nextTop], sum+m, cnt+1);
	}
}
