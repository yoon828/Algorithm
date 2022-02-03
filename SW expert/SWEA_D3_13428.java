import java.util.Arrays;
import java.util.Scanner;

public class SWEA_D3_13428 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int tc = in.nextInt();

    //테스트케이스만큼 실행
    for (int i = 0; i < tc; i++) {
      String num = in.next();
      int[] arrNum = new int[num.length()];
      //받아온 정수를 int 배열에 넣기
      for (int j = 0; j < num.length(); j++) {
        arrNum[j] = num.charAt(j) - '0';
      }
      //오름차순으로 정렬
      Arrays.sort(arrNum);
      int max = arrNum[arrNum.length - 1];
      int min = 0;
      for (int j : arrNum) {
        if (j == 0) {
          continue;
        } else {
          min = j;
          break;
        }
      }

      //만들 수 있는 최소값
      int index = num.indexOf(String.valueOf(min));
      String minValue =
        (
          index == 0
            ? num
            : min +
            num.substring(1, index) +
            num.charAt(0) +
            num.substring(index + 1)
        );
      //만들 수 있는 최대값
      index = num.indexOf(String.valueOf(max));
      String maxValue =
        (
          index == 0
            ? num
            : max +
            num.substring(1, index) +
            num.charAt(0) +
            num.substring(index + 1)
        );
      System.out.printf("#%d %s %s\n", i + 1, minValue, maxValue);
    }
  }
}
