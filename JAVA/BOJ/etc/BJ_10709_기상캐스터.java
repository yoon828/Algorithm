package D0227;

import java.io.*;
import java.util.*;

public class BJ_10709_기상캐스터 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int H = Integer.parseInt(str[0]); // 행
		int W = Integer.parseInt(str[1]); // 열

		for (int i = 0; i < H; i++) {
			String s = br.readLine();
			int time = -1;
			for (int j = 0; j < W; j++) {
				if (s.charAt(j) == 'c')
					time = 0;
				else if(time != -1) time++;
				System.out.print(time + " ");
			}
			System.out.println();
		}
	}
}
