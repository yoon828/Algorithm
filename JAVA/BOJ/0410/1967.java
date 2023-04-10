package ps;

import java.io.*;
import java.util.*;

public class BOJ_1753 {
    static class Node{
        int num, weight;
        Node next;
        Node(int num, int weight, Node next){
            this.num =num;
            this.weight = weight;
            this.next = next;
        }
    }
    static int N;
    static Node[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adjList = new Node[N];
        for(int i=0; i<N-1; i++){
            String[] tokens = br.readLine().split(" ");
            int p = Integer.parseInt(tokens[0])-1;
            int c = Integer.parseInt(tokens[1])-1;
            int w = Integer.parseInt(tokens[2]);
            adjList[p] = new Node(c, w, adjList[p]);
            adjList[c] = new Node(p, w, adjList[c]);
        }
        int[] max = dijkstra(0);
        int[] res = dijkstra(max[0]);
        System.out.println(res[1]);
    }
    static int[] dijkstra(int start){
        boolean[] visit = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{start, 0});
        while(!pq.isEmpty()){
            int num = pq.poll()[0];
            if(visit[num]) continue;
            visit[num] = true;
            for(Node node = adjList[num]; node!=null; node = node.next){
                if(!visit[node.num] && dist[node.num]> dist[num]+ node.weight){
                    dist[node.num]= dist[num]+ node.weight;
                    pq.offer(new int[]{node.num, dist[node.num]});
                }
            }
        }
        int idx=0; int max=0;
        for(int i=0; i<N; i++){
            if(max < dist[i]){
                idx=i; max = dist[i];
            }
        }
        return new int[]{idx, max};
    }
}

