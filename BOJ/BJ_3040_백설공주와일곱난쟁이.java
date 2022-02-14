import java.util.Scanner;

public class BJ_3040_백설공주와일곱난쟁이 {
	public static int[] nine;
	public static int[] seven;
	public static int N = 7;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		nine = new int[9];
		seven = new int[7];
		for (int i = 0; i < nine.length; i++) {
			nine[i] = sc.nextInt();
		}
		
		combi(0,0);
	}


	private static void combi(int cnt, int start) {
		
		if(cnt == N) { //조합 완성
			int sum =0 ;
			for (int i = 0; i < seven.length; i++) {
				sum+=seven[i];
			} 
			if(sum==100) {
				for (int i = 0; i < seven.length; i++) {
					System.out.println(seven[i]);
				}
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			seven[cnt] = nine[i];
			combi(cnt+1, i+1);
		} 
		
	}
	
}
