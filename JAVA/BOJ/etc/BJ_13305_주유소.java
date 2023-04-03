package study_Jan;

import java.io.*;
import java.util.*;

public class BJ_13305_주유소 {
	static String str = "4\r\n" + 
			"2 3 1\r\n" + 
			"5 2 4 1";
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new StringReader(str));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken())-1; //마지막 도시는 사용하지 않기 때문에 
		long[] dist = new long[N];
		long[] prices = new long[N];
		
		st = new StringTokenizer(br.readLine());
		//거리 정보 저장
		for (int i = 0; i < N; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
		
		//기름 정보 저장
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			prices[i] = Long.parseLong(st.nextToken());
		}
		long minOil = Long.MAX_VALUE; 
		long sum =0; 
		for (int i = 0; i < N; i++) {
			//만약 현재 minOil 보다 더 작은 기름값이 나오면 minOil을 교체 
			if(prices[i]< minOil) minOil = prices[i];
			//이전까지 도시들중에서 가장 작았던 기름 값 * 거리를 총합에 더해주기
			sum+= minOil * dist[i];
		}
		
		System.out.println(sum);
	}
}
