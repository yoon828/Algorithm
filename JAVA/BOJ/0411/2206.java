package ps;

import java.io.*;
import java.util.*;

public class BOJ_1753 {
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    static int N, M, min;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            String[] tokens = br.readLine().split("");
            for(int j =0; j<M; j++){
                map[i][j] = Integer.parseInt(tokens[j]);
                if(map[i][j]==1) list.add(new int[]{i, j});
            }
        }
        min = Integer.MAX_VALUE;
        //최단 경로 찾기
        findLoad();

        if(min ==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
    static void findLoad() {
        boolean[][][] visit = new boolean[N][M][2];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0, 1, 1});// 좌표와 이동수, 벽 부술 기회
        visit[0][0][1] = true;
        while (!que.isEmpty()) {
            int i = que.peek()[0]; int j = que.peek()[1]; int cnt = que.peek()[2]; int broke = que.poll()[3];
            if (i == N - 1 && j == M - 1) {
                min = Math.min(min, cnt);
                break;
            }
            if (cnt >= min) break;
            for (int d = 0; d < 4; d++) {
                int p = i + move[d][0];
                int q = j + move[d][1];
                if (p >= 0 && p < N && q >= 0 && q < M
                        && !visit[p][q][broke]) {
                    if (map[p][q] == 1 && broke > 0) {
                        que.add(new int[]{p, q, cnt + 1, broke - 1});
                    } else if (map[p][q] == 0) {
                        visit[p][q][broke] = true;
                        que.add(new int[]{p, q, cnt + 1, broke});
                    }
                }
            }

        }
    }
}


