import java.io.*;

public class BJ_1065_한수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt=0;
		for (int i = 1; i <= N; i++) {
			if(check(i)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static boolean check(int i) {
		if(i<10) return true;
		String n  = Integer.toString(i);
		int gap = (n.charAt(0)-'0')- (n.charAt(1)-'0');
		for (int j = 0; j < n.length()-1; j++) {
			if(((n.charAt(j)-'0')- (n.charAt(j+1)-'0')) != gap) return false;
		}
		return true;
	}

}
