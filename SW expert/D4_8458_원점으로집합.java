import java.io.*;

public class D4_8458_원점으로집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int max = 0;
			int even = 0;
			int odd = 0;
			for (int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				int x = Integer.parseInt(str[0]);
				int y = Integer.parseInt(str[1]);
				int dist = Math.abs(x)+Math.abs(y);
				if(dist %2==0) even++;
				else odd++; 
				max = Math.max(max, dist);
			}
			int ans=0;
			if(even>0 && odd>0) {
				ans=-1;
			}else {
				int sum=0;
				while(!(sum >= max && (sum-max)%2==0)) {
					ans++;
					sum+= ans;
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
