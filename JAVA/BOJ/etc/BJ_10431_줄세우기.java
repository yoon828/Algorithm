package D0227;

import java.io.*;
import java.util.*;

public class BJ_10431_줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			List<Integer> list = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int sum = 0;
			for (int i = 0; i < 20; i++) {
				int t = Integer.parseInt(st.nextToken());
				int size = list.size();
				boolean check = false; 
				for (int j = 0; j < size; j++) {
					if (t < list.get(j)) {
						list.add(j, t);
						sum += (size - j);
						check = true; 
						break;
					}
				}
				if(!check)list.add(t);
			}
			System.out.println(test_case + " " + sum);
		}

	}
}
