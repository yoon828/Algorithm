import java.util.*;

public class Main {
    public static int d(int i){
        int sum= i;
        while(i>0){
            sum+= i%10;
            i = i/10;
        }
        return sum;
    }
	public static void main(String[] args) {
        boolean[] check = new boolean[10001];
        for(int i =0; i<10000; i++){
            int t = d(i);
            if(t<=10000 && !check[t]) check[t] =true;
        }
        for(int i =0; i<=10000; i++){
            if(!check[i]) System.out.println(i);
        }
    }
}


