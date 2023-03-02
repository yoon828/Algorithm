import java.util.Scanner;

public class BJ_2491_수열 {
	public static String str = "9\r\n" + "1 2 2 4 4 5 7 7 2";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(str);

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int ans = 0; 
		int greater = 1; 
		int smaller = 1; 
		
		for (int i = 0; i < n-1; i++) {
			//연속해서 커지는 경우
			if(arr[i] <= arr[i+1]) greater++;
			else {
				ans= Math.max(greater, ans);
				greater=1;
			}
			
			//연속해서 작아지는 경우
			if(arr[i] >= arr[i+1]) smaller++;
			else {
				ans= Math.max(smaller, ans);
				smaller=1;
			}
		}
		ans = Math.max(ans, Math.max(greater,smaller));
		
		System.out.println(ans);
	}
}
