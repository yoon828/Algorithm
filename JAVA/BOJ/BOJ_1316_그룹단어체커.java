import java.io.*;

public class BOJ_1316_그룹단어체커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt =0;
	out:for (int i = 0; i < N; i++) {
			boolean[] visit = new boolean[27];
			String str = br.readLine();
			visit[str.charAt(0)-'a'] = true;
			for (int j = 1; j < str.length(); j++) {
				if(str.charAt(j-1) != str.charAt(j)) {
					if(visit[str.charAt(j)-'a']) {
						continue out;
					}
					visit[str.charAt(j)-'a'] = true;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
