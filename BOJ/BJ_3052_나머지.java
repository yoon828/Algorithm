import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3052_나머지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] check = new boolean[42];
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			check[n%42] = true;
		}
		int cnt =0;
		for (int i = 0; i < 42; i++) {
			if(check[i]) cnt++;
		}
		System.out.println(cnt);
	}
}
