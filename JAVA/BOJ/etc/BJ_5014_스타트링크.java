package D0319;

import java.io.*;
import java.util.*;

public class BJ_5014_스타트링크 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str= br.readLine().split(" ");
		int F = Integer.parseInt(str[0]);
		int S = Integer.parseInt(str[1]);
		int G = Integer.parseInt(str[2]);
		int U = Integer.parseInt(str[3]);
		int D = Integer.parseInt(str[4]);
		String ans = "use the stairs";
		boolean[] visit = new boolean[F+1];
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[]{S, 0});
		visit[S] = true;
		int min = Integer.MAX_VALUE;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(cur[0] == G) {
				min = Math.min(min, cur[1]);
				continue;
			}
			if(cur[0]+U <= F && !visit[cur[0]+U]) {
				visit[cur[0]+U] = true;
				que.add(new int[] {cur[0]+U, cur[1]+1});
			}
			if(cur[0]-D >=1 && !visit[cur[0]-D]) {
				visit[cur[0]-D] = true;
				que.add(new int[] {cur[0]-D, cur[1]+1});
			}
		}
		if(min == Integer.MAX_VALUE) System.out.println(ans);
		else System.out.println(min);
	}
}
