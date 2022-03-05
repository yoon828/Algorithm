package D0305;

import java.io.*;
import java.util.*;

public class BJ_2751_수정렬하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		list.add(Integer.parseInt(br.readLine()));
		for (int i = 1; i <N; i++) {
			int n = Integer.parseInt(br.readLine());
			int ch = 0;
			for (int j = 0; j < list.size(); j++) {
				if(n<list.get(j)) {
					list.add(j, n);
					ch++;
					break;
				}
			}
			if(ch==0) list.add(n);
			
		}
		
		for (Integer i : list) {
			System.out.println(i);
		}
	}

}
