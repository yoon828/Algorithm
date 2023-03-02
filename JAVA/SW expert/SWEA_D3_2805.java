import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_D3_2805 {

  public static void print(char[][] arr) {
    for (char[] i : arr) {
      for (char cs : i) {
        System.out.print(cs + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    System.setIn(new FileInputStream("input_D3_농작물수확하기.txt"));
    Scanner sc = new Scanner(System.in);

    int tc = sc.nextInt();

    for (int i = 1; i <= tc; i++) {
      int N = sc.nextInt();
      char[][] arr = new char[N][N];
      //한줄씩 입력 받아서 char 배열로 저장
      for (int j = 0; j < arr.length; j++) {
        arr[j] = sc.next().toCharArray();
      }

      int sum = 0;
      int mid = N / 2;
      for (int j = 0; j < arr.length; j++) {
        for (int k = 0; k < arr.length; k++) {
          //수확가능한 지역인지 확인 후 가능하면 sum에 더하기
          if (Math.abs(mid - k) <= mid - Math.abs(mid - j)) {
            sum += arr[j][k] - '0';
          }
        }
      }
      System.out.printf("#%d %d\n", i, sum, N);
    }
  }
}
