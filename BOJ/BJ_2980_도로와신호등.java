package D0227;
import java.io.*;
import java.util.*;
public class BJ_2980_도로와신호등 {
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 신호등 개수
			int L = Integer.parseInt(st.nextToken()); // 도로 길이 
			
			int time = 0;
			int temp =0 ;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int D =  Integer.parseInt(st.nextToken());
				int R =  Integer.parseInt(st.nextToken());
				int G =  Integer.parseInt(st.nextToken());
				int t = R+G; 
				time+= D-temp;
				temp = D;
				if(time % t < R && time%t !=0) { //빨간 불인 경우
					time+= R - (time % t); 
				}else if(time%t ==0) time+= R; //빨간불 파란불이 다 끝났으므로 빨간불인 상태임.
			}
			time += L-temp;
			
			System.out.println(time);
	}
}
