package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        boolean[] trueList = new boolean[N]; //진실을 아는 사람 true
        int K = Integer.parseInt(st.nextToken());
        if(K>0){
            for(int i=0; i<K; i++){
                trueList[Integer.parseInt(st.nextToken())-1] = true;
            }
        }
        //각 파티마다 오는 사람들
        int[][] parties = new int[M][];
        boolean[][] adjMatrix = new boolean[N][N];
        for(int i=0; i<M; i++){
            st= new StringTokenizer(br.readLine());
            int party = Integer.parseInt(st.nextToken()); //파티에 오는 사람 수
            parties[i] = new int[party];
            for(int j=0; j<party; j++){
                int num = Integer.parseInt(st.nextToken())-1;
                parties[i][j] = num;
            }
            //파티 인원들 연결
            for(int j=0; j<party-1; j++){
                for(int k=j+1; k<party; k++){
                    adjMatrix[parties[i][j]][parties[i][k]] = true;
                    adjMatrix[parties[i][k]][parties[i][j]] = true;
                }
            }
        }
        //인접 행렬로 진실을 아는 사람 갱신
        for(int i=0;i<N;i++){
            if(trueList[i]) continue;
            boolean[] visit = new boolean[N];
            Queue<Integer> que = new LinkedList<>();
            que.add(i);
            visit[i]= true;
            while(!que.isEmpty()){
                int num = que.poll();
                if(trueList[num]){
                    trueList[i] = true;
                    break;
                }
                for(int j=0; j<N; j++){
                    if(num!=j && adjMatrix[num][j] && !visit[j]){
                        visit[j] = true;
                        que.add(j);
                    }
                }
            }
        }

        int cnt=0;
        outer:for(int i=0; i<M; i++){
            for(int j=0;j<parties[i].length; j++){
                if(trueList[parties[i][j]]){
                    continue outer;
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
