package D0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10158_개미 {
	public static int w, h, t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		w = Integer.parseInt(st.nextToken()); // 열
		h = Integer.parseInt(st.nextToken()); // 행

		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken()); // 열 좌표
		int q = Integer.parseInt(st.nextToken()); // 행 좌표

		st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken()); // 시간
		
		int xt = t % (2*w); //열
		p= p% (2*w); //열 길이의 2배를 이동하면 제자리로 돌아오게 됨
		boolean flag = false;
		for (int i = 0; i < xt; i++) {
			//flag가 true인 경우에는 1씩 감소 , false인 경우에는 1씩 증가 벽에 부딪치는 경우를 구현
			if(!flag) p++;
			else p--; 
			if(p==w) flag=true;
			else if(p == 0 ) flag = false; 
		}
		int yt = t % (2*h); //행
		q= q% (2*h);
		flag = false;
		for (int i = 0; i < yt; i++) {
			if(!flag) q++;
			else q--; 
			if(q==h) flag=true;
			else if(q == 0 ) flag = false; 
		}
		System.out.println(p+" "+q);
	}
}
