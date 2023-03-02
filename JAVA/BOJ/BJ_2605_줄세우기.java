import java.util.*;

public class BJ_2605_줄세우기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new LinkedList<Integer>();
		
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			int num = sc.nextInt();
			list.add((i-num-1), i);
		}
		for (Integer i : list) {
			System.out.print(i+" ");
		}
	}
	
}
