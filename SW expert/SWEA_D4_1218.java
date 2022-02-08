import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_D4_1218 {

  public static void main(String[] args) throws FileNotFoundException {
    System.setIn(new FileInputStream("input_4th.txt"));
    Scanner sc = new Scanner(System.in);

    for (int test_case = 1; test_case <= 10; test_case++) {
      int N;
      N = sc.nextInt();
      char[] arr = new char[N];
      arr = sc.next().toCharArray();
      int result = check(arr);

      System.out.printf("#%d %d\n", test_case, result);
    }
  }

  public static int check(char[] arr) {
    Stack<Character> st = new Stack<Character>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{' || arr[i] == '<') {
        st.add(arr[i]);
      } else {
        if (
          (arr[i] == ')' && st.peek() == '(') ||
          (arr[i] == ']' && st.peek() == '[') ||
          (arr[i] == '}' && st.peek() == '{') ||
          (arr[i] == '>' && st.peek() == '<')
        ) {
          st.pop();
        } else {
          return 0;
        }
      }
    }

    if (st.size() > 0) {
      return 0;
    }
    return 1;
  }
}
