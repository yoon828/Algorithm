package day_0219;

import java.util.Scanner;

public class BJ_10157_자리배정 {
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	public static boolean[][] isSeated;
	public static int C, R, K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		 C = sc.nextInt(); //열
		 R = sc.nextInt(); //행
		 K = sc.nextInt(); //대기 번호
		
		isSeated = new boolean[R][C];
		
		if(K > C * R) {
			System.out.println(0);
		}else {
			seating(0, 0, 1, 0);
		}
	}
	private static void seating(int i, int j, int k, int dir) { //현재 좌석 위치 i, j, 현재 대기번호, 방향
		if(k == K) { //기저 조건 , 찾고자하는 대기 번호면 출력
			System.out.print((j+1)+" "+(i+1)); //인덱스가 0부터 시작하므로 1더해주기
			return;
		}
		isSeated[i][j] = true; //좌석 사용중 표시
		
		//좌석 위치 업데이트 
		int p =i+move[dir][0];
		int q =j+move[dir][1];
		
		if( p >=0 && p < R  && q >=0  && q <C && !isSeated[p][q]) {
			seating(p, q, k+1, dir);
		}else { //범위에서 벗어나고 이미 누가 자리에 있다면 방향 바꾸기
			dir = (dir+1)%4; 
			p =i+move[dir][0];
			q =j+move[dir][1];
			seating(p, q, k+1, dir);
		}
		
	}
}
