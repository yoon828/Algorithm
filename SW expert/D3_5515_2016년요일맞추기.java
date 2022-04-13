import java.io.*;

public class D3_5515_2016년요일맞추기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] month = new int[13];
		month[1] = 4;
		for (int i = 2; i <= 12; i++) {
			if(i-1 == 2) {
				month[i] = (month[i-1]+29)%7;
			}else if(i-1 == 1 ||i-1 == 3||i-1 == 5||i-1 == 7||i-1 == 8||i-1 == 10) {
				month[i] = (month[i-1]+31)%7;
			}else
				month[i] = (month[i-1]+30)%7;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] str = br.readLine().split(" ");
			int m = Integer.parseInt(str[0]);
			int d = Integer.parseInt(str[1]);
			int ans =(month[m]+d-1)%7;
			System.out.printf("#%d %d\n",tc, ans);
		}
	}
}
