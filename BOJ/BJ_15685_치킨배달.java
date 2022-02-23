import java.io.*;
import java.util.*;

public class BJ_15685_치킨배달 {
	public static int N, M, minDist;
	public static int[] chickenDist;
	public static int[][] map;
	public static int[][] selectChicken;
	public static List<int[]> chickens;
	public static List<int[]> homes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		chickens = new ArrayList<>(); // 치킨 집 리스트
		homes = new ArrayList<>(); // 집 리스트
		selectChicken = new int[M][2]; // 고른 치킨집 리스트

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					homes.add(new int[] { i, j }); // 집 리스트에 넣어주기
				else if (map[i][j] == 2)
					chickens.add(new int[] { i, j }); // 치킨집리스트에 넣어주기

			}
		}

		chickenDist = new int[homes.size()]; // 각 집마다 치킨거리 저장할 변수
		minDist = Integer.MAX_VALUE;
		combination(0, 0); // 조합 시작
		System.out.println(minDist);
	}

	private static void combination(int cnt, int start) {
		if (cnt == M) { // 기저 조건
			// 각 집마다 치킨 거리 구하러가기
			calcDist(selectChicken);
			
			int sum = 0;
			for (int i = 0; i < homes.size(); i++) { //각 치킨 거리의 합 
				sum += chickenDist[i];
			}
			minDist = Math.min(sum, minDist); //최소값으로
			return;
		}

		for (int i = start; i < chickens.size(); i++) {
			selectChicken[cnt] = chickens.get(i);
			combination(cnt + 1, i + 1);
		}
	}

	private static void calcDist(int[][] sc) {
		for (int i = 0; i < homes.size(); i++) { // 각 집마다 치킨 거리 구하기
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) { 
				int dist = Math.abs(homes.get(i)[0] - sc[j][0]) + Math.abs(homes.get(i)[1] - sc[j][1]);
				min = Math.min(dist, min); //치킨집과 집 사이에 가장 최단거리를 저장
			}
			chickenDist[i] = min; //치킨 거리 저장
		}

	}

}
