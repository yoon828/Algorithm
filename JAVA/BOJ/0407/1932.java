package ps;

import java.io.*;
import java.util.*;

public class BOJ_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] circle = new int[n][];
        int[][] dp = new int[n][];
        for(int i=0 ;i<n; i++){
            circle[i] = new int[i+1];
            dp[i] = new int[i+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1;j++){
                circle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0]= circle[0][0];
        for(int i=0; i<n-1; i++){
            for(int j=0; j<i+1; j++){
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]+circle[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]+circle[i+1][j+1]);
            }
        }
        int ans=0;
        for(int i=0; i<n; i++){
            ans = Math.max(dp[n-1][i], ans);
        }
        System.out.println(ans);
    }
}

