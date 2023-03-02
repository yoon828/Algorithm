import java.io.*;
import java.util.StringTokenizer;

public class D4_3289_서로소집합 {
	static int[] parents;

	static void makeSet(int N) { //각 부모를 자신으로 설정 
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	static void union(int a, int b) { //합집합
		int p = findParents(a);
		int q = findParents(b);
		parents[q] = p;
	}

	static int findParents(int n) { //부모 찾기
		if(parents[n] == n) return n;
		return parents[n]= findParents(parents[n]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb;

		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			 sb = new StringBuilder();
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			makeSet(N); // 초기 세팅

			//연산 횟수만큼 반복
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int mode = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(mode == 0 ) { //합집합이면
					if(findParents(a)!=findParents(b)) {// 같은 집합이 아니면 합치기
						union(a, b );
					}
				}else { //같은 집합인지 확인하기
					if(findParents(a)==findParents(b)) sb.append("1"); //같은 집합이면
					else sb.append("0"); //아니면
				}
				
			}
			System.out.println(sb);
		}

	}
}
