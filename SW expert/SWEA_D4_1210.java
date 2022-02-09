package com.ssafy.im;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 사다리타기
 * 사다리 크기는 100 * 100
 * 테스트 케이스는 10개
 * @author 김윤민
 *
 * 1. 0번째 행에서 1인 인덱스를 찾아서 배열에 저장 
 * 2. 1열부터 시작. 시작 줄 저장 / 현재 줄 위치 저장
 * 3. 현재 값이 2인지 확인/ 맞으면 return , 아니면 
 * ==>왼쪽, 오른쪽에 1이 있는지 확인
 * => 있으면 해당 방향으로 이동, 방향에 맞춰서 현재 줄위치 업데이트
 * 4. 아래로 이동
 * 5. 3으로 
 * 6. 2를 만나면 종료 후 결과 출력
 */
public class D4_1210 {
	public static int[][] map;
	public static List<Integer> starts;
	public static int[] dc = { -1, 1 };
	public static int N = 100;
	public static int start = 0;
	public static int now = 0;
	public static int getResult = 0;

//	  3. 현재 값이 2인지 확인/ 맞으면 return , 아니면 
//		==>왼쪽, 오른쪽에 1이 있는지 확인
//		==> 있으면 해당 방향으로 이동, 방향에 맞춰서 현재 줄위치 업데이트
//	  4. 아래로 이동
	public static void move(int i, int j) {
		// 마지막 줄 일때
		if (i == 99) {
			//마지막 값이 2이면 값을 얻었음을 표시하는 변수 getResult에 +1 
			if (map[i][j] == 2) {
				getResult++;
			} 
			return;
		}

		for (int k = 0; k < dc.length; k++) {
			int x = j + dc[k];
			//인덱스가 범위 안에 있고, 그 값이 1인 경우
			if (x >= 0 && x < 100 && map[i][x] == 1) {
				//열 업데이트 및 탐색 종료
				now = starts.get(starts.indexOf(now) + dc[k]);
				break;
			}
		}
		//재귀함수 호출
		move(i + 1, now);

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input_D4_1210.txt"));
		Scanner sc = new Scanner(System.in);
		int tc = 10;

		for (int test_case = 1; test_case <= tc; test_case++) {
			sc.next();
			map = new int[N][N];
			starts = new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 1번
			for (int i = 0; i < N; i++) {
				if (map[0][i] == 1)
					starts.add(i);
			}
			now = 0;
			getResult = 0;
			for (int i = 0; i < starts.size(); i++) {
				start = starts.get(i);
				now = start;
				move(0, start);
				if (getResult > 0)
					break;
			}

			System.out.printf("#%d %d\n", test_case, start);

		}

	}

}
