package ps;

import java.io.*;
import java.util.*;

public class BOJ_1753 {
    static class Node{
        int to, weight;
        Node next;
        Node(int to, int weight, Node next){
            this.to = to;
            this.weight = weight;
            this.next = next;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Node[] adjList = new Node[N+1];
        StringTokenizer st = null;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, cost, adjList[from]);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); int end = Integer.parseInt(st.nextToken());

        boolean[] visit =new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{start, 0});
        while(!pq.isEmpty()){
            int num = pq.poll()[0];
            if(visit[num]) continue;
            visit[num] = true;
            if(num==end) break;
            for(Node node = adjList[num]; node!=null; node = node.next){
                if(!visit[node.to] && dist[node.to] > dist[num]+node.weight){
                    dist[node.to] = dist[num]+node.weight;
                    pq.add(new int[]{node.to, dist[node.to]});
                }
            }
        }
        System.out.println(dist[end]);
    }
}

