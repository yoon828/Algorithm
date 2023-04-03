package D0318;

import java.io.*;

public class BJ_2745_진법변환 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		String N = str[0];
		int B = Integer.parseInt(str[1]);
		int nn =N.length()-1;
		long n = 0;
		for (int i = 0; i <N.length(); i++) {
			char ch = N.charAt(i);
			long t =-1;
//			System.out.println(ch);
			if(ch >= 65 && ch <= 65+26) { //알파벳이면
//				System.out.println(Math.pow(B, nn--));
//				System.out.println((ch-55));
				t = (long) (Math.pow(B, nn--) * (ch-55));
			}else {
//				System.out.println(Math.pow(B, nn--));
//				System.out.println(ch-'0');
				t= (long) (Math.pow(B, nn--) * (ch-'0'));				
			}
			n+=t;
		}
		System.out.println(n);
	}

}
