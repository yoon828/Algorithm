import java.io.*;
import java.util.Arrays;

public class SWEA_D4_최소스패닝트리 {
	static int[] p;
	static class Node implements Comparable<Node> {
		int  from,to,weight;
		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
	static int findP(int n) {
		if(p[n] == n) return n;
		return p[n] = findP(p[n]);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String[] t = br.readLine().split(" ");
			int V = Integer.parseInt(t[0]);
			int E = Integer.parseInt(t[1]);
			Node[] list = new Node[E];
			
			p = new int[V+1];
			for (int i = 1; i <= V; i++) {
				p[i] = i; 
			}
			for (int i = 0; i < E; i++) {
				String[] temp = br.readLine().split(" ");
				int from = Integer.parseInt(temp[0]);
				int to = Integer.parseInt(temp[1]);
				int weight = Integer.parseInt(temp[2]);
				list[i] = (new Node(from, to, weight));
			}
			Arrays.sort(list);
			long sum=0;
			int cnt=0;
			for (int i = 0; i < E; i++) {
				int a = findP(list[i].from);
				int b = findP(list[i].to);
				if(a!= b) {
					p[b] = a;
					sum+= list[i].weight;
					cnt++;
				}
				if(cnt==V-1) break;
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}
}

