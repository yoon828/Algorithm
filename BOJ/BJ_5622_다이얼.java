 

import java.io.*;

public class BJ_5622_다이얼 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		int sum=0;

		for (int i = 0; i < str.length(); i++) {

			sum+=1;

			char ch = str.charAt(i);

			if(ch>= 'A' && ch<= 'C') sum+=2;

			else if(ch>= 'D' && ch<= 'F') sum+=3;

			else if(ch>= 'G' && ch<= 'I') sum+=4;

			else if(ch>= 'J' && ch<= 'L') sum+=5;

			else if(ch>= 'M' && ch<= 'O') sum+=6;

			else if(ch>= 'P' && ch<= 'S') sum+=7;

			else if(ch>= 'T' && ch<= 'V') sum+=8;

			else if(ch>= 'W' && ch<= 'Z') sum+=9;

		}

		System.out.println(sum);

	}
}
