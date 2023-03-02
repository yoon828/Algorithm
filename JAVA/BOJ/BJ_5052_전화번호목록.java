import java.util.Arrays;
import java.util.Scanner;

public class BJ_5052_전화번호목록 {
	static String str = "2\r\n" + "3\r\n" + "911\r\n" + "97625999\r\n" + "91125426\r\n" + "5\r\n" + "113\r\n"
			+ "12340\r\n" + "123440\r\n" + "12345\r\n" + "98346";
	static String str1 = "1\r\n" + "2\r\n" + "01\r\n" + "10";

	public static void main(String[] args) {
		Scanner sc = new Scanner(str);
//		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			long startT = System.nanoTime();
			String ans = "YES";
			int n = sc.nextInt();
			String[] nums = new String[n];

			for (int i = 0; i < n; i++) {
				nums[i] = sc.next();
			}

			Arrays.sort(nums);

			for (int i = 0; i < n - 1; i++) {
				String s = nums[i]; // 접두 번호
				int sn = s.length();
				if(sn > nums[i+1].length()) continue;
				if (nums[i + 1].substring(0, sn).equals(s)) {
					ans = "NO";
					break;
				}
			}

			System.out.println(ans);
			long endT = System.nanoTime();
			System.out.println((endT - startT) / 1000000000.0);
		}
	}

}
