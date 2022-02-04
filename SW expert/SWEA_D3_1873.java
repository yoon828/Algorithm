import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*

.	평지(전차가 들어갈 수 있다.)
*	벽돌로 만들어진 벽
#	강철로 만들어진 벽
-	물(전차는 들어갈 수 없다.)
^	위쪽을 바라보는 전차(아래는 평지이다.)
v	아래쪽을 바라보는 전차(아래는 평지이다.)
<	왼쪽을 바라보는m 전차(아래는 평지이다.)
>	오른쪽을 바라보는 전차(아래는 평지이다.)


U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다


- 전차가 이동하려고 할 때 
맵 밖이거나, 벽이 있으면 이동하지 않는다. 
- 포탄을 발사하면, 
벽돌벽일때는 벽돌벽이 평지가 된다. / 강철일때는 벽에 충돌 후 아무것도 일어나지 않는다. / 아무것도 없을때는 직진한다.

0:위  
1:아래
2:왼쪽
3:오른쪽


1. 현재 위치 찾아서 위치(x,y)와 방향(dir) 저장하기
2. 명령을 하나씩 실행하기
3. UDLR인 경우 각 방향에 맞게 회전하기 => 회전후 해당 방향 앞 칸이 평지라면 한칸 이동하기 / 평지가 아니라면 아무것도 안하기
4. S인 경우 어느 방향을 보고 있는지 확인 후 , 해당 방향으로 탐색하기
 => 아무것도 없으면 아무일도 안일어남/ 강철벽이 있다면 탐색 종료/ 벽돌 벽이라면 벽돌 벽을 평지로 변경 후 탐색 종료
 
 */

public class SWEA_D3_1873 {

  public static void print(char[][] arr) {
    for (char[] i : arr) {
      for (char cs : i) {
        System.out.print(cs);
      }
      System.out.println();
    }
  }

  // 회전하기 & 회전후 해당 방향 앞 칸이 평지라면 한칸 이동하기 / 평지가 아니라면 아무것도 안하기
  public static char[][] move(
    char[][] arr,
    int dir,
    int i,
    int j,
    int[] dr,
    int[] dc,
    char[] four
  ) {
    // 방향 회전
    arr[i][j] = four[dir];

    // 앞 칸 확인
    // 맵 범위 안에 있는지 확인 0이하가 아닌지 확인. v와 >인 경우에는 H, W를 넘어가지 않는지 확인
    if (
      i + dr[dir] >= 0 &&
      j + dc[dir] >= 0 &&
      i + dr[dir] < arr.length &&
      j + dc[dir] < arr[0].length
    ) {
      // 앞칸이 평지인지 확인
      if (arr[i + dr[dir]][j + dc[dir]] == '.') {
        // 평지라면 원래 있던 자리는 평지로 만들고 앞으로 한칸 이동
        arr[i][j] = '.';
        arr[i + dr[dir]][j + dc[dir]] = four[dir];
      }
    }
    return arr;
  }

  // S인 경우 어느 방향을 보고 있는지 확인 후 , 해당 방향으로 탐색하기
  // => 아무것도 없으면 아무일도 안일어남/ 강철벽이 있다면 탐색 종료/ 벽돌 벽이라면 벽돌 벽을 평지로 변경 후 탐색 종료
  public static char[][] shoot(
    char[][] arr,
    int dir,
    int i,
    int j,
    int[] dr,
    int[] dc
  ) {
    i = i + dr[dir];
    j = j + dc[dir];
    while (i >= 0 && j >= 0 && i < arr.length && j < arr[0].length) {
      if (arr[i][j] == '#') {
        break;
      } else if (arr[i][j] == '*') {
        arr[i][j] = '.';
        break;
      }

      i = i + dr[dir];
      j = j + dc[dir];
    }

    return arr;
  }

  //			// 1. 현재 위치와 방향 찾기

  public static int[] current(char[][] arr) {
    //index 0: x, 1: y, 2: dir
    int[] temp = new int[3];

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        char ch = arr[i][j];
        if (ch == '^' || ch == 'v' || ch == '<' || ch == '>') {
          temp[0] = i;
          temp[1] = j;
          if (ch == '^') {
            temp[2] = 0;
          } else if (ch == 'v') {
            temp[2] = 1;
          } else if (ch == '<') {
            temp[2] = 2;
          } else if (ch == '>') {
            temp[2] = 3;
          }
        }
      }
    }

    return temp;
  }

  public static void main(String[] args) throws FileNotFoundException {
    System.setIn(new FileInputStream("input_D3_1873.txt"));
    Scanner sc = new Scanner(System.in);

    int tc = sc.nextInt();

    // 위, 아래, 왼, 오른 순서
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };
    char[] four = { '^', 'v', '<', '>' };

    for (int test_case = 1; test_case <= tc; test_case++) {
      int H = sc.nextInt();
      int W = sc.nextInt();
      char[][] arr = new char[H][W];
      // 한줄씩 입력 받아서 char 배열로 저장
      for (int j = 0; j < arr.length; j++) {
        arr[j] = sc.next().toCharArray();
      }
      // 명령 횟수 입력 받기
      int N = sc.nextInt();
      char[] com = sc.next().toCharArray();

      // 1. 현재 위치와 방향 찾기
      int x = current(arr)[0];
      int y = current(arr)[1];
      int dir = current(arr)[2];

      // 2. 명령을 하나씩 실행하기
      for (int i = 0; i < N; i++) {
        // 3. UDLR인 경우 각 방향에 맞게 회전하기 => 회전후 해당 방향 앞 칸이 평지라면 한칸 이동하기 / 평지가 아니라면 아무것도 안하기
        if (com[i] == 'U') {
          arr = move(arr, 0, x, y, dr, dc, four);
        } else if (com[i] == 'D') {
          arr = move(arr, 1, x, y, dr, dc, four);
        } else if (com[i] == 'L') {
          arr = move(arr, 2, x, y, dr, dc, four);
        } else if (com[i] == 'R') {
          arr = move(arr, 3, x, y, dr, dc, four);
        }
        // 4. S인 경우 어느 방향을 보고 있는지 확인 후 , 해당 방향으로 탐색하기
        // => 아무것도 없으면 아무일도 안일어남/ 강철벽이 있다면 탐색 종료/ 벽돌 벽이라면 벽돌 벽을 평지로 변경 후 탐색 종료
        else if (com[i] == 'S') {
          shoot(arr, dir, x, y, dr, dc);
        }
        x = current(arr)[0];
        y = current(arr)[1];
        dir = current(arr)[2];
      }

      System.out.print("#" + test_case + " ");
      print(arr);
    }
  }
}
