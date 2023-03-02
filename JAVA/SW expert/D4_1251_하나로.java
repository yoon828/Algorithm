import java.io.*;
import java.util.*;

public class D4_1251_하나로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			double[] minDist = new double[N]; 
			boolean[] visited = new boolean[N]; //체크여부
			int[] x = new int[N];
			int[] y = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			double E = Double.parseDouble(st.nextToken());

			double[][] adjMatrix = new double[N][N]; //인접행렬
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) { //인접 행렬에 각 섬 사이의 거리 값 저장
					if(x[i]== x[j] || y[i] ==y[j]) 
						adjMatrix[i][j] = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
					else adjMatrix[i][j] = Math.sqrt( Math.pow(x[i]-x[j],2)+Math.pow(y[i]-y[j],2) );
				}
				minDist[i] = Integer.MAX_VALUE;
			}
			
			//프림 알고리즘 
			minDist[0] = 0;
			double ans = 0; 
			for (int c = 0; c < adjMatrix.length; c++) {
				double min = Integer.MAX_VALUE;
				int minVertex = -1;
				
				for (int i = 0; i < N; i++) {
					if(!visited[i]&&min > minDist[i]) { //가장 최소 거리 찾기
						min = minDist[i];
						minVertex = i; 
					}
				}
				visited[minVertex] = true; 
				ans+= E * min*min; //환경부담금 계산 후 더하기
				
				for (int i = 0; i < N; i++) {
					if(!visited[i]&& minDist[i]> adjMatrix[minVertex][i]) { //갈 수 있는 섬들 업데이트
						minDist[i] = adjMatrix[minVertex][i];
					}
				}
			}	
			System.out.printf("#%d %.0f\n",test_case, ans);
		}
	}

}
