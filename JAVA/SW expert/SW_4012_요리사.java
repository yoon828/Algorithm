import java.io.*;
import java.util.StringTokenizer;

/*
 * N개의 식재료
 */
public class SW_4012_요리사 {
	public static int N, n, min;
	public static int[] A;
	public static int[] B;
	public static boolean[] used;
	public static int[][] syn;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input_SW_4012.txt")); // 제출 삭제@@@@
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //N입력
			n = N / 2; //N의 절반

			syn = new int[N][N]; //시너지 저장 
			A = new int[n]; //A 요리 재료 저장 
			B = new int[n]; //B 요리 재료 저장
			used = new boolean[N]; //사용했는지
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					syn[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// N/2개 뽑는 조합
			// 조합이 중복되므로 첫번째 값을 고정
			A[0] = 0;
			used[0] = true;
			//그 다음 수 부터 조합 뽑기
			Combination(1, 1, used);
			System.out.printf("#%d %d\n",test_case,min);
		}
	}

	public static void Combination(int cnt, int start, boolean[] isUsed) {
		if (cnt == n) {
			//A재료를 다 뽑았으면
			//사용여부를 확인해서 B재료도 배열에 넣어주기
			for (int i = 0, idx = 0; i < N && idx < n; i++) {
				if (used[i] == false)
					B[idx++] = i;
			}
			
			// A , B 재료 완성
			//각 시너지 구한 후 차이값의 절대값을 현재 최소값과 비교
			min = Math.min(Math.abs(getSyn(A)-getSyn(B)) ,min);
			
			return;
		}

		for (int i = start; i < N; i++) {
			A[cnt] = i;
			isUsed[i] = true;
			Combination(cnt + 1, i + 1, isUsed);
			isUsed[i] = false;

		}

	}

	public static int getSyn(int[] arr) {
		int synergy = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == j)
					continue;
				synergy += syn[arr[i]][arr[j]];
			}
		}
		return synergy;
	}
}
