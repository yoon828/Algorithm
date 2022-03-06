package D0306;
import java.io.*;
import java.util.Arrays;

public class BJ_11651_좌표정렬하기2 {
	static class Position implements Comparable<Position>{
		int x, y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Position o) {
			return y==o.y? x-o.x: y-o.y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Position[] pList = new Position[N];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			pList[i] = new Position(x, y);
		}
		Arrays.sort(pList);
		
		for (Position p : pList) {
			System.out.println(p.x+" "+p.y);
		}
	}

}