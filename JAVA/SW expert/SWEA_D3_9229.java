import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * N: 마트에 있는 과자 봉지 개수
 * M : 최대 가능한 무게
 * 두 개 선택
 */
public class SWEA_D3_9229 {

  public static int max;
  public static int N;
  public static int M;
  public static Integer[] snacks;

  public static void print(Integer[] arr) {
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws FileNotFoundException {
    System.setIn(new FileInputStream("input_D3_9229.txt"));
    Scanner sc = new Scanner(System.in);

    int tc = sc.nextInt();

    for (int test_case = 1; test_case <= tc; test_case++) {
      max = -1;
      N = sc.nextInt();
      M = sc.nextInt();
      snacks = new Integer[N];
      //과자 무게 배열에 저장하기
      for (int i = 0; i < N; i++) {
        snacks[i] = sc.nextInt();
      }

      //과자 무게를 내림차순으로 정렬
      Arrays.sort(snacks, Comparator.reverseOrder());

      //첫번째 원소부터 두개씩 골라서 더한 값이 M이하이고 현재 max값보다 더 크면 max값을 교체
      for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
          int sum = snacks[i] + snacks[j];
          if (sum <= M && sum > max) {
            max = sum;
            break;
          }
        }
      }

      System.out.printf("#%d %d\n", test_case, max);
    }
  }
}
