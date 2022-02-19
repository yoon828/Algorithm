package day_0219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 변방향 길이
 * 1 2 3 4 : 동 서 남 북 
 * 
 * 90분
 */
public class BJ_2477_참외밭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());

		int hMax = 0, wMax = 0; //각 가로 세로의 최대 길이 저장
		int hMaxIdx = -1, wMaxIdx = -1; //가로 세로의 최대 길이의 인덱스 저장 

		int[] dirs = new int[6]; //순서대로 방향 저장
		int[] dist = new int[6]; //변의 길이 저장
 
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			dirs[i] = Integer.parseInt(st.nextToken());
			dist[i] = Integer.parseInt(st.nextToken());
			if (dirs[i] == 1 || dirs[i] == 2) { //가로 방향이면
				if (hMax < dist[i]) { //가로에 해당하는 변수들에 최대값, 인덱스 저장
 					hMax = dist[i];
					hMaxIdx = i;
				}
			} else {//세로에 해당하는 변수들에 최대값, 인덱스 저장
				if (wMax < dist[i]) {
					wMax = dist[i];
					wMaxIdx = i;
				}
			}
		}
		int maxSquare = wMax * hMax; //전체 사각형의 넓이
		//각 인덱스의 +3을 하면 안에 있는 사각형의 길이를 가지고 있는 인덱스임
		int minSquare = dist[(wMaxIdx + 3) % 6] * dist[(hMaxIdx + 3) % 6]; 

		System.out.println((maxSquare-minSquare)*K);

	}

}
