import java.io.*;

public class JO_2577_회전초밥 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]); //벨트위 초밥 개수
		int d = Integer.parseInt(str[1]); //초밥의 가짓수
		int k = Integer.parseInt(str[2]); // 연속접시 수
		int c = Integer.parseInt(str[3]); // 쿠폰 번호
		int[] visit = new int[d+1];
		int[] belt = new int[N];
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0; //서로다른 초밥의 종류 개수
		for (int j = 0; j < k; j++) {
			if(visit[belt[j]]==0)cnt++;
			visit[belt[j]]++;
		}
		
		int max = cnt;
		
		for (int i = 0; i < N; i++) {
			visit[belt[i]]--;
			if(visit[belt[i]]==0) cnt--;
			if(visit[belt[(i+k)%N]]==0) cnt++;
			visit[belt[(i+k)%N]]++;
			
			if(visit[c]==0) {
				cnt++;
				max = Math.max(max, cnt);
				cnt--;
			}else {
				max = Math.max(max, cnt);
			}
		}
		System.out.println(max);
	}
}

