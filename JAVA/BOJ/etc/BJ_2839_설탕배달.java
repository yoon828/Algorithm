import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  N킬로그램 배달
 *  설탕 봉지는 3키로, 5키로 봉지
 * 
 */
public class BJ_2839_설탕배달 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		while (N >= 3 * 5) {
			N = N - 5;
			cnt++;
		}
		while (N > 2) {
			if (N % 3 == 0) {
				cnt += N / 3;
				N = 0;
				break;
			}
			if (N / 5 > 0) {
				cnt++;
				N = N - 5;
			} else if (N / 3 > 0) {
				cnt++;
				N = N - 3;
			}
		}
		if (N > 0) {
			cnt = -1;
		}

		System.out.println(cnt);

	}
}
