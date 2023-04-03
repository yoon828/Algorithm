package D0227;

import java.io.*;
import java.util.*;

public class BJ_3085_사탕게임 {
	public static int N, max;
	public static char[][] map;
	public static void find() {
		int cnt = 1;
		for (int i = 0; i <N; i++) { //가로 줄에서 최대 사탕 개수 찾기
			cnt=1;
			for (int j = 0; j < N-1; j++) {
				if(map[i][j] == map[i][j+1]) cnt++;
				else {
					max = Math.max(max, cnt);
					cnt=1;
				}
			}
			max = Math.max(max, cnt);
		}
		for (int j = 0; j<N; j++) { //세로 줄에서 최대 사탕 개수 찾기
			cnt=1;
			for (int i = 0; i < N-1; i++) {
				if(map[i][j] == map[i+1][j]) cnt++;
				else {
					max = Math.max(max, cnt);
					cnt=1;
				}
			}
			max = Math.max(max, cnt);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		int[][ ] move = {{1,0},{0,1}};
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		max = 0;
		for (int k = 0; k < N; k++) { 
			if(max ==N)break;  //최대 사탕 개수가 N이면 반복문 나오기
			for (int z 	= 0; z <N; z++) {
				for (int m = 0; m < 2; m++) { //오른쯕과 아래만 탐색
					int i = k+move[m][0];
					int j = z+move[m][1];
					if(i>=0 && i<N &&j>=0 && j<N ) {
						char ori = map[k][z];
						char temp = map[i][j];
						if(ori == temp ) break;
						map[k][z] = temp;
						map[i][j] = ori;
						find(); //가장 긴 줄 사탕의 개수 찾기
						map[k][z] = ori; //배열 원상복귀 해놓기
						map[i][j] = temp;
					}
				}
			}
		}
		System.out.println(max);
	}
}
