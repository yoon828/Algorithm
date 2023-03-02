import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074_Z {
	public static int num, N, r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int doubleN = (int) Math.pow(2, N);
		num = 0;
		binaryZ(doubleN, 0, 0);

	}

	private static void binaryZ(int n, int i, int j) {
		// 기저 조건 n이 1이거나 현재 위치가 내가 찾는 위치라면
		if (n == 1 || (i == r && j == c)) {
			System.out.println(num);
			return;
		}
		int half = n / 2; //현재 길이를 절반으로 나누기
		if (i + half <= r) { //  현재 반으로 나뉜 행이 r보다 더 작다면
			i = i + n / 2; //현재 위치를 업데이트
			num += n / 2 * n / 2 * 2; //탐색 횟수 추가 해주기 
		}
		if (j + half <= c) { // 
			j = j + n / 2;
			num += n / 2 * n / 2;
		}
		binaryZ(n / 2, i, j);

	}

}
