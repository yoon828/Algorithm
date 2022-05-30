import java.io.*;
import java.util.*;

public class BJ_11399_ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] p= new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(p);
		int sum = 0;
		int prev = 0;
		for (int i = 0; i < N; i++) {
			sum+= p[i]+ prev;
			prev = p[i] + prev;
		}
		System.out.println(sum);
	}
}
