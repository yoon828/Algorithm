import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 1. 최저온도 순으로 정렬하기
 * 2. 처음부터 탐색하면서 최고 온도의 최저(m)를 저장.
 * 3. 만약 현재 최저온도가  m보다 더 크다면 cnt+1 하고 m을 현재 최고 온도로 바꾸기
 * 
 */
public class JO_1828_냉장고 {
	//화학 물질 저장할 클래스
	public static class Chemistry implements Comparable<Chemistry> {
		int min, max;

		public Chemistry(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}

		@Override
		//최저온도 순으로 비교하고 최저온도가 같다면 최고 온도순으로 비교하기
		public int compareTo(Chemistry o) {
			return ((this.min != o.min) ? this.min - o.min : this.max - o.max);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Chemistry[] list = new Chemistry[N];

		for (int i = 0; i < N; i++) {
			list[i] = new Chemistry(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(list); //정렬
		
		int cnt=1; 
		int m = 10000; //최고온도가 10000도이기 때문에
		for (int i = 0; i < N; i++) {
			m = Math.min(list[i].max, m); //2. 
			if(m < list[i].min) { //3.
				cnt++;
				m = list[i].max;
			}
		}
		System.out.println(cnt);
	}
}
