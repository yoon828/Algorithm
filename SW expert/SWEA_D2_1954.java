import java.util.Scanner;

//1. 배열의 크기 입력 받아서 2차원 배열 형성
//2. 재귀함수로 구현
//3. 한방향으로 가다가 존재하지 않거나, 값이 이미 들어가 있으면(0이외의 수) 방향을 회전해서 반복
//4. 기저조건 : 방향을 회전해도 값을 넣을 수 없을때 때 끝
public class SWEA_D2_1954 {

  // 2차원 배열 출력하는 함수
  public static void print(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  // 2차원 배열 0으로 초기화
  public static int[][] init(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        arr[i][j] = 0;
      }
    }
    return arr;
  }

  public static int[][] snail(int[][] arr, int dir, int num, int i, int j) {
    int[] dr = { 0, 1, 0, -1 };
    int[] dc = { 1, 0, -1, 0 };
    int N = arr.length;

    // 유도 파트
    /*
     * 만약 해당 위치가 존재하지 않거나(N을 벗어남), 해당 위치에 값이 존재하다면 방향을 회전 회전을 한 자리도 값이 존재한다면 return,
     * 그렇지 않으면 재귀호출
     *
     * 그게 아니라면 해당 위치에 값을 넣고, 같은 방향으로 재귀 호출
     */

    // 다음 방향
    int nextDir = (dir + 1) % 4;
    // 현재 위치가 크기 내에 있고, 값이 없는 상태인지 확인
    if (i < N && j < N && arr[i][j] == 0) {
      // 현재 위치가 값을 넣기
      arr[i][j] = num++;
      // 다음 위치가 크기 내에 있고 값이 없는 상태인지 확인
      if (
        i + dr[dir] < N &&
        i + dr[dir] >= 0 &&
        j + dc[dir] < N &&
        j + dc[dir] >= 0 &&
        arr[i + dr[dir]][j + dc[dir]] == 0
      ) {
        // 그러면 같은 방향으로 재귀 호출
        snail(arr, dir, num, i + dr[dir], j + dc[dir]);
      } else {
        // 아니면 방향을 바꿔서 재귀호출
        snail(arr, nextDir, num, i + dr[nextDir], j + dc[nextDir]);
      }
    }

    return arr;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int tc = in.nextInt();

    for (int i = 1; i <= tc; i++) {
      int N = in.nextInt();
      int num = 1;
      int[][] arr = new int[N][N];
      arr = init(arr);

      arr = snail(arr, 0, num, 0, 0);
      System.out.println("#" + i);
      print(arr);
    }
  }
}
