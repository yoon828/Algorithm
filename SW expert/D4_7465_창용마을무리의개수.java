import java.io.*;
import java.util.*;

public class D4_7465_창용마을무리의개수 {
	static int[] boss;
	
	private static void union(int a, int b) { //무리 합치기
		boss[findBoss(b)] = findBoss(a);
	}

	private static int findBoss(int a) { //무리의 대장 찾기
		if (boss[a] == a)return a;
		return boss[a] = findBoss(boss[a]);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 1~N번까지의 사람
			int M = Integer.parseInt(st.nextToken()); // 관계 수
			boss = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				boss[i] = i;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); 
				if(st.hasMoreElements()) { //뒤에 두번째 수가 있으면
					int b = Integer.parseInt(st.nextToken());
				if (findBoss(a) != findBoss(b))	//각각의 무리 대장을 찾고 같은 무리인지 확인 
					union(a, b); //아니면 합치기
				}
			}
			boolean[] count = new boolean[N+1]; //무리의 개수를 찾기 위해 cnt했는지 체크할 변수
			int cnt =0; 
			for (int i = 1; i <=N; i++) {
				boss[i] = findBoss(i); //무리의 대장을 업데이트해주고 (예전 대장을 알고 있는 경우가 있음)
				if(!count[boss[i]]) { //만약 체크가 안되어있으면 cnt+1 해주고 체크표시 해주기
					cnt++; 
					count[boss[i]] = true;
				}
			}
			System.out.printf("#%d %d\n", test_case, cnt);
		}
	}
}
