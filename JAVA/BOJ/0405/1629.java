import java.io.*;
import java.util.*;

public class Main {
    static int A, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        System.out.println(div(B));
    }
    public static long div(int b){
        if(b==1) return A%C;
        else{
            long ans=div(b/2)%C;
            if(b%2==0){
                return (ans*ans)%C;
            }else return (((ans*ans)%C)*A)%C;
        }
    }

}