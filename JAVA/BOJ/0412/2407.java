package ps;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]); int m = Integer.parseInt(str[1]);
        if(n==m) {
            System.out.println(1);
            return;
        }
        BigInteger tmp = new BigInteger("1");
        int max = 0; int min =0;
        if(n-m > m){
            max = n-m;
            min = m;
        }else{
            max = m;
            min = n-m;
        }
        for(int i=n; i> max ; i--){
            tmp = tmp.multiply(new BigInteger(i+""));
        }
        BigInteger ans = tmp.divide(factorial(min));
        System.out.println(ans);
    }
    static BigInteger factorial(int num){
        if(num==1) {
            return new BigInteger("1");
        }
        return new BigInteger(num+"").multiply(factorial(num-1));
    }
}


