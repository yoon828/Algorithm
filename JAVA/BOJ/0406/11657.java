import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int from, to, cost;
        Node(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int INF = Integer.MAX_VALUE;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node[] list = new Node[M];
        for(int i=0; i<M; i++){ //도로
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); int E = Integer.parseInt(st.nextToken()); int T = Integer.parseInt(st.nextToken());
            list[i] = new Node(S,E,T);
        }
        long[] dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean flag = false;
        for(int i=0; i<=N; i++){ //정점 개수만큼
            for(int j=0; j<M; j++){ //간선 개수만큼
                Node node = list[j];
                if(dist[node.from] != INF
                        && dist[node.to] > dist[node.from]+node.cost){
                    if(i==N) {
                        flag = true;
                        break;
                    }
                    dist[node.to] = dist[node.from] +node.cost;
                }
            }
        }
        if(flag) System.out.println(-1);
        else{
            StringBuilder sb = new StringBuilder();
            for(int i=2; i<=N; i++) {
                if (dist[i] == INF) sb.append(-1);
                else sb.append(dist[i]);
                sb.append("\n");
            }
            sb.setLength(sb.length()-1);
            System.out.println(sb);
        }
    }
}