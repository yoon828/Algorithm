import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10809_알파벳찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S =br.readLine();
        int[] f = new int[26];
        Arrays.fill(f, -1);
        for (int i = 0; i < S.length(); i++) {
            int idx = S.charAt(i)-'a';
            if(f[idx] == -1) {
                f[S.charAt(i)-'a'] = i;
            }
        }
        for (int i : f) {
            System.out.print(i+" ");
        }

    }
}
