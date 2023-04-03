package D0227;
import java.io.*;
import java.util.*;
public class BJ_2840_행운의바퀴 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char [] cycle = new char[N];
		Arrays.fill(cycle, '0'); //'0'으로 배열 초기화
		
		boolean[] check = new boolean[26]; //사용 체킹 배열
		int idx =0;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			char alp = st.nextToken().charAt(0);
			idx = (idx+ cnt) % N; 
			if( cycle[idx] != alp &&  (cycle[idx] != '0'|| check[alp-'A'])) { //1. 현재 자리가 '0'이 아닌데 나와 다른 경우 2. 사용한 알파벳인데 나와 다른 경우 종료
				System.out.println('!');
				return;
			}
				cycle[idx] = alp;
				check[alp-'A']=true; //사용 체크
		}
		for (int i = 0; i < N; i++) {
			if(cycle[idx]!='0')	System.out.print(cycle[idx]);
			else System.out.print("?");
			idx = (idx -1 +N)%N ;
		}
		
	}
}
