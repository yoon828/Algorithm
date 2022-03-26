import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4344_평균은넘겠지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int [] score = new int[N];
			int sum  =0;
			for (int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				sum+=score[i];
			}
			double avg = sum/(double)N;
			int cnt=0;
			for (int i = 0; i < N; i++) {
				if(avg<score[i]) cnt++;
			}
			double rat = cnt/(double)N *100;
			System.out.printf("%.3f", rat);
			System.out.println("%");
		}
	}
}
