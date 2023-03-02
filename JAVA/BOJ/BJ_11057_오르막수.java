package D0301;

import java.io.*;

public class BJ_11057_오르막수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][10];
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}

		for (int i = 1; i < N; i++) { //N+1번째 까지 실행
			for (int j = 0; j < 10; j++) { //j는 맨 뒷자리
				for (int k = j; k < 10; k++) { //뒤에 붙일 수 있는 수는  j부터 9까지 이므로
					dp[i + 1][k] = (dp[i + 1][k] +dp[i][j])% 10007; //현재까지 만들 수 있는 자리수를 i+1자리의 뒷자리가 k인 경우에 더해주기
				}
			}

		}
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += (dp[N][i] % 10007);
		}
		System.out.println(sum % 10007);
	}
}
