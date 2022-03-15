package D0316;
import java.io.*;
import java.util.*;
public class BJ_11724_연결요소의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int[] parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		for (int i = 0; i < M; i++) {
			String[] strs = br.readLine().split(" ");
			int f =Integer.parseInt(strs[0]);
			int s =Integer.parseInt(strs[1]);
			if(findP(f, parents) != findP(s, parents)) {
				parents[findP(s,parents)] = findP(f,parents);
			}
		}
		for (int i = 1; i <= N; i++) {
			parents[i] =findP(i,parents);
		}
		boolean[] ch = new boolean[N+1];
		int cnt =0;
		for (int i = 1; i <=N; i++) {
			if(!ch[parents[i]]) {
				cnt++;
				ch[parents[i]]= true;
			}
		}
		System.out.println(cnt);
	}
	static int findP(int i, int[] p) {
		while(true){
			if(i != p[i]) {
				i = p[i];
				continue;
			}
			return i;
		}
	}
}
