import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class D3_6808_규영이와인영이의카드게임 {
	public static int[] cards1; // 규영이의 카드 정보
	public static int[] cards2; //인영이의 카드 정보
	public static int[] temp; //순열 임시 배열
	public static int win; //이긴 횟수
	public static int lose; //진 횟수

	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new FileInputStream("input_D3_6808.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			boolean[] isSel = new boolean[19];
			cards1 = new int[9]; // 규영이의 카드 정보
			cards2 = new int[9]; // 인영이의 카드 정보
			temp = new int[9];
			win =0; 
			lose =0; 
			//입력 받은 순서대로 배열에 저장
			for (int i = 0; i < 9; i++) {
				cards1[i] = sc.nextInt();
				isSel[cards1[i]] = true;
			}

			int idx = 0;
			//규영이가 가지고 있는 카드를 제외한 나머지 카드를 인영이에게 저장
			for (int i = 1; i < isSel.length; i++) {
				if (isSel[i] == false)
					cards2[idx++] = i;
			}
			//순열 생성 시작
			permu(0,0);

			System.out.printf("#%d %d %d\n", test_case, win, lose);
		}

	}

	// 순열
	public static void permu(int cnt, int flag) {
		// 기저 
		//순열이 완성되면 게임하기 
		if (cnt == 9) {
			game(temp);
			return;
		}

		for (int i = 0; i < 9; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			temp[cnt] = cards2[i];
			permu(cnt + 1, flag | 1 << i);
		}

	}

	private static void game(int[] temp) {
		int sum1 =0; //규영이의 점수 합
		int sum2 =0; //인영이의 점수 합
		
		//9번  카드의 값을 비교해서 승부에 맞게 sum 변수에 더하기
		for (int i = 0; i < 9; i++) {
			if(cards1[i] > temp[i]) {
				sum1 += cards1[i]+ temp[i];
			}else {
				sum2 += cards1[i]+ temp[i];
			}
		}
		
		if(sum1 > sum2) { //규영이가 이긴 경우 
			win++;
		}else { //진경우
			lose++;
		}
		
	}
}
