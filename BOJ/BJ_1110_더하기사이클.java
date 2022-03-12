package D0312;

import java.util.*;

public class BJ_1110_더하기사이클 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int temp = n; 
		int cnt= 0;
		while(true) {
			cnt++;
			if(temp<10) {
				temp += 10*temp ;
			}else {
				  int ten = temp/10;
				  int one = temp%10;
				  temp = one *10 + ((ten+one)%10);
			}
			if(temp== n) break;
		}
		System.out.println(cnt);
	}

}
