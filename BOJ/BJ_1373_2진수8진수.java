package D0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1373_2진수8진수 {
	public static void main(String[] args) throws IOException {
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		   StringBuilder ans = new StringBuilder();
		   StringBuilder str = new StringBuilder(br.readLine());
		   while(str.length()>=3) {
			   char ch0 = str.charAt(str.length()-1);
			   char ch1 = str.charAt(str.length()-2);
			   char ch2 = str.charAt(str.length()-3);
			   int sum =0;
			   if(ch0 !='0') sum+= 1;
			   if(ch1 !='0') sum+= 2;
			   if(ch2 !='0') sum+= 4;
			   ans.append(sum);
			   str.setLength(str.length()-3);
		   }
		   if(str.length()==2) {
			   char ch0 = str.charAt(str.length()-1);
			   char ch1 = str.charAt(str.length()-2);
			   int sum =0;
			   if(ch0 !='0') sum+= 1;
			   if(ch1 !='0') sum+= 2;
			   ans.append(sum);
		   }else if(str.length()==1) {
			   if(str.charAt(0)!= '0') ans.append(1);
		   }
		   if(ans.length()==0) ans.append(0);
		   System.out.println(ans.reverse());
	}

}
