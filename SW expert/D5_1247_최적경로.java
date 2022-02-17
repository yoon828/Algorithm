import java.io.*;
import java.util.StringTokenizer;

public class D5_1247_최적경로 {
	public static int N, min;
	public static int[] company;
	public static int[] home;
	public static int[][] custom;
	public static int[][] order;
	public static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("input_1247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			company = new int[2];
			home = new int[2];
			custom = new int[N][2];
			order = new int[N][2];
			isSelected = new boolean[N];
			min = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 2; i++) {
				company[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < 2; i++) {
				home[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				custom[i][0] = Integer.parseInt(st.nextToken());
				custom[i][1] = Integer.parseInt(st.nextToken());
			}

			// 최단 경로의 이동거리 찾기
			findMinDist(0);
			System.out.printf("#%d %d\n", test_case, min);
		}
	}

	private static void findMinDist(int cnt) { // 순서 정하기 (순열)
		if (cnt == N) {
			int dist = findDist(order); //경로 구하기
			min = Math.min(dist, min);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i])continue;
			order[cnt] = custom[i]; 
			isSelected[i] = true;
			findMinDist(cnt + 1);
			isSelected[i] = false;
		}
	}

	private static int findDist(int[][] or) {
		int sum = 0;
		// 회사에서 첫번째 고객
		sum += Math.abs(company[0] - or[0][0]) + Math.abs(company[1] - or[0][1]);
		// 첫번째 고객~ 마지막 고객
		for (int i = 0; i < N - 1; i++) {
			sum += Math.abs( or[i][0] - or[i+1][0]) + Math.abs(or[i][1] -  or[i+1][1]);
		}
		// 마지막 고객 ~ 집
		sum += Math.abs(home[0] - or[N-1][0]) + Math.abs(home[1] -  or[N-1][1]);
		return sum;
	}

}
