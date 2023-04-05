package ps;

import java.io.*;
import java.util.*;

public class BOJ_1504 {
    static int N;
    static int[][] adjMatrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); int E = Integer.parseInt(st.nextToken());
        adjMatrix = new int[N][N];
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            adjMatrix[a][b] = c;
            adjMatrix[b][a] = c;
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken())-1;
        int v2 = Integer.parseInt(st.nextToken())-1;

        int min = Integer.MAX_VALUE;
        int ma1 = dijkstra(0,v1); int ma2 =dijkstra(v1, v2); int ma3 = dijkstra(v2,N-1);
        if(ma1 != -1 && ma2!= -1 && ma3 != -1){
            min  = Math.min(min, ma1+ma2+ma3);
        }
        int mb1 = dijkstra(0,v2); int mb2 =dijkstra(v2, v1); int mb3 = dijkstra(v1,N-1);
        if(mb1 != -1 && mb2!= -1 && mb3 != -1){
            min  = Math.min(min, mb1+mb2+mb3);
        }
        if(min==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    static int dijkstra(int start, int end){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        boolean[] visit = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new int[]{start, 0});
        while(!pq.isEmpty()){
            int num = pq.poll()[0];
            if(visit[num]) continue;
            visit[num] = true;
            if(num==end) break;
            for(int i=0; i<N; i++){
                if(adjMatrix[num][i]>0 && !visit[i] && dist[i] > dist[num]+adjMatrix[num][i]){
                    dist[i] = dist[num]+adjMatrix[num][i];
                    pq.add(new int[]{i, dist[i]});
                }
            }
        }
        if(dist[end] ==Integer.MAX_VALUE) return -1;
        return dist[end];
    }
}

