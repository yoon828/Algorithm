package ps;

import java.io.*;
import java.util.*;

public class BOJ_1167 {
    static int V;
    static LinkedList<int[]>[] adjList;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        adjList = new LinkedList[V];
        StringTokenizer st = null;
        for(int i=0; i<V; i++){ //인접 리스트
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken())-1;
            LinkedList<int[]> arr = new LinkedList<>();
            while(true) {
                int tmp = Integer.parseInt(st.nextToken())-1;
                if (tmp == -2) break;
                int dist = Integer.parseInt(st.nextToken());
                arr.add(new int[]{tmp, dist});
            }
            adjList[num] = arr;
        }
        //아무거나 잡아서 가장 먼 정점 찾기
        int[] far = dijkstra(0);
        int[] result = dijkstra(far[0]);
        System.out.println(result[1]);
    }
    static int[] dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        boolean[] visit = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start]= 0;
        pq.add(new int[]{start, dist[start]});
        while(!pq.isEmpty()){
            int num = pq.poll()[0];
            if(visit[num]) continue;
            visit[num] = true;
            for(int[] tmp : adjList[num]){
                if(!visit[tmp[0]] &&
                        dist[tmp[0]] >  dist[num]+tmp[1]){
                    pq.add(new int[]{tmp[0], tmp[1]});
                    dist[tmp[0]] =  dist[num]+tmp[1];
                }
            }
        }
        int max =0;
        int idx = 0;
        for(int i=0 ;i<V; i++){
            if(max < dist[i]) {
                idx = i;
                max = dist[i];
            }
        }
        return new int[]{idx, max};
    }
}

