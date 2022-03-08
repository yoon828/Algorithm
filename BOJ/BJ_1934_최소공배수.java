package D0308;
import java.io.*;


public class BJ_1934_최소공배수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b =Integer.parseInt(str[1]);
			
			int t = 2;
			int ans =1;
			while(a >=t || b>=t) {
				if(a%t==0 && b%t ==0) {
					ans*=t;
					a=a/t;
					b=b/t;
					t=1;
				}
				t++;
			}
			if(a>0) ans*=a;
			if(b>0) ans*=b;
			System.out.println(ans);
		}
		
	}
}
