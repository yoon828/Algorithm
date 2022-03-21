import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2577_숫자의개수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n1 = Integer.parseInt(br.readLine());
		int n2 = Integer.parseInt(br.readLine());
		int n3 = Integer.parseInt(br.readLine());
		String sum = Long.toString(n1*n2*n3);
		int[] cnt = new int[10];
		for (int i = 0; i < sum.length(); i++) {
			cnt[sum.charAt(i)-'0']++;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(cnt[i]);
		}
	}
}
