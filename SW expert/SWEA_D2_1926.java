import java.util.Scanner;

public class SWEA_D2_1926 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        for (int i = 1; i < N + 1; i++) {
            String toStr = Integer.toString(i);
            if (toStr.contains("3") || toStr.contains("6") || toStr.contains("9")) {
                for (int j = 0; j < toStr.length(); j++) {
                    int num = (int) (toStr.charAt(j) - '0');
                    if (num==3 ||num==6||num==9) {
                        System.out.print('-');
                    }
                }
                
            } else {
                System.out.print(toStr);
            }
            System.out.print(" ");
        }
    }
}
