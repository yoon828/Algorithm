import java.util.Scanner;

/**
 * SWEA_D1_2072
 */
public class SWEA_D1_2072 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {
      int sum = 0;
      for (int i = 0; i < 10; i++) {
        int num = Integer.parseInt(sc.next());
        if (num % 2 != 0) {
          sum += num;
        }
      }
      System.out.printf("#%d %d\n", test_case, sum);
    }

    sc.close();
  }
}
