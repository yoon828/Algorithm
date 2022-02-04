import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 배열에서 최대값 돌려주는 함수 만드릭
// 배열에서 최소값 리턴하는 함수 만들기
// 최대값과 최소값을 비교해서 2이상이면 최대값을 -1 하고 최소값을 +1 한다
//
public class SWEA_D3_1208 {

  public static void print(int[] arr) {
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static int findMax(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int i : arr) {
      if (i > max) {
        max = i;
      }
    }
    return max;
  }

  public static int findMin(int[] arr) {
    int min = Integer.MAX_VALUE;
    for (int i : arr) {
      if (i < min) {
        min = i;
      }
    }
    return min;
  }

  public static int findIndex(int[] arr, int value) {
    int index = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == value) {
        index = i;
        break;
      }
    }

    return index;
  }

  public static void main(String[] args) throws FileNotFoundException {
    System.setIn(new FileInputStream("input_Flatten.txt"));
    Scanner in = new Scanner(System.in);

    int tc = 10;
    int dif = -1;
    for (int i = 1; i <= tc; i++) {
      System.out.println("#tc : " + i);
      int[] arr = new int[100];
      int count = in.nextInt();
      // 배열에 입력값 넣기
      for (int j = 0; j < arr.length; j++) {
        arr[j] = in.nextInt();
      }

      for (int j = 0; j < count; j++) {
        int max = findMax(arr);
        int min = findMin(arr);
        // 배열의 최대값 - 최소값이 1보다 더 크다면
        if (max - min > 1) {
          //배열의 최대값의 인덱스를 찾아서 1을 감소하고
          arr[findIndex(arr, max)]--;
          //최소값의 인덱스를 찾아서 1을 증가
          arr[findIndex(arr, min)]++;
        } else {
          //1이내이면 평탄화 작업이 완료된 것이기 때문에 break로 반복문 빠져나오기
          break;
        }

        dif = findMax(arr) - findMin(arr);
      }
      System.out.printf("#%d %d\n", i, dif);
    }
  }
}
