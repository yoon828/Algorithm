import java.io.*;
import java.util.*;

import sun.security.provider.certpath.Vertex;

public class BJ_1753_최단경로 {
	static class Node {
		int vertex, weight;
		Node link;
		public Node(int vertex, int weight, Node link) {
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int V = Integer.parseInt(st.nextToken());
		int E =  Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int K =   Integer.parseInt(st.nextToken()); //시작 정점

		Node[] adjList = new Node[V+1];
		boolean[]visited = new boolean[V+1];
		int[] distance =new int[V+1]; 
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		for (int i = 0; i < E; i++) { //인접 리스트
			st = new StringTokenizer(br.readLine());
			int from   = Integer.parseInt(st.nextToken());
			int to   = Integer.parseInt(st.nextToken());
			int weight   = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight,adjList[from] );
		}
		
		Arrays.fill(distance,Integer.MAX_VALUE);
		
		distance[K] = 0; 
		pq.add(new int[]{K,distance[K]}); //정점 번호와 거  리의 최소값을 넣기
		
		while(!pq.isEmpty()) {
			//최소 비용 찾기
			int[] temp = pq.poll();
			int idx = temp[0];
			if(visited[idx]) continue;
			visited[idx] =true;
			
			//선택한 걸 경유지로 해서 최소 비용 업데이트
			for (Node j = adjList[idx] ; j != null ; j = j.link) {
				if(!visited[j.vertex]  && distance[j.vertex] > distance[idx]+ j.weight) {
					distance[j.vertex] = distance[idx]+ j.weight;
					pq.add(new int[] {j.vertex, distance[j.vertex]});
				}
			}
		}	
		for (int i = 1; i <= V; i++) {
			if(distance[i] != Integer.MAX_VALUE)sb.append(distance[i]+"\n");
			else sb.append("INF\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
