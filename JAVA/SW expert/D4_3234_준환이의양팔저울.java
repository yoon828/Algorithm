import java.io.*;
import java.util.*;

/*
 1. 처음엔 무조건 왼쪽 
 2. 두번째 부터는 오른쪽에 올릴 수 있는지 확인
 	있음 => 1. 오른쪽에 올리고 다음 추 올리러 가기 
		  2. 왼쪽에 올리고 다음 추 올리러 가기 
 	없음 => 왼쪽에 올리고 다음 추 올리러 가기 
  
 */

public class D4_3234_준환이의양팔저울 {
	static String str = "3\r\n" + "3\r\n" + "1 2 4\r\n" + "3\r\n" + "1 2 3\r\n" + "9\r\n" + "1 2 3 5 6 4 7 8 9";

	public static int N, count;
	public static int[] weight;
	public static int[] weightNew;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new StringReader(str));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			count = 0;
			weight = new int[N];
			weightNew = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			permu(0, 0);
			
			System.out.printf("#%d %d\n", test_case , count);
		}

	}

	private static void permu(int cnt, int flag) { //고른 추의 개수

		// 순열 기저 조건
		if (cnt == N) {
			// 추 올리러 가기
			goUp(0, 0, 0); //몇번째인지, 왼쪽합, 오른쪽 합 
			return;
		}

		for (int i = 0; i < N; i++) { //순열 구하기
			if ((flag & (1 << i)) != 0)
				continue;
			weightNew[cnt] = weight[i];
			permu(cnt + 1, flag | 1 << i);
		}

	}

	private static void goUp(int cnt, int lSum, int rSum) {//몇번째인지, 왼쪽합, 오른쪽 합 

		// 기저 조건 : 추를 다 올리면
		if (cnt == N) {
			count++; 
			return;
		}

		//가지치기
		if (cnt == 0) { //첫번째 추는 무조건 왼쪽
			goUp(cnt + 1, lSum + weightNew[cnt], rSum);
		} else { //두번재 추부터 
			if (lSum >= rSum + weightNew[cnt]) {// 오른쪽에 올릴 수 있는 경우
				goUp(cnt + 1, lSum, rSum + weightNew[cnt]); //오른쪽 가능
			}
			
			goUp(cnt + 1, lSum + weightNew[cnt], rSum); //왼쪽 가능

		}
	}
}
