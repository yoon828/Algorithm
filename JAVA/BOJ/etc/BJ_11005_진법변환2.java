package D0318;

import java.io.*;

public class BJ_11005_진법변환2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] jin = new String[36];
		for (int i = 0; i < 36; i++) {
			if(i<10) jin[i] = Integer.toString(i);
			else jin[i] = Character.toString((char)(65+i-10));
		}
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int B = Integer.parseInt(str[1]);
		while(N!=0) {
			sb.insert(0,jin[N%B]);
			N = N/B;
		}
		
		System.out.println(sb);
	}
}
