package D0310;

import java.io.*;

public class Bj_28050_최대공약수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] str = br.readLine().split(" ");
		long a = Long.parseLong(str[0]);
		long b = Long.parseLong(str[1]);
		
		long max = Math.max(a, b);
		long min = Math.min(a, b);
		
		while (min!=0) { // t가 a, b보다 더 커지면 중단
			long temp = min;
			min = max%min;
			max = temp; 
		}
		for (int i = 0; i < max; i++) {
			sb.append(1);
		} 
		System.out.println(sb);

	}
}
