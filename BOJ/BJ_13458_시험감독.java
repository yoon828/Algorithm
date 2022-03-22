package D0322;

import java.io.*;

public class BJ_13458_시험감독 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr =new int[N];
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		String[] t = br.readLine().split(" ");
		int B = Integer.parseInt(t[0]);
		int C = Integer.parseInt(t[1]);
		long sum = 0;
		for (int i = 0; i < N; i++) {
			int n = arr[i];
			sum++; //총감독관 1명 추가
			n = n-B;
			if(n>0) sum+= n % C == 0? n/C: n/C + 1;
		}
		System.out.println(sum);
	}
}
