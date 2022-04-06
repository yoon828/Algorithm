import java.io.*;
import java.util.*;

public class BJ_17471_게리맨더링 {
	static boolean[][] adj;
	static int[] p;
	static int N, min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		p = new int[N]; //인구수 저장 
		adj = new boolean[N][N]; //인접 배열
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i] =  Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) { //인접 배열 정보 담기
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				int t = Integer.parseInt(st.nextToken())-1;
				adj[i][t] = true;
			}
		}
		min = Integer.MAX_VALUE;
		for (int i = 1; i <= N/2; i++) {
			combi(0,0,i,new int[i]);
		}
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
		
	}
	private static void combi(int cnt, int start, int k, int[] result) {
		if(cnt==k) {
			int aSum =0, bSum=0;
			boolean[] ch = new boolean[N];
			for (int i = 0; i < k; i++) {
				aSum+= p[result[i]];
				ch[result[i]] = true;
			}
			int[] bR = new int[N-k];
			int idx =0; 
			for (int i = 0; i < N; i++) {
				if(!ch[i]) {
					bSum+= p[i];
					bR[idx++] = i; 
				}
			}
			if(!check(result)) return;
			if(!check(bR)) return;
			
			min = Math.min(min, Math.abs(aSum-bSum));
			return;
		}
		for (int i = start; i < N; i++) {
			result[cnt] = i;
			combi(cnt+1, i+1, k, result); 
		}
	}
	private static boolean check(int[] arr) { //인접하는지 확인
		Queue<Integer> que = new LinkedList<>();
		boolean[] visit = new boolean[arr.length];
		que.add(0);
		visit[0] = true;
		while(!que.isEmpty()) {
			int t = que.poll();
			for (int i = 0; i < arr.length; i++) {
				if(adj[arr[t]][arr[i]]==true && !visit[i]) {
					visit[i] = true;
					que.add(i);
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if(!visit[i]) return false;
		}
		return true;
	}
}
