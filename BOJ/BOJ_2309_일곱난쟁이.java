import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309_일곱난쟁이 {
	public static int[] nine;
	public static int[] seven;
	public static int N;
	public static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = 7;
		cnt=0;
		nine = new int[9];
		seven = new int[7];
		for (int i = 0; i < 9; i++) {
			nine[i] = sc.nextInt();
		}

		combi(0, 0, 0);

	}

	public static void combi(int idx, int start, int sum) {
		if(cnt>0) return;
		
		// 기저
		if(idx==N) {
			if(sum==100) {
				cnt++;
				Arrays.sort(seven);
				for (int i = 0; i < seven.length; i++) {
					System.out.println(seven[i]);
				}
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			seven[idx] = nine[i];
			combi(idx + 1, i + 1, sum+nine[i]);
		}

	}
}
