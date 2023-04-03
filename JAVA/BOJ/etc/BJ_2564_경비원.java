import java.io.*;
import java.util.*;

public class BJ_2564_경비원 {
	public static int sum, X, Y; 
	public static int[] now;
	static String str = "10 5\r\n" + "3\r\n" + "1 4\r\n" + "3 2\r\n" + "2 8\r\n" + "2 3";

	/*
	 * 방향 => 1: 북, 2: 남 , 3:서, 4:동
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new StringReader(str));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken()); // 열 개수 가로길이 
		X = Integer.parseInt(st.nextToken()); // 행 개수 세로길이

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 상점 개수

		now = new int[2];
		int[][] shops = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			shops[i][0] = Integer.parseInt(st.nextToken()); // 방향 어느 쪽에 있는지
			// 기준으로 부터 얼마나 떨어져 있는지
			// 북,남 인경우 왼쪽 경계 // 동서 인 경우 위쪽 경계
			shops[i][1] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		now[0] = Integer.parseInt(st.nextToken());
		now[1] = Integer.parseInt(st.nextToken());

		///// 정보 저장
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum+=findMin(shops[i]);
		}
		System.out.println(sum);
	}

	//상점의 최단 거리 찾기
	/*
	 * 1. 같은 면에 있는지 확인해서 같은 면이면 현재-상점거리 
	 * 2. 옆면이면 해당 방향으로 출발 
	 * => 왼쪽으로 출발 
	 * : now 방향이 2, 3이면 현재 거 + (2는 세로길이-상점위치 or 3은 상점 위치 ) 
	 * : now 방향이 1, 4이면  (1은 가로-본인 or 4는 세로-본인) + (1은 세로-상점 or 4는 가로-상점)
	 * => 오른쪽으로 출발 
	 * : now 방향이 2, 3이면 (2은 가로-본인 or 3는 세로-본인) + (2은 세로-상점 or 3는 상점)
	 * : now 방향이 1, 4이면  현재 거 + (1는 상점위치 or 4은 가로-상점 위치 ) 
	 * 3. 반대면이면 => 
	 * => (현재 위치의 왼쪽 + 상점의 왼쪽 길이)(dis)가 현재 방향의 길이 보다 같거나 작으면  왼쪽으로 탐색 아니면 오른쪽 탐색
	 * 왼쪽탐색 : 가로면 세로 or 세로면 가로의 길이 + 위해서 구했던 값(dis) 
	 * 오른쪽탐색 : 가로면 세로 or 세로면 가로의 길이 + 해당면길이*2-dis
	 */
	private static int findMin(int[] shop) {
		int min =0;
		int ndir = now[0];
		int sdir = shop[0];
		int ndist = now[1];
		int sdist = shop[1];
		if(ndir==sdir) { //1.
			return Math.abs(now[1]-shop[1]);
		}else if((ndir==1 && sdir==4) ||(ndir==2 && sdir==3) ||(ndir==3 && sdir==1) ||(ndir==4 && sdir==2) ) { //왼쪽 출발
			if(ndir==2) {
				min = ndist+ X-sdist;
			}else if(ndir==3) {
				min = ndist+ sdist;
			}else if(ndir==1||ndir==4) {
				min = Y-ndist+ X-sdist;
			}
			
		}else if((ndir==1 && sdir==3) ||(ndir==2 && sdir==4) ||(ndir==3 && sdir==2) ||(ndir==4 && sdir==1) ) { //오른쪽 출발
			if(ndir==2) {
				min = Y-ndist+ X-sdist;
			}else if(ndir==3) {
				min = X-ndist+ sdist;
			}else if(ndir==1) {
				min = ndist+sdist;
			}
			if(ndir==4) {
				min = ndist+ Y-sdist;
			}
		}else { //반대편이면
			int dis = 0; 
			int line =0;
			int lineB =0;
			if(ndir==1 ||ndir==2) {
				dis = ndist+ sdist;
				line = Y;
				lineB = X;
			}
			else {
				dis = X-ndist + X-sdist;
				line = X;
				lineB = Y;
			}
			if(dis <= line) { //왼쪽 탐색
				min =lineB +dis;
			}else {
				min =lineB +line*2-dis;
			}
				
		}
		return min; 
	}

}
