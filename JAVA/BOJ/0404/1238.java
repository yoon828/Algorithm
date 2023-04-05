package ps;

import java.io.*;
import java.util.*;

public class BOJ_1238 {
    static int N,M,X;
    static int[][] adjMatrix;
    static int[] go;
    static int[] back;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;
        adjMatrix = new int[N][N]; //인접 행렬
        for(int i=0 ;i<M; i++){
            st = new StringTokenizer(br.readLine());
            adjMatrix[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
        }
        //갈 때
        int[] go = new int[N];
        for(int i=0; i<N; i++){
            go[i]=dijkstra(i, X);
        }
        //올 때
        back = new int[N];
        for(int i=0; i<N; i++){
            back[i] = dijkstra(X, i);
        }
        int max = 0;
        for(int i=0; i<N; i++){
            max = Math.max(max, go[i]+back[i]);
        }
        System.out.println(max);
    }
    static int dijkstra(int start, int end){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        boolean[] visit = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start]= 0;
        pq.add(new int[]{start, dist[start]});
        while(!pq.isEmpty()){
            int num = pq.peek()[0]; int d = pq.poll()[1];
            if(num==end) break;
            if(visit[num]) continue;
            visit[num] = true;
            for(int i=0; i<N; i++){
                if(adjMatrix[num][i]>0 && !visit[i]
                && dist[i] > dist[num]+ adjMatrix[num][i]){
                    dist[i] = dist[num]+ adjMatrix[num][i];
                    pq.add(new int[]{i, dist[i]});
                }
            }
        }
        return dist[end];
    }
}

