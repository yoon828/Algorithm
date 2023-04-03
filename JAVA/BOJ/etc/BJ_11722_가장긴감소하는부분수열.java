package D0302;
import java.io.*;
import java.util.StringTokenizer;
public class BJ_11722_가장긴감소하는부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] dpA = new int[N]; //오름차순 저장할 배열
		int[] dpD = new int[N]; //내림차순 저장할 배열
		
		 st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=  Integer.parseInt(st.nextToken());
			dpA[i] =1;
			dpD[i] =1;
		}
		
		for (int i = 0; i <N; i++) { //오름차순 dp생성 0~i까지
			for (int j = 0; j <i; j++) {
				if(arr[i] > arr[j]) {
					dpA[i] = Math.max(dpA[j]+1, dpA[i]);
				}
			}
		}
		
		for (int i = N-1; i >=0; i--) { //내림차순 dp생성 i~N
			for (int j = N-1; j > i; j--) {
				if(arr[i] > arr[j]) {
					dpD[i] = Math.max(dpD[j]+1, dpD[i]);
				}
			}
		}
		int max = 0; 
		for (int i = 0; i <N; i++) {
			max = Math.max(dpA[i]+dpD[i]-1, max);
		}
		
		System.out.println(max);
	}
}
