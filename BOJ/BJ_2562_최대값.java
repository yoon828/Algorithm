import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[]arr = new int[9];
        int max= 0;
        int maxIdx = 0;
        for(int i = 0 ;i< 9 ;i++){
            int n = sc.nextInt();
            if(max<n){
                max= n;
                maxIdx = i+1;
            }
        }
        System.out.println(max);
        System.out.println(maxIdx);
    }
}
