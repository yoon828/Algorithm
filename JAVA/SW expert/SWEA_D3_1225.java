import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 암호의 자리는 8자리
 * 가장 앞자리 1 감소 후 맨 뒤로 보내기
 * 감소한 값이 0이하인 경우 루프 종료 후 암호 출력
 */

public class SWEA_D3_1225 {

  public static void print(Queue<Integer> que) {
    for (Integer t : que) {
      System.out.print(t + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws FileNotFoundException {
    System.setIn(new FileInputStream("input_D3_1225.txt"));
    Scanner sc = new Scanner(System.in);
    int N = 8;

    for (int test_case = 1; sc.hasNext(); test_case++) {
      Queue<Integer> queue = new LinkedList<Integer>();
      sc.nextInt();
      for (int i = 0; i < N; i++) {
        queue.offer(sc.nextInt());
      }
      int cnt = 0;
      while (true) {
        int first = queue.poll() - ((cnt++ % 5) + 1);
        first = (first >= 0) ? first : 0;
        queue.offer(first);
        if (first == 0) {
          break;
        }
      }
      System.out.printf("#%d ", test_case);
      print(queue);
    }
  }
}
