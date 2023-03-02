import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_D3_1289 {

  public static void main(String[] args) throws FileNotFoundException {
    System.setIn(new FileInputStream("input_D3_1289_원재의메모리복구하기.txt"));
    Scanner sc = new Scanner(System.in);

    int tc = sc.nextInt();

    for (int i = 1; i <= tc; i++) {
      // 원래 메모리 저장
      String s = sc.next();
      // 메모리 길이 저장
      int l = s.length();
      //원래 메모리를 char 배열로 변경
      char[] arr = s.toCharArray();

      //변경 횟수를 카운트할 변수
      int count = 0;
      //이전 값을 저장할 변수
      char temp = '0';

      for (int j = 0; j < l; j++) {
        if (arr[j] != temp) {
          count++;
          temp = arr[j];
        }
      }
      System.out.printf("#%d %d\n", i, count);
    }
  }
}
