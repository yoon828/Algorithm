import java.util.*;

/*
 * N : 재료 개수
 * S : 신 맛 (곱)
 * B : 쓴 맛 (합)
 * 신맛과 쓴맛의 차이가 적게 
 * 재료는 적어도 하나, 부분 집합
 *
 */
public class BJ_2961_도영이가만든맛있는음식 {
	public static boolean[] isSelected;
	public static int N;
	public static int gap;
	public static List<int[]> list;
	public static List<int[]> selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		list = new ArrayList<int[]>();
		selected = new ArrayList<int[]>();
		isSelected = new boolean[N];
		gap = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			int s = sc.nextInt();
			int c = sc.nextInt();
			list.add(new int[] { s, c });
		}

		subset(0);

		System.out.println(gap);
	}

	private static void subset(int cnt) {
		if (cnt == N) { // 부분집합 완성
			selected = new ArrayList<int[]>();
			
			for (int i = 0; i < N; i++) {
				if (isSelected[i] == true) {
					selected.add(list.get(i));
				}
			}
			cooking(selected);
			return;
		}
		isSelected[cnt] = true;
		subset(cnt + 1);
		isSelected[cnt] = false;
		subset(cnt + 1);

	}

	private static void cooking(List<int[]> li) {
		if(li.size() ==0) return;
		int sour = 1;
		int bitter = 0;
		for (int i = 0; i < li.size(); i++) {
//			System.out.println(Arrays.toString(li.get(i)));
			sour *= li.get(i)[0];
			bitter += li.get(i)[1];
		}
		int g = Math.abs(sour - bitter);
		gap = Math.min(gap, g);
	}

}
