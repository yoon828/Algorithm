import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_D3_1228 {

  public static void print(LinkedList<Integer> list) {
    for (int j = 0; j < 10; j++) {
      System.out.print(list.get(j) + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("input_D3_1228.txt"));
    Scanner sc = new Scanner(System.in);
    int tc = 10;

    for (int test_case = 1; test_case <= tc; test_case++) {
      LinkedList<Integer> li = new LinkedList<>();
      // 원본 암호문 길이 입력 받기
      int N = sc.nextInt();
      // 원본 암호문 내용 입력 받아서 list에 저장하기
      for (int i = 0; i < N; i++) {
        int num = sc.nextInt();
        li.add(num);
      }

      // 명령어 개수 입력 받기
      int command = sc.nextInt();
      // 명령어 개수 만큼 명령 실행
      for (int i = 0; i < command; i++) {
        // I 위치 개수 숫자들 => 총 3+n개
        String str = sc.next();
        if (str.equals("I")) {
          int x = sc.nextInt();
          int nums = sc.nextInt();
          // x 인덱스에 num만큼 숫자 추가하기
          for (int j = 0; j < nums; j++) {
            li.add(x++, sc.nextInt());
          }
        }
      }
      System.out.printf("#%d ", test_case);
      print(li);
    }
  }
}
