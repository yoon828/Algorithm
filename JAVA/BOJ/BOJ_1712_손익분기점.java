import java.io.*;

public class BOJ_1712_손익분기점 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		String[] str = br.readLine().split(" ");
		int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int C = Integer.parseInt(str[2]);
        if(B>=C){
            sb.append(-1);
        }else{
            sb.append(A/(C-B)+1);
        }
        System.out.println(sb);
	}
}
