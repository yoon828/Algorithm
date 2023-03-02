import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D6_사람네트워크2 {
	static final int INF = 9999999;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] adjMatrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjMatrix[i][j] = Integer.parseInt(st.nextToken());
					if(i!=j && adjMatrix[i][j] == 0) adjMatrix[i][j] = INF;
				}	
			}
			
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if(k==i) continue;
					for (int j = 0; j < N; j++) {
						if(k==j || i==j) continue;
						if(adjMatrix[i][j] > adjMatrix[i][k]+adjMatrix[k][j])
							adjMatrix[i][j] = adjMatrix[i][k]+adjMatrix[k][j];
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum+= adjMatrix[i][j];
				}
				min = Math.min(min, sum);
			}
			System.out.printf("#%d %d\n", tc, min);
		}
	}
}
