package D0316;
import java.io.*;
import java.util.*;
public class BJ_1963_소수경로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] pri = new boolean[10000]; //소수인지 아닌지를 저장하는 배열 true이면 소수
		for (int i = 1000; i <10000; i++) {
			boolean ch = true;
			for (int j = 2; j <i ; j++) {
				if(i%j ==0) {
					ch = false;
					break;
				}
			}
			pri[i] = ch;
		}
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[]str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			int[] cnt = new int[10000]; //각 숫자를 만들기 위해 변경해야하는 횟수를 저장
			Arrays.fill(cnt, -1); //-1로 초기화
			Queue<int[]> que = new LinkedList<int[]>(); //탐색할 수들을 넣을 큐
			que.add(new int[] {start, 0}); 
			cnt[start] =0;
			while(!que.isEmpty()) {
				int[] t = que.poll();
				int num = t[0]; //소수
				int c = t[1]; //변경 횟수
				if(num==end) { //최종 숫자와 같으면 반복문 종료
					break;
				}
				for (int i = 1000; i < 10000; i++) { //범위의 모든 숫자를 돌면서
					if(pri[i] && cnt[i]==-1) {	//소수이면서 cnt가 -1인 것(아직 방문하지 않은 것)들만 
						if(oneDiff(num, i)) { //숫자 하나만 다른지 체크
							cnt[i] = c+1; //cnt배열에 값 업데이트 후
							que.add(new int[] {i, c+1}); //큐에 넣기
						}
					}
					
				}
			}
			if(cnt[end]==-1) System.out.println("Impossible");
			else System.out.println(cnt[end]);
		}
	}

	private static boolean oneDiff(int num, int i) { //한자리수만 다른지 체크
		String sn = Integer.toString(num);
		String si = Integer.toString(i);
		int ch =0;
		for (int j = 0; j < 4; j++) {
			if(sn.charAt(j) != si.charAt(j)) ch++;
		}
		if(ch==1) return true; //한자리수만 다르면 true
		return false; //아니면 false
	}
}
