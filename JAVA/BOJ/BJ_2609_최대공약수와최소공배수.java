package D0305;

import java.io.*;
import java.util.*;

public class BJ_2609_최대공약수와최소공배수 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int i = 2;
		int max = 1;
		while (true) {
			if(i>a|| i>b) break;
			if(a%i ==0 && b%i==0) {
				max*= i;
				a/=i;
				b/=i;
				i=1;
			}
			i++;
		}
		System.out.println(max);
		System.out.println(max * a*b);
	}
}
