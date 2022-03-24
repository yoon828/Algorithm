import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1546_평균 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] score = new double[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		double max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			max = Math.max(score[i], max);
		}
		double sum =0;
		for (int i = 0; i < N; i++) {
			score[i] = score[i]/max *100.0;
			sum+= score[i];
		}
		System.out.println(sum/N);
	}
}
