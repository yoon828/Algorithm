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
			
			int t = 2; //나눌 수
			int ans =1; //최소공배수를 저장할 변수
			while(a >=t || b>=t) { //t가 a, b보다 더 커지면 중단
				if(a%t==0 && b%t ==0) { //두 개의 수의 약수인지 확인
					ans*=t;
					a=a/t;
					b=b/t;
					t=1;
				}
				t++;
			}
			if(a>0) ans*=a; //마지막에 남아있는 수까지 곱해주기
			if(b>0) ans*=b; 
			System.out.println(ans);
		}
		
	}
}
