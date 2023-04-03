package study_mar;

import java.io.*;
import java.util.*;

public class BJ_3190_뱀 {
	static int[][] move = {{0,1},{1,0},{0,-1},{-1,0}}; //우, 하, 좌, 상 (시계방향으로 저장)
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < K; i++) {			
			String[] str = br.readLine().split(" "); //사과의 위치를 저장
			map[Integer.parseInt(str[0])-1][Integer.parseInt(str[1])-1] = 1;
		}
		int L = Integer.parseInt(br.readLine());
		Queue<int[]> que = new LinkedList<>(); //방향 변환 정보 저장
		for (int i = 0; i < L; i++) {
			String[] str = br.readLine().split(" ");
			int x  = Integer.parseInt(str[0]);
			if(str[1].equals("D")) que.add(new int[] {x, 1}); //오른쪽이면 1, 왼쪽이면 -1 저장 
			else  que.add(new int[] {x, -1});
		}
		
		Deque<int[]> deque = new LinkedList<int[]>();
		deque.offer(new int[] {0,0});
		map[0][0] = 2; //뱀이 있는 위치는 2로
		int t = 0;
		int dirIdx = 0;
		while(true) {
			int[] cur = deque.peek();
			int[] dir = que.peek();
			if(!que.isEmpty() && t == dir[0]) { //시간 확인해서 방향 전환
				que.poll();
				dirIdx = (dirIdx + dir[1] + 4)%4;
			}
			int i =cur[0]+move[dirIdx][0];
			int j =cur[1]+move[dirIdx][1];
			if(!check(i, j, N) || map[i][j]==2) break; //벽을 만나거나 뱀을 만나면 중단
			if(map[i][j] == 0) {
				int[] temp = deque.pollLast(); // 뒤에서 제거
				map[temp[0]][temp[1]] = 0; //꼬리 제거 , map상태를 0으로 돌려놓기
			}
			deque.offerFirst(new int[] {i,j}); //앞에 추가
			map[i][j] = 2; // map을 2로 변경
			t++;
		}
		System.out.println(t+1);
	}
	public static boolean check(int i, int j , int N) { //범위 안에 있으면 true , 아니면 false
		if(i>=0 && i<N && j>=0 && j<N) return true;
		return false;
	}
}
