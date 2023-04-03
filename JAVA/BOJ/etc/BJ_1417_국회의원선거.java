package D0227;
import java.io.*;
import java.util.*;
public class BJ_1417_국회의원선거 {
	public static int max , idx;
	public static void findMax(int[] arr) { //다솜이 제외 하고 가장 큰 값과 그 사람의 인덱스 찾기
		max = -1;
		for (int i = 1; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
				idx = i;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] vote = new int[N];
		for (int i = 0; i < N; i++) {
			vote[i] =  Integer.parseInt(br.readLine());
		}
		findMax(vote); //가장 큰 표값 찾기
		int cnt =0;
		while(max >=  vote[0]) { //다솜이가 더 클 때까지 반복
			vote[0]++;
			vote[idx]--;
			cnt++;
			findMax(vote);
		}
		System.out.println(cnt);
		
	}
	
}
