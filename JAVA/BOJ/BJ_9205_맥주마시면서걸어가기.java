import java.io.*;
import java.util.*;
public class BJ_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			String ans = "sad";
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] store = new int[n][2]; 
			st = new StringTokenizer(br.readLine());
			int hx = Integer.parseInt(st.nextToken());
			int hy = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			int gx = Integer.parseInt(st.nextToken());
			int gy = Integer.parseInt(st.nextToken());
			
			boolean[] visit = new boolean[n];
			Queue<int[]> que = new LinkedList<>();
			que.offer(new int[] {hx,hy});
			while(!que.isEmpty()) {
				int[] temp = que.poll();
				if(Math.abs(temp[0]-gx) + Math.abs(temp[1]-gy) <= 20*50) {
					ans = "happy";
					break;
				}
				for (int i = 0; i < n; i++) {
					if(Math.abs(temp[0]-store[i][0]) + Math.abs(temp[1]-store[i][1]) <= 20*50 && !visit[i]) {
						visit[i] = true;
						que.offer(new int[] {store[i][0], store[i][1]});
					}
				}
			}
			bw.write(ans+"\n");
		}
		bw.flush();
		bw.close();
	}
}
