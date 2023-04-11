package ps;

import java.io.*;
import java.util.*;

public class BOJ_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[] beforeMax = new int[3]; int[] beforeMin = new int[3];
        int[] nextMax = new int[3]; int[] nextMin = new int[3];
        st = new StringTokenizer(br.readLine());
        beforeMax[0] = beforeMin[0] = Integer.parseInt(st.nextToken());
        beforeMax[1] = beforeMin[1] = Integer.parseInt(st.nextToken());
        beforeMax[2] = beforeMin[2] = Integer.parseInt(st.nextToken());
        //2번줄 부터
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int num1 =Integer.parseInt(st.nextToken()); int num2 =Integer.parseInt(st.nextToken()); int num3 =Integer.parseInt(st.nextToken());
            //최대값
            nextMax[0] = num1+Math.max(beforeMax[0], beforeMax[1]);
            nextMax[1] = num2+Math.max(beforeMax[0], Math.max(beforeMax[1], beforeMax[2]));
            nextMax[2] = num3+Math.max(beforeMax[1], beforeMax[2]);
            //최소값
            nextMin[0] = num1+Math.min(beforeMin[0], beforeMin[1]);
            nextMin[1] = num2+Math.min(beforeMin[0], Math.min(beforeMin[1], beforeMin[2]));
            nextMin[2] = num3+Math.min(beforeMin[1], beforeMin[2]);
            for(int j =0; j<3; j++){
                beforeMax[j] = nextMax[j];
                beforeMin[j] = nextMin[j];
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(beforeMax[0], Math.max(beforeMax[1],beforeMax[2]))).append(" ");
        sb.append(Math.min(beforeMin[0], Math.min(beforeMin[1],beforeMin[2]))).append(" ");
        System.out.println(sb.toString());
    }
}


